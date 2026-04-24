package ru.mazur.summary;

/**
 * Класс для обработки и суммирования чисел.
 */
public class NumSumCalculate {

    /**
     * Вычисляет сумму массива чисел.
     *
     * @param values массив значений
     * @return сумма
     */
    public static double calculateSum(NumberValue[] values) {
        double sum = 0;

        for (NumberValue value : values) {
            sum += value.toDouble();
        }

        return sum;
    }

    /**
     * Парсит строку в NumberValue.
     *
     * Поддерживает:
     * - целые числа (5)
     * - дробные (3.14)
     * - рациональные (2/3)
     *
     * @param input строка
     * @return NumberValue или null если формат неверный
     */
    public static NumberValue parseNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        String str = input.strip();

        if (str.matches("-?\\d+")) {
            return new IntegerValue(Integer.parseInt(str));
        }

        if (str.matches("-?\\d+\\.\\d+")) {
            return new DoubleValue(Double.parseDouble(str));
        }

        if (str.matches("-?\\d+/\\d+")) {
            String[] parts = str.split("/");

            int num = Integer.parseInt(parts[0]);
            int den = Integer.parseInt(parts[1]);

            return new FractionValue(num, den);
        }

        return null;
    }
}