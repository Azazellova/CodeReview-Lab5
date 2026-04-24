package ru.mazur.geometry;

import java.util.Objects;

/**
 * Отрезок между двумя точками.
 */
public class Line {
    private Point startPoint;
    private Point endPoint;

    /** Линия по умолчанию */
    public Line() {
        this.startPoint = new Point(0,0);
        this.endPoint = new Point(1,0);
    }

    /** Копирующий конструктор */
    public Line(Line line) {
        if (line == null) {
            throw new InvalidLineException("Линия не может быть null");
        }
        this.startPoint = new Point(line.startPoint.getX(), line.startPoint.getY());
        this.endPoint = new Point (line.endPoint.getX(), line.endPoint.getY());
    }

    /** Конструктор через точки */
    public Line(Point startPoint, Point endPoint) {
        setStartPoint(new Point(startPoint.getX(), startPoint.getY()));
        setEndPoint(new Point(endPoint.getX(), endPoint.getY()));
    }

    /** Конструктор через координаты */
    public Line(double x1, double y1, double x2, double y2) {
        setStartPoint(new Point(x1,y1));
        setEndPoint(new Point(x2,y2));
    }

    /**
     * Возвращает копию начальной точки
     */
    public Point getStartPoint() {
        // FIX_ME: утечка ссылки
        // return startPoint;
        return new Point(startPoint.getX(), startPoint.getY());
    }

    /**
     * Возвращает копию конечной точки
     */
    public Point getEndPoint() {
        // FIX_ME: утечка ссылки
        //return endPoint;
        return new Point(endPoint.getX(), endPoint.getY());
    }

    /** Установить начальную точку */
    public void setStartPoint(Point startPoint) {
        if (startPoint == null) {
            throw new IllegalArgumentException("Начальная точка не может быть null");
        }
        this.startPoint = new Point(startPoint.getX(), startPoint.getY());
        validatePoints();
    }

    /** Установить конечную точку */
    public void setEndPoint(Point endPoint) {
        if (endPoint == null) {
            throw new IllegalArgumentException("Конечная точка не может быть null");
        }
        this.endPoint = new Point(endPoint.getX(), endPoint.getY());
        validatePoints();
    }

    /** Установить координаты начальной точки */
    public void setStartPoint(double x, double y) {
        this.startPoint = new Point(x, y);
        validatePoints();
    }

    /** Установить координаты конечной точки */
    public void setEndPoint(double x, double y) {
        this.endPoint = new Point(x, y);
        validatePoints();
    }

    /** Проверка корректности линии */
    private void validatePoints() {
        if (startPoint.equals(endPoint)) {
            throw new InvalidLineException("Начальная и конечная точки не могут совпадать");
        }
    }

    /** @return длина */
    public double getDistance() {
        double deltaX = endPoint.getX() - startPoint.getX();
        double deltaY = endPoint.getY() - startPoint.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString(){
        return "Линия от " + startPoint + " до " + endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return (startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint)) ||
                (startPoint.equals(line.endPoint) && endPoint.equals(line.startPoint));
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }

    /**
     * Создает и возвращает копию текущего объекта линии.
     *
     * <p>Метод выполняет глубокое копирование,
     * создавая новые объекты точек.</p>
     *
     * @return новая линия с теми же координатами
     */
    @Override
    public Line clone() {
        return new Line(this);
    }
}

/**
 * Исключение, возникающее при некорректной линии.
 */
class InvalidLineException extends RuntimeException {
    public InvalidLineException(String message) {
        super(message);
    }
}



