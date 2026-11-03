package me.yanaga.samples.domain.model;

import com.google.common.collect.ForwardingList;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OrderItems extends ForwardingList {

    private final List<OrderItem> value;

    private OrderItems(List<OrderItem> value) {
        this.value = value;
    }

    public static OrderItems of(List<OrderItem> value) {
        Objects.requireNonNull(value);
        return new OrderItems(List.copyOf(value));
    }

    @Override
    protected List delegate() {
        return this.value;
    }

    public BigDecimal getTotalAmount() {
        return this.value.stream().map(OrderItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
