package me.yanaga.samples.view;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import me.yanaga.samples.domain.model.QPerson;

import java.io.Serializable;

public class PersonForm implements Serializable {

    private SearchText name = SearchText.EMPTY;

    private SearchText surname = SearchText.EMPTY;

    private PersonForm() {
    }

    public static PersonForm of() {
        return new PersonForm();
    }

    // The form holds the criteria, so it builds the query condition. No null checks needed
    public Predicate toPredicate() {
        BooleanBuilder builder = new BooleanBuilder();
        name.appendContains(builder, QPerson.person.name.stringValue());
        surname.appendContains(builder, QPerson.person.surname.stringValue());
        return builder;
    }

    // Getters and setters are required by Faces to bind the form fields
    public SearchText getName() {
        return name;
    }

    public void setName(SearchText name) {
        this.name = name == null ? SearchText.EMPTY : name;
    }

    public SearchText getSurname() {
        return surname;
    }

    public void setSurname(SearchText surname) {
        this.surname = surname == null ? SearchText.EMPTY : surname;
    }
}
