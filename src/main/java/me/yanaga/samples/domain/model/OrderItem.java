package me.yanaga.samples.domain.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public record OrderItem(Integer amount, String product, BigDecimal price, boolean abandoned) implements Serializable {

    public OrderItem {
        Objects.requireNonNull(amount);
        Objects.requireNonNull(product);
        Objects.requireNonNull(price);
    }

    public static OrderItem of(Integer amount, String product, BigDecimal price) {
        return new OrderItem(amount, product, price, false);
    }

    public static OrderItem ofAbandoned(Integer amount, String product, BigDecimal price) {
        return new OrderItem(amount, product, price, true);
    }

}
