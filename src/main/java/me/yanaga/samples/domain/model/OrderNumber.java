package me.yanaga.samples.domain.model;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Objects;

public record OrderNumber(Integer value) implements Serializable, Formattable {

    public OrderNumber {
        Objects.requireNonNull(value);
        if (value < 1) {
            throw new IllegalArgumentException("Value must be greater than zero");
        }
    }

    public static OrderNumber of(Integer value) {
        return new OrderNumber(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("Order number: %d", value);
    }

}
