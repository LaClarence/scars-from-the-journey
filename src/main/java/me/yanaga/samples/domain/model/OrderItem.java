package me.yanaga.samples.domain.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class OrderItem implements Serializable {

    private Integer amount;

    private String product;

    private BigDecimal price;

    protected OrderItem()
    {}
    private OrderItem(Integer amount, String product, BigDecimal price) {
        this.amount = amount;
        this.product = product;
        this.price = price;
    }
    public static OrderItem of(Integer amount, String product, BigDecimal price) {
        Objects.requireNonNull(amount);
        Objects.requireNonNull(product);
        Objects.requireNonNull(price);
        return new OrderItem(amount, product, price);
    }

    public Integer getAmount() {
        return amount;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
