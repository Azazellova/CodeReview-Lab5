package ru.mazur.geometry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Абстрактная точка (1D/2D/3D).
 * Базовый класс для всех типов точек.
 */
public abstract class AbstractPoint {
    /** Координаты точки */
    protected double[] coordinates;
    /** Цвет точки */
    protected String color;
    /** Время (формат HH:MM) */
    protected String time;

    /**
     * Конструктор точки.
     *
     * @param coordinates массив координат
     */
    public AbstractPoint(double[] coordinates) {
        validateCoordinates(coordinates);
        this.coordinates = coordinates;
    }

    /**
     * Проверяет корректность координат.
     *
     * @param coordinates массив координат
     */
    protected void validateCoordinates(double[] coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Массив координат не может быть null");
        }
        if (coordinates.length < 1 || coordinates.length > 3) {
            throw new IllegalArgumentException("Количество координат должно быть от 1 до 3");
        }
        for (double coord : coordinates) {
            if (coord < Integer.MIN_VALUE || coord > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Координата выходит за допустимые пределы: " + coord);
            }
        }
    }

    /**
     * Возвращает копию массива координат.
     *
     * @return массив координат
     */
    public double[] getCoordinates() {
        return coordinates.clone();
    }

    /**
     * Получить цвет точки.
     */
    public String getColor() {
        return color;
    }

    /**
     * Установить цвет точки.
     *
     * @param color цвет
     */
    public void setColor(String color) {
        if (color != null && color.trim().isEmpty()) {
            throw new IllegalArgumentException("Цвет не может быть пустой строкой");
        }
        this.color = color;
    }

    /**
     * Получить время.
     */
    public String getTime() {
        return time;
    }

    /**
     * Установить время в формате HH:MM.
     *
     * @param time строка времени
     */
    public void setTime(String time) {
        if (time != null) {
            if (time.trim().isEmpty()) {
                throw new IllegalArgumentException("Время не может быть пустой строкой");
            }
            // Простая валидация формата времени (можно расширить)
            if (!time.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
                throw new IllegalArgumentException("Неверный формат времени. Используйте HH:MM");
            }
        }
        this.time = time;
    }

    /**
     * Создает точку с вводом с клавиатуры.
     *
     * @param input Scanner
     * @return созданная точка
     */
    public static AbstractPoint createPoint(Scanner input) {

        int amountCoords = getAmountCoords(input);

        double[] coordinates = getCoords(input, amountCoords);

        AbstractPoint point = createPointByDimensions(coordinates);

        addCharacteristic(input, point);

        return point;

    }

    /**
     * Ввод координат.
     */
    private static double[] getCoords(Scanner input, int amountCoords) {
        double[] coordinates = new double[amountCoords];
        String[] coordNames = {"X", "Y", "Z"};

        for (int i = 0; i < amountCoords; i++) {
            while (true) {
                System.out.print("Введите координату " + coordNames[i] + ": ");
                try {
                    coordinates[i] = Double.parseDouble(input.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число");
                }
            }
        }
        return coordinates;
    }

    /**
     * Ввод размерности точки.
     */
    private static int getAmountCoords(Scanner input) {
        while (true) {
            System.out.print("Введите количество координат (1, 2 или 3): ");
            try {
                int dimensions = Integer.parseInt(input.nextLine().trim());
                if (dimensions >= 1 && dimensions <= 3) {
                    return dimensions;
                } else {
                    System.out.println("Ошибка: введите 1, 2 или 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число");
            }
        }
    }

    /**
     * Добавляет дополнительные характеристики точке.
     */
    private static void addCharacteristic(Scanner input, AbstractPoint point) {
        System.out.print("Хотите добавить цвет? (y/n): ");
        String answer = input.nextLine().trim().toLowerCase();
        if (answer.equals("y") || answer.equals("yes") || answer.equals("да")) {
            System.out.print("Введите цвет: ");
            String color = input.nextLine().trim();
            if (!color.isEmpty()) {
                point.setColor(color);
            }
        }

        System.out.print("Хотите добавить время? (y/n): ");
        answer = input.nextLine().trim().toLowerCase();
        if (answer.equals("y") || answer.equals("yes") || answer.equals("да")) {
            while (true) {
                System.out.print("Введите время (формат HH:MM): ");
                String time = input.nextLine().trim();
                if (!time.isEmpty()) {
                    try {
                        point.setTime(time);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Фабричный метод создания точки по размерности.
     *
     * @param coordinates координаты
     * @return конкретная реализация точки
     */
    public static AbstractPoint createPointByDimensions(double[] coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Массив координат не может быть null");
        }

        switch (coordinates.length) {
            case 1:
                return new Point1D(coordinates[0]);
            case 2:
                return new Point2D(coordinates[0], coordinates[1]);
            case 3:
                return new ExtendedPoint3D(coordinates[0], coordinates[1], coordinates[2]);
            default:
                throw new IllegalArgumentException("Неподдерживаемое количество координат: " + coordinates.length);
        }
    }

    /**
     * Строковое представление точки.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < coordinates.length; i++) {
            sb.append(coordinates[i]);
            if (i < coordinates.length - 1) {
                sb.append(";");
            }
        }
        sb.append("}");

        Map<String, String> characteristics = new HashMap<>();
        if (color != null) {
            characteristics.put("color", color);
        }
        if (time != null) {
            characteristics.put("time", time);
        }

        if (!characteristics.isEmpty()) {
            sb.append(" [");
            int count = 0;
            for (Map.Entry<String, String> entry : characteristics.entrySet()) {
                if (count > 0) {
                    sb.append(", ");
                }
                sb.append(entry.getKey()).append("=").append(entry.getValue());
                count++;
            }
            sb.append("]");
        }

        return sb.toString();
    }
}