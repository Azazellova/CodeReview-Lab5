package ru.mazur.summary;


import java.util.Arrays;

/**
 * Неизменяемый массив целых чисел.
 */
public class ImmutableArray {
    private final int[] values;

    /**
     * Конструктор.
     *
     * @param array массив
     */
    public ImmutableArray(int[] array) {
        //FIX_ME: скрывался null, создавался пустой массив
//        if (array == null) {
//            this.values = new int[0];
//        } else {
//            this.values = Arrays.copyOf(array, array.length);
//        }
        if (array == null) {
            throw new IllegalArgumentException("Массив пуст");
        }
        this.values = Arrays.copyOf(array, array.length);
    }

    /** Конструктор с перечнем */
    public ImmutableArray(int first, int... rest) {
        if (rest == null) {
            this.values = new int[]{first};
        } else {
            this.values = new int[rest.length + 1];
            this.values[0] = first;
            System.arraycopy(rest, 0, this.values, 1, rest.length);
        }
    }

    /** Копирующий конструктор */
    public ImmutableArray(ImmutableArray other) {
        if (other == null) {
            this.values = new int[0];
        } else {
            this.values = Arrays.copyOf(other.values, other.values.length);
        }
    }

    /**
     * Получить элемент по индексу.
     *
     * @param index индекс
     * @return значение
     */
    public int get(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс должен быть от 0 до " + (values.length - 1));
        }
        return values[index];
    }

    /**
     * Возвращает новый массив с измененным значением.
     *
     * @param index индекс
     * @param newValue значение
     * @return новый ImmutableArray
     */
    public ImmutableArray set(int index, int newValue) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс должен быть от 0 до " + (values.length - 1));
        }
        int[] newArray = Arrays.copyOf(values, values.length);
        newArray[index] = newValue;
        return new ImmutableArray(newArray);
    }

    /** @return пустой ли массив */
    public boolean isEmpty() {
        return values.length == 0;
    }

    /** @return размер */
    public int size() {
        return values.length;
    }

    /** @return копия массива */
    public int[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    /** @return строка */
    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
