package me.yanaga.samples.domain.model;

import com.querydsl.core.annotations.Immutable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
// ORDER is a reserved SQL keyword
@Table(name = "ORDERS")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private OrderNumber number;

    @ElementCollection
    @CollectionTable(name = "ORDER_ITEMS", joinColumns = @JoinColumn(name = "ORDER_ID"))
    private List<OrderItem> items = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "ORDER_ABANDONED_ITEMS", joinColumns = @JoinColumn(name = "ORDER_ID"))
    private List<OrderItem> abandonedItems = new ArrayList<>();

    protected Order() {
    }

    private Order(OrderNumber number) {
        this.number = number;
    }
    public static Order of(OrderNumber orderNumber) {
        Objects.requireNonNull(orderNumber);
        return new Order(orderNumber);
    }

    public OrderNumber getNumber() {
        return number;
    }

    public OrderItems getAbandonedItems() {
        return OrderItems.of(abandonedItems);
    }
    public OrderItems getItems() {
        return OrderItems.of(items);
    }
    public void addItem(OrderItem item) {
        Objects.requireNonNull(item);
        // Here could add custom logic to merge same product
        this.items.add(item);
    }

    public int getAmountOfItems() {
        return items.size();
    }

    public int getAmountOfAbandonedItems() {
        return abandonedItems.size();
    }
}
