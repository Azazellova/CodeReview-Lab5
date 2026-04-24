package ru.mazur.geometry;

/**
 * Класс, представляющий точку в 3D пространстве с цветом и временем.
 */

// FIX_ME: неверное наименование класса
// public class Point3DVer2 extends AbstractPoint {
public class ExtendedPoint3D extends AbstractPoint {

    /**
     * Создаёт 3D точку.
     *
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     */
    public ExtendedPoint3D(double x, double y, double z) {
        super(new double[]{x, y, z});
    }

    /**
     * Создаёт 3D точку с дополнительными характеристиками.
     *
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     * @param color цвет точки
     * @param time время точки
     */
    public ExtendedPoint3D(double x, double y, double z, String color, String time) {
        super(new double[]{x, y, z});
        setColor(color);
        setTime(time);
    }

    /** @return X координата */
    public double getX() {
        return coordinates[0];
    }

    /** @return Y координата */
    public double getY() {
        return coordinates[1];
    }

    /** @return Z координата */
    public double getZ() {
        return coordinates[2];
    }

    /** Устанавливает X координату */
    public void setX(double x) {
        validateCoordinates(new double[]{x, coordinates[1], coordinates[2]});
        this.coordinates[0] = x;
    }

    /** Устанавливает Y координату */
    public void setY(double y) {
        validateCoordinates(new double[]{coordinates[0], y, coordinates[2]});
        this.coordinates[1] = y;
    }

    /** Устанавливает Z координату */
    public void setZ(double z) {
        validateCoordinates(new double[]{coordinates[0], coordinates[1], z});
        this.coordinates[2] = z;
    }

    /**
     * Устанавливает все координаты.
     */
    public void setCoordinates(double x, double y, double z) {
        validateCoordinates(new double[]{x, y, z});
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        this.coordinates[2] = z;
    }
}
