package me.yanaga.samples.view;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import me.yanaga.samples.domain.model.OrderNumber;
import me.yanaga.samples.domain.model.QOrder;

import java.io.Serializable;

public class OrderForm implements Serializable {

    private OrderNumber number;

    private String product;

    private OrderForm() {
    }

    public static OrderForm of() {
        return new OrderForm();
    }

    public Predicate toPredicate() {
        BooleanBuilder builder = new BooleanBuilder();
        if (number != null) {
            builder.and(QOrder.order.number.eq(number));
        }
        if (product != null && !product.isBlank()) {
            // Orders having at least one item whose product contains the text
            builder.and(QOrder.order.items.any().product.containsIgnoreCase(product.trim()));
        }
        return builder;
    }

    public OrderNumber getNumber() {
        return number;
    }

    public void setNumber(OrderNumber number) {
        this.number = number;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
