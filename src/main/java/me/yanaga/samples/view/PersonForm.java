package me.yanaga.samples.view;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringExpression;
import me.yanaga.samples.domain.model.QPerson;

import java.io.Serializable;

public class PersonForm implements Serializable {

    private String name;

    private String surname;

    private PersonForm() {
    }

    public static PersonForm of() {
        return new PersonForm();
    }

    public Predicate toPredicate() {
        BooleanBuilder builder = new BooleanBuilder();
        appendContains(builder, QPerson.person.name.stringValue(), name);
        appendContains(builder, QPerson.person.surname.stringValue(), surname);
        return builder;
    }

    // Same behaviour as querydsl-args' SingleStringArgument: case-insensitive "contains", skipped when empty
    private static void appendContains(BooleanBuilder builder, StringExpression path, String value) {
        if (value != null && !value.isBlank()) {
            builder.and(path.containsIgnoreCase(value.trim()));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
