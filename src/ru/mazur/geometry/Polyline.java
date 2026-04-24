package ru.mazur.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий ломаную линию.
 */
// FIX_ME: класс не был публичным
// class Polyline {
public class Polyline {

    private final List<Point> points = new ArrayList<>();

    /**
     * Добавляет точку в ломаную.
     *
     * @param point точка
     * @throws IllegalArgumentException если точка null
     */
    public void addPoint(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("Point null");
        }
        points.add(new Point(point.getX(), point.getY()));
    }

    /**
     * Возвращает количество точек.
     *
     * @return число точек
     */
    public int getPointCount() {
        return points.size();
    }

    /**
     * Возвращает точку по индексу.
     *
     * @param index индекс
     * @return копия точки
     * @throws IndexOutOfBoundsException если индекс неверный
     */
    public Point getPoint(int index) {
        if (index < 0 || index >= points.size()) {
            throw new IndexOutOfBoundsException();
        }
        Point p = points.get(index);
        return new Point(p.getX(), p.getY());
    }

    /**
     * Заменяет точку по индексу.
     *
     * @param index индекс
     * @param point новая точка
     */
    public void setPoint(int index, Point point) {
        if (point == null) {
            throw new IllegalArgumentException("Point null");
        }
        points.set(index, new Point(point.getX(), point.getY()));
    }

    /**
     * Вычисляет длину ломаной линии.
     *
     * @return длина
     */
    public double getLength() {
        double length = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);

            double dx = b.getX() - a.getX();
            double dy = b.getY() - a.getY();

            length += Math.sqrt(dx * dx + dy * dy);
        }

        return length;
    }

    /**
     * Возвращает строковое представление.
     *
     * @return строка
     */
    @Override
    public String toString() {
        return points.toString();
    }
}