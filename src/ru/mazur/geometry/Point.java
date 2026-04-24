package ru.mazur.geometry;

import java.util.Objects;

/**
 * Класс, представляющий точку на плоскости.
 * Содержит координаты X и Y.
 */
public class Point {

    private double x;
    private double y;

    /**
     * Конструктор точки.
     *
     * @param x координата X
     * @param y координата Y
     * @throws IllegalArgumentException если координаты NaN
     */
    public Point(double x, double y) {
        if (Double.isNaN(x) || Double.isNaN(y)) {
            throw new IllegalArgumentException("Координаты не могут быть NaN");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату X.
     *
     * @return значение X
     */
    public double getX() {
        return x;
    }

    /**
     * Возвращает координату Y.
     *
     * @return значение Y
     */
    public double getY() {
        return y;
    }

    /**
     * Устанавливает координату X.
     *
     * @param x новое значение
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Устанавливает координату Y.
     *
     * @param y новое значение
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Устанавливает обе координаты точки.
     *
     * @param x новое значение X
     * @param y новое значение Y
     * @throws IllegalArgumentException если значения NaN
     */
    public void setCoordinates(double x, double y) {
        if (Double.isNaN(x) || Double.isNaN(y)) {
            throw new IllegalArgumentException("Координаты не могут быть NaN");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает строковое представление точки.
     *
     * @return строка вида {x;y}
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    /**
     * Сравнивает две точки по координатам.
     *
     * @param o объект для сравнения
     * @return true если координаты совпадают
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    /**
     * Возвращает hashCode точки.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
