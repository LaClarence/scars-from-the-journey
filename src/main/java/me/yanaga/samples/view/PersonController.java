package me.yanaga.samples.view;

import com.querydsl.jpa.impl.JPAQuery;
import me.yanaga.samples.domain.model.Person;
import me.yanaga.samples.domain.model.QPerson;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PersonController implements Serializable {

    private PersonForm form = PersonForm.of();

    @PersistenceContext
    private transient EntityManager entityManager;

    public List<Person> findAll() {
        JPAQuery<Person> query = new JPAQuery<Person>(entityManager).select(QPerson.person).from(QPerson.person);
        return query.where(form.toPredicate()).fetch();
    }

    public PersonForm getForm() {
        return form;
    }
}
