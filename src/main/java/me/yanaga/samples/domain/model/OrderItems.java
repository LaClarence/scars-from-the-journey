package me.yanaga.samples.domain.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class OrderItems {

    private final List<OrderItem> value;

    private OrderItems(List<OrderItem> value) {
        this.value = value;
    }

    public static OrderItems of(List<OrderItem> value) {
        Objects.requireNonNull(value);
        return new OrderItems(List.copyOf(value));
    }

    public List<OrderItem> getValues() {
        return this.value;
    }

    public BigDecimal getTotalAmount() {
        return this.value.stream().map(OrderItem::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
