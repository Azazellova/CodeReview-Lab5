package ru.mazur.geometry;

/**
 * Класс трехмерной точки.
 */

// FIX_ME: неверное наименование класса
// public final class Point3DVer1 extends Point {
public final class Point3D extends Point {
    private double z;

    /**
     * Конструктор 3D точки.
     *
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     */
    public Point3D(double x, double y, double z) {
        super(x, y);
        setZ(z);
    }

    /**
     * Возвращает координату Z.
     *
     * @return значение Z
     */
    public double getZ() {
        return z;
    }

    /**
     * Устанавливает координату Z.
     *
     * @param z значение
     */
    public void setZ(double z) {
        if (Double.isNaN(z)) {
            throw new IllegalArgumentException("Z NaN");
        }
        this.z = z;
    }

    /**
     * Устанавливает координаты.
     *
     * @param x X
     * @param y Y
     * @param z Z
     */
    public void setCoordinates(double x, double y, double z) {
        super.setCoordinates(x, y);
        setZ(z);
    }

    /**
     * Запрещенный метод.
     *
     * @throws UnsupportedOperationException всегда
     */
    @Override
    public void setCoordinates(double x, double y) {
        throw new UnsupportedOperationException("Use 3D version");
    }

    /**
     * Строковое представление.
     *
     * @return строка
     */
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}

