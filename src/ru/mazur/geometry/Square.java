package ru.mazur.geometry;

/**
 * Класс, представляющий квадрат.
 * Наследуется от Point (по условию задания).
 */

// FIX_ME: класс не был публичным
// class Square extends Point {
public class Square extends Point {
    private double side;

    /**
     * Конструктор квадрата.
     *
     * @param x координата X
     * @param y координата Y
     * @param side длина стороны
     */
    public Square(double x, double y, double side) {
        super(x, y);
        setSide(side);
    }

    /**
     * Возвращает сторону квадрата.
     *
     * @return длина стороны
     */
    public double getSide() {
        return side;
    }

    /**
     * Устанавливает сторону квадрата.
     *
     * @param side длина стороны
     * @throws IllegalArgumentException если <= 0
     */
    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительной: " + side);
        }
        this.side = side;
    }

    /** @return копия верхней левой точки */
    public Point getTopLeft() {
        return new Point(getX(), getY());
    }

    /** Устанавливает позицию квадрата */
    public void setTopLeft(Point topLeft) {
        if (topLeft == null) {
            throw new IllegalArgumentException("Точка не может быть null");
        }
        setCoordinates(topLeft.getX(), topLeft.getY());
    }

    /** @return строковое представление */
    @Override
    public String toString() {
        return "Квадрат в точке " + super.toString() + " со стороной " + side;
    }

    /**
     * Преобразует квадрат в ломаную линию.
     *
     * @return Polyline
     */
    public Polyline toPolyline() {
        Polyline polyline = new Polyline();
        double x = getX();
        double y = getY();

        polyline.addPoint(new Point(x, y));
        polyline.addPoint(new Point(x + side, y));
        polyline.addPoint(new Point(x + side, y + side));
        polyline.addPoint(new Point(x, y + side));
        polyline.addPoint(new Point(x, y));

        return polyline;
    }
}
