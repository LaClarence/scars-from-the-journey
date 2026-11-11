package me.yanaga.samples.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Person implements Serializable {

    // Not exposed: a primary key means nothing to the user. toString() shows it for debugging
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Name name;

    private Surname surname;

    // Required by JPA
    protected Person() {
    }

    private Person(Name name, Surname surname) {
        this.name = name;
        this.surname = surname;
    }

    public static Person of(Name name, Surname surname) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(surname);
        return new Person(name, surname);
    }

    public Name getName() {
        return name;
    }

    public Surname getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Person[id=" + id + ", " + name + ", " + surname + "]";
    }

}
