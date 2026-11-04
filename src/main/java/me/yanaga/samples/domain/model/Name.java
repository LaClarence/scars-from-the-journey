package me.yanaga.samples.domain.model;

import java.io.Serializable;
import java.util.Objects;

public class Name implements Serializable, Comparable<Name> {

    private final String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name of(String value) {
        Objects.requireNonNull(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        return new Name(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name other) {
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
    public int compareTo(Name o) {
        return this.value.compareTo(o.value);
    }

}
