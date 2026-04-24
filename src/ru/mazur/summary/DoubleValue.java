package ru.mazur.summary;

/**
 * Число с плавающей точкой.
 */
class DoubleValue implements NumberValue {

    private double value;

    /**
     * Конструктор.
     *
     * @param value значение
     */
    public DoubleValue(double value) {
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
