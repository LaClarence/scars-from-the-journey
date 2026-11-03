package me.yanaga.samples.domain.model;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Objects;

public class OrderNumber implements Serializable, Formattable {
    private final Integer value;

    private OrderNumber(Integer value) {
        this.value = value;
    }
    public static OrderNumber of(Integer value) {
        Objects.requireNonNull(value);
        if (value < 1) {
            throw new IllegalArgumentException("Value must be greater than zero");
        }
        return new OrderNumber(value);
    }

    @Override
    public  boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof OrderNumber on) {
            return Objects.equals(this.value, on.value);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("Order number: %d", value);
    }

    public Integer toInteger() {
        return value;
    }
}