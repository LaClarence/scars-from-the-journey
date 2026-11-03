package me.yanaga.samples.view;

import com.querydsl.jpa.impl.JPAQuery;
import me.yanaga.samples.domain.model.Order;
import me.yanaga.samples.domain.model.QOrder;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class OrderController implements Serializable {

    private OrderForm form = OrderForm.of();

    @PersistenceContext
    private transient EntityManager entityManager;

    // The item collections are lazy: load them inside the transaction, before the entities get detached
    @Transactional
    public List<Order> findAll() {
        JPAQuery<Order> query = new JPAQuery<Order>(entityManager).select(QOrder.order).from(QOrder.order);
        List<Order> orders = query.where(form.toPredicate()).orderBy(QOrder.order.id.asc()).fetch();
        orders.forEach(order -> {
            order.getAmountOfItems();
            order.getAmountOfAbandonedItems();
        });
        return orders;
    }

    public OrderForm getForm() {
        return form;
    }
}
