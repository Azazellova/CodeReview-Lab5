package ru.mazur.main;

import ru.mazur.geometry.*;
import ru.mazur.math.Power;
import ru.mazur.summary.*;
import ru.mazur.util.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Главный класс программы.
 * Содержит точку входа и меню выбора заданий.
 */
public class Main {

    /**
     * Точка входа в программу.
     * Позволяет выбрать и запустить различные задания.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // FIX_ME: отсутствует выбор задания
        while (true) {
            System.out.println("\n===== МЕНЮ =====");
            System.out.println("1 - 1.6 Линия");
            System.out.println("2 - 1.12 Квадрат");
            System.out.println("3 - 2.1 ImmutableArray");
            System.out.println("4 - 3.5 3D Точка");
            System.out.println("5 - 4.5 AbstractPoint");
            System.out.println("6 - 5.1 Сумма чисел");
            System.out.println("7 - 6.3 Сравнение линий");
            System.out.println("8 - 7 Пакеты");
            System.out.println("9 - 8.5 Клонирование Line");
            System.out.println("0 - Выход");

            int choice = Validator.inputInteger(input, "Выбор: ");

            switch (choice) {
                case 1:
                    taskLine(input);
                    break;
                case 2:
                    taskSquare(input);
                    break;
                case 3:
                    taskImmutable(input);
                    break;
                case 4:
                    taskPoint3D(input);
                    break;
                case 5:
                    taskAbstractPoint(input);
                    break;
                case 6:
                    taskSum(input);
                    break;
                case 7:
                    taskLineEquals(input);
                    break;
                case 8:
                    task7(input);
                    break;
                case 9:
                    taskCloneLine(input);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    /**
     * Задание 1.6.
     * Демонстрирует создание линии, вычисление длины и обработку ошибок.
     *
     * @param input объект Scanner для ввода данных
     */
    private static void taskLine(Scanner input) {
        try {
            double startX1 = Validator.inputDouble(input, "Введите значение x начала линии: ");
            double startY1 = Validator.inputDouble(input, "Введите значение y начала линии: ");
            double endX1 = Validator.inputDouble(input, "Введите значение x конца линии: ");
            double endY1 = Validator.inputDouble(input, "Введите значение y конца линии: ");

            Line line = new Line(startX1, startY1, endX1, endY1);

            System.out.println(line);
            System.out.println("Длина: " + line.getDistance());


            System.out.println("\n" + line);
            System.out.println("Длина линии: " + line.getDistance());

            try {
                System.out.println("\n--- Тест начальная точка равна null ---");

                line.setStartPoint(null);
            } catch (RuntimeException e) {
                System.out.println("Исключение: " + e.getMessage());
            } finally {
                System.out.println("Тест окончен.");
            }

            try {
                System.out.println("\n--- Тест конечная точка равна начальной ---");
                line.setEndPoint(line.getStartPoint());
            } catch (RuntimeException e) {
                System.out.println("Исключение: " + e.getMessage());
            } finally {
                System.out.println("Тест окончен.");
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
            //System.out.println("Исключение: " + e.getMessage());
        } finally {
            System.out.println("Тест окончен.");
        }
    }

    /**
     * Задание 1.12.
     * Демонстрирует работу с квадратом и преобразование его в ломаную.
     *
     * @param input Scanner
     */
    private static void taskSquare(Scanner input) {
        try {
            System.out.println("=== Создание квадрата ===\n");
            double x = Validator.inputDouble(input, "Введите координату X левого верхнего угла: ");
            double y = Validator.inputDouble(input, "Введите координату Y левого верхнего угла: ");
            double side = Validator.inputDouble(input, "Введите длину стороны квадрата: ");

            Square square = new Square(x, y, side);
            System.out.println("\nСоздан: " + square);

            System.out.println("Координаты квадрата (через наследование): " +
                    "X=" + square.getX() + ", Y=" + square.getY());

            Polyline polyline = square.toPolyline();
            System.out.println("Создана ломаная из " + polyline.getPointCount() + " точек");

            double polyLen = polyline.getLength();
            System.out.println("Длина ломаной: " + polyLen);

            System.out.println("\n=== Изменение последней точки ломаной ===");
            double newX = Validator.inputDouble(input, "Введите новую координату X для последней точки: ");
            double newY = Validator.inputDouble(input, "Введите новую координату Y для последней точки: ");

            polyline.setPoint(polyline.getPointCount() - 1, new Point(newX, newY));
            System.out.println("Последняя точка перемещена в {" + newX + ";" + newY + "}");

            double newLen = polyline.getLength();
            System.out.println("Новая длина ломаной: " + newLen);
            System.out.println("Изменение длины: " + (newLen - polyLen));
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Задание 2.1.
     * Демонстрирует работу с неизменяемым массивом.
     *
     * @param input Scanner
     */
    private static void taskImmutable(Scanner input) {
        int size = Validator.inputPositiveInteger(input, "Размер массива: ");
        int[] userArray = new int[size];

        for (int i = 0; i < size; i++) {
            userArray[i] = Validator.inputInteger(input, "Элемент " + i + ": ");
        }

        // FIX_ME: логически неправильное название переменной
        //ImmutableArray userList = new ImmutableArray(userArray);
        ImmutableArray array = new ImmutableArray(userArray);
        System.out.println("Ваш массив:" + array);

        int index = Validator.inputInteger(input, "Введите индекс для получения элемента: ");
        try {
            int value = array.get(index);
            System.out.println("Элемент по индексу " + index + ": " + value);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        int replaceIndex = Validator.inputInteger(input, "Введите индекс для замены элемента: ");
        int newValue = Validator.inputInteger(input, "Введите новое значение: ");
        try {
            ImmutableArray newList = array.set(replaceIndex, newValue);
            System.out.println("Исходный список: " + array);
            System.out.println("Новый список после замены: " + newList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n--- Дополнительные методы ---");
        System.out.println("Размер списка: " + array.size());
        System.out.println("Список пустой: " + array.isEmpty());
        System.out.println("Массив значений: " + Arrays.toString(array.getValues()));
    }

    /**
     * Задание 3.5.
     * Демонстрация работы с 3D точкой.
     *
     * @param input Scanner
     */
    private static void taskPoint3D(Scanner input) {
        try {
            double x = Validator.inputDouble(input, "x: ");
            double y = Validator.inputDouble(input, "y: ");
            double z = Validator.inputDouble(input, "z: ");

            Point3D point = new Point3D(x, y, z);
            System.out.println(point);
            System.out.println("Успешно создана точка: " + point);

            System.out.println("\n=== Демонстрация операций с точкой ===");

            System.out.println("Координата X: " + point.getX());
            System.out.println("Координата Y: " + point.getY());
            System.out.println("Координата Z: " + point.getZ());

            System.out.println("\n--- Изменение координат точки ---");
            try {
                double newX = Validator.inputDouble(input, "Введите новое значение X: ");
                double newY = Validator.inputDouble(input, "Введите новое значение Y: ");
                double newZ = Validator.inputDouble(input, "Введите новое значение Z: ");

                point.setCoordinates(newX, newY, newZ);
                System.out.println("Координаты успешно изменены: " + point);

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка при изменении координат: " + e.getMessage());
            }

            System.out.println("\n--- Попытка использования двухкоординатного метода ---");
            try {
                point.setCoordinates(1, 2);
            } catch (UnsupportedOperationException e) {
                System.out.println("Ожидаемая ошибка: " + e.getMessage());
            }

            System.out.println("\n--- Создание дополнительных точек ---");
            try {
                double extraX = Validator.inputDouble(input, "Введите значение X:");
                double extraY = Validator.inputDouble(input, "Введите значение Y:");
                double extraZ = Validator.inputDouble(input, "Введите значение Z:");

                Point3D point2 = new Point3D(extraX, extraY, extraZ);
                System.out.println("Создана точка: " + point2);

                extraX = Validator.inputDouble(input, "Введите значение X:");
                extraY = Validator.inputDouble(input, "Введите значение Y:");
                extraZ = Validator.inputDouble(input, "Введите значение Z:");

                Point3D point3 = new Point3D(extraX, extraY, extraZ);
                System.out.println("Создана точка: " + point3);

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка при создании точек: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании точки: " + e.getMessage());
        }
    }

    /**
     * Задание 4.5.
     * Создание списка точек с различной размерностью.
     *
     * @param input Scanner
     */
    private static void taskAbstractPoint(Scanner input) {
        List<AbstractPoint> points = new ArrayList<>();
        boolean continueCreating = true;

        while (continueCreating) {
            try {
                AbstractPoint point = AbstractPoint.createPoint(input);
                points.add(point);

                System.out.println("Точка создана: " + point);
                System.out.println();

                System.out.print("Хотите создать еще одну точку? (y/n): ");
                String answer = input.nextLine().trim().toLowerCase();
                if (!answer.equals("y") && !answer.equals("yes") && !answer.equals("да")) {
                    continueCreating = false;
                }
                System.out.println();

            } catch (Exception e) {
                System.out.println("Ошибка при создании точки: " + e.getMessage());
                System.out.println("Попробуйте еще раз.\n");
            }
        }

        System.out.println("===========================================");
        System.out.println("Все созданные точки:");
        System.out.println("===========================================");

        for (int i = 0; i < points.size(); i++) {
            System.out.println((i + 1) + ". " + points.get(i));
        };
    }

    /**
     * Задание 5.1.
     * Суммирование чисел различных типов.
     *
     * @param input Scanner
     */
    private static void taskSum(Scanner input) {
        List<NumberValue> numbers = new ArrayList<>();
        System.out.println("Введите значения чисел для суммы (форматы 3, 3.4, 2/5)");
        System.out.println("Для завершения введите 'stop'");

        while(true) {
            System.out.print("Введите число: ");
            String inputStr = input.nextLine().strip();

            if (inputStr.equalsIgnoreCase("stop")) {
                break;
            }

            if (inputStr.isEmpty()) {
                System.out.println("Ошибка: пустой ввод. Попробуйте снова.");
                continue;
            }

            try {
                NumberValue number = NumSumCalculate.parseNumber(inputStr);
                if (number != null) {
                    numbers.add(number);
                    System.out.println("Добавлено: " + inputStr);
                } else {
                    System.out.println("Ошибка: неверный формат. Используйте: 5, 2.5 или 3/4");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ошибка при обработке числа: " + e.getMessage());
            }
        }

        if (!numbers.isEmpty()) {
            NumberValue[] numberArray = numbers.toArray(new NumberValue[0]);
            double result = NumSumCalculate.calculateSum(numberArray);
            System.out.println("Общая сумма: " + result);
        } else {
            System.out.println("Не было введено чисел для суммы.");
        }
    }

    /**
     * Задание 6.3.
     * Сравнение двух линий.
     *
     * @param input Scanner
     */
    private static void taskLineEquals(Scanner input) {
        try {
            System.out.println("Введите значения первой линии(x1, y1, x2, y2)");
            double x1 = Validator.inputDouble(input, "x1: ");
            double y1 = Validator.inputDouble(input, "y1: ");
            double x2 = Validator.inputDouble(input, "x2: ");
            double y2 = Validator.inputDouble(input, "y2: ");
            Line line1 = new Line(x1, y1, x2, y2);
            System.out.println("Создано: " + line1);

            System.out.println("Введите значения первой линии(x3, y3, x4, y4)");
            double x3 = Validator.inputDouble(input, "x3: ");
            double y3 = Validator.inputDouble(input, "y3: ");
            double x4 = Validator.inputDouble(input, "x4: ");
            double y4 = Validator.inputDouble(input, "y4: ");
            Line line2 = new Line(x3, y3, x4, y4);
            System.out.println("Создано: " + line2);

            if (line1.equals(line2)) {
                System.out.println("Линии равны.");
            } else {
                System.out.println("Линии не равны.");
            }

        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Задание 7.
     * Демонстрация пакетов.
     *
     * @param input Scanner
     */
    private static void task7(Scanner input) {

        String xStr = Validator.inputIntString(input, "Введите число X: ");
        String yStr = Validator.inputIntString(input, "Введите степень Y: ");

        try {
            double result = Power.power(xStr, yStr);
            System.out.println(xStr + " ^ " + yStr + " = " + result);
        } catch (Exception e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        }
    }

    /**
     * Задание 8.5
     * Демонстрация клонирования
     *
     * @param input Scanner
     */
    private static void taskCloneLine(Scanner input) {
        try {
            System.out.println("=== Создание линии ===");

            double x1 = Validator.inputDouble(input, "x1: ");
            double y1 = Validator.inputDouble(input, "y1: ");
            double x2 = Validator.inputDouble(input, "x2: ");
            double y2 = Validator.inputDouble(input, "y2: ");

            Line original = new Line(x1, y1, x2, y2);

            System.out.println("Оригинал: " + original);

            Line clone = original.clone();
            System.out.println("Клон: " + clone);

            System.out.println("\n=== Изменение клона ===");
            double newX = Validator.inputDouble(input, "Новый x начальной точки: ");
            double newY = Validator.inputDouble(input, "Новый y начальной точки: ");

            clone.setStartPoint(newX, newY);

            System.out.println("\nПосле изменения:");
            System.out.println("Оригинал: " + original);
            System.out.println("Клон: " + clone);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}