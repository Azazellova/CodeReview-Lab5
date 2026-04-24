package ru.mazur.geometry;

/**
 * Класс, представляющий точку в одномерном пространстве.
 */
public class Point1D extends AbstractPoint {

    /**
     * Создаёт 1D точку.
     */
    public Point1D(double x) {
        super(new double[]{x});
    }

    /**
     * Создаёт 1D точку с характеристиками.
     */
    public Point1D(double x, String color, String time) {
        super(new double[]{x});
        setColor(color);
        setTime(time);
    }

    /** @return координата X */
    public double getX() {
        return coordinates[0];
    }

    /** Устанавливает X */
    public void setX(double x) {
        validateCoordinates(new double[]{x});
        this.coordinates[0] = x;
    }
}
