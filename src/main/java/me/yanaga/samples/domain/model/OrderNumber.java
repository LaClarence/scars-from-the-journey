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

    // What the outside world (database, web page) should use, rather than value(),
    // so the internal representation can change. A record can't make value() private.
    public Integer toInteger() {
        return value;
    }

    // For the user: String.format("%s", number) gives "Order number: 1001".
    // toString() is left as the record's default, for debugging
    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("Order number: %d", value);
    }

}
