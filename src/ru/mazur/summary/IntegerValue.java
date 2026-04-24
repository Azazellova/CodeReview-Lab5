package ru.mazur.summary;

/**
 * Целое число.
 */
class IntegerValue implements NumberValue {

    private int value;

    /**
     * Конструктор.
     *
     * @param value значение
     */
    public IntegerValue(int value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double toDouble() {
        return value;
    }
}
