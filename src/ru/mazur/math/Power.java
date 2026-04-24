package ru.mazur.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * Утилитный класс для математических операций.
 */
public class Power {

    /**
     * Возводит число X в степень Y.
     *
     * <p>Метод принимает строки, проверяет их корректность
     * и преобразует в целые числа.</p>
     *
     * @param xStr основание в виде строки
     * @param yStr степень в виде строки
     * @return результат возведения X^Y
     * @throws IllegalArgumentException если строки пустые или null
     * @throws NumberFormatException если строки не являются целыми числами
     */
    public static double power(String xStr, String yStr) {

        if (xStr == null || yStr == null) {
            throw new IllegalArgumentException("Аргументы не должны быть null");
        }

        xStr = xStr.trim();
        yStr = yStr.trim();

        if (xStr.isEmpty() || yStr.isEmpty()) {
            throw new IllegalArgumentException("Пустые строки недопустимы");
        }

        int x = parseInt(xStr);
        int y = parseInt(yStr);

        return pow(x, y);
    }
}