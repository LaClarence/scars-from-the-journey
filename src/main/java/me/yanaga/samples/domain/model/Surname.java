package me.yanaga.samples.domain.model;

import java.io.Serializable;
import java.util.Objects;

public class Surname implements Serializable, Comparable<Surname> {

    private final String value;

    private Surname(String value) {
        this.value = value;
    }

    public static Surname of(String value) {
        Objects.requireNonNull(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("Surname must not be blank");
        }
        return new Surname(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Surname) {
            Surname other = (Surname) obj;
            return Objects.equals(this.value, other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(Surname o) {
        return this.value.compareTo(o.value);
    }

}
