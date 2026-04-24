package ru.mazur.geometry;

/**
 * Точка в 2D пространстве (X, Y).
 */
public class Point2D extends AbstractPoint {

    /** Создаёт 2D точку */
    public Point2D(double x, double y) {
        super(new double[]{x, y});
    }

    /** Создаёт 2D точку с характеристиками */
    public Point2D(double x, double y, String color, String time) {
        super(new double[]{x, y});
        setColor(color);
        setTime(time);
    }

    /** @return X */
    public double getX() { return coordinates[0]; }

    /** @return Y */
    public double getY() { return coordinates[1]; }

    /** Устанавливает X */
    public void setX(double x) {
        validateCoordinates(new double[]{x, coordinates[1]});
        this.coordinates[0] = x;
    }

    /** Устанавливает Y */
    public void setY(double y) {
        validateCoordinates(new double[]{coordinates[0], y});
        this.coordinates[1] = y;
    }

    /** Устанавливает обе координаты */
    public void setCoordinates(double x, double y) {
        validateCoordinates(new double[]{x, y});
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }
}