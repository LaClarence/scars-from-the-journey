package me.yanaga.samples.view;

import com.querydsl.jpa.impl.JPAQuery;
import me.yanaga.samples.domain.model.Order;
import me.yanaga.samples.domain.model.QOrder;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class OrderController implements Serializable {

    private OrderForm form = OrderForm.of();

    private List<Order> results = List.of();

    @PersistenceContext
    private transient EntityManager entityManager;

    // Fetches the lazy items in the same query, because the entities get detached before the page renders
    public void search() {
        JPAQuery<Order> query = new JPAQuery<Order>(entityManager)
                .select(QOrder.order)
                .from(QOrder.order)
                .leftJoin(QOrder.order.items).fetchJoin();
        results = query
                .where(form.toPredicate())
                .orderBy(QOrder.order.id.asc())
                .fetch();
    }

    public List<Order> getResults() {
        return results;
    }

    public OrderForm getForm() {
        return form;
    }
}
