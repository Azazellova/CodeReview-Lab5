package ru.mazur.summary;

/**
 * Дробь.
 */
class FractionValue implements NumberValue {

    private int numerator;
    private int denominator;

    /**
     * Конструктор дроби.
     *
     * @param numerator числитель
     * @param denominator знаменатель
     * @throws IllegalArgumentException если знаменатель = 0
     */
    public FractionValue(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double toDouble() {
        return (double) numerator / denominator;
    }
}

