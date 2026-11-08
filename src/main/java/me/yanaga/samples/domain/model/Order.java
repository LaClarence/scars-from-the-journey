package me.yanaga.samples.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
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
    // Both purchased and abandoned items: read them through getItems() and getAbandonedItems()
    private List<OrderItem> items = new ArrayList<>();

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
        return OrderItems.of(items.stream().filter(OrderItem::abandoned).toList());
    }
    public OrderItems getItems() {
        return OrderItems.of(items.stream().filter(item -> !item.abandoned()).toList());
    }
    public void addItem(OrderItem item) {
        Objects.requireNonNull(item);
        // Here could add custom logic to merge same product
        this.items.add(item);
    }

    public int getAmountOfItems() {
        return getItems().getValues().size();
    }

    public int getAmountOfAbandonedItems() {
        return getAbandonedItems().getValues().size();
    }
}
