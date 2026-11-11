package me.yanaga.samples.view;

import com.querydsl.jpa.impl.JPAQuery;
import me.yanaga.samples.domain.model.Person;
import me.yanaga.samples.domain.model.QPerson;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PersonController implements Serializable {

    private PersonForm form = PersonForm.of();

    private List<Person> results = List.of();

    @PersistenceContext
    private transient EntityManager entityManager;

    public void search() {
        JPAQuery<Person> query = new JPAQuery<Person>(entityManager).select(QPerson.person).from(QPerson.person);
        results = query.where(form.toPredicate()).fetch();
    }

    public List<Person> getResults() {
        return results;
    }

    public PersonForm getForm() {
        return form;
    }
}
