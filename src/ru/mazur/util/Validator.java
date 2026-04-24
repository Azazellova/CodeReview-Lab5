package ru.mazur.util;

import java.util.Scanner;
/**
 * Класс для безопасного ввода данных с клавиатуры.
 * Содержит методы валидации числового ввода.
 */
public class Validator {

    /**
     * Считывает целое число с проверкой корректности ввода.
     *
     * @param input Scanner
     * @param prompt сообщение пользователю
     * @return корректное целое число
     */
    public static int inputInteger(Scanner input, String prompt) {
        int value;
        //System.out.print(prompt);
        //FIX_ME: неправильное чтение ввода через hasNextInt()
//        while (!(input.hasNextInt())) {
//            System.out.println("Ошибка ввода, повторите попытку: ");
//            System.out.print("> ");
//            input.next();
//        }
//        value = input.nextInt();
//        input.nextLine();
//        return value;

        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();

            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода, повторите попытку:");
            }
        }

    }

    /**
     * Считывает положительное целое число.
     *
     * @param input Scanner
     * @param prompt сообщение
     * @return число > 0
     */
    // FIX_ME: ошибка в названии
    //    public static int inputPositivInteger (Scanner input, String prompt) {
    public static int inputPositiveInteger(Scanner input, String prompt) {
        int value;
        do {
            value = inputInteger(input, prompt);
            if (value <= 0) {
                System.out.println("Ошибка: число должно быть положительным.");
            }
        } while (value <= 0);
        return value;
    }

    /**
     * Считывает число double с проверкой.
     *
     * @param input Scanner
     * @param prompt сообщение
     * @return число double
     */
    public static double inputDouble(Scanner input, String prompt) {
        double value;
        //FIX_ME: неправильное чтение ввода через hasNextInt()
//        System.out.print(prompt);
//        while (!(input.hasNextDouble())) {
//            System.out.println("Ошибка ввода, повторите попытку: ");
//            System.out.print("> ");
//            input.next();
//        }
//        value = input.nextDouble();
//        input.nextLine();
//        return value;
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();

            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода, повторите попытку:");
            }
        }
    }

    /**
     * Считывает строку и проверяет, что она является целым числом.
     *
     * <p>Метод запрашивает ввод до тех пор, пока пользователь
     * не введёт корректное целое число.</p>
     *
     * <p>Возвращает строку (а не int), чтобы её можно было
     * использовать в задачах, где требуется именно строковый ввод.</p>
     *
     * @param input Scanner для чтения ввода
     * @param prompt сообщение пользователю
     * @return строка, содержащая корректное целое число
     */
    public static String inputIntString(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Ошибка: пустой ввод.");
                continue;
            }

            try {
                Integer.parseInt(line);
                return line;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    // FIX_ME: удалены неиспользуемые методы inputMark, readCoordinate
}

