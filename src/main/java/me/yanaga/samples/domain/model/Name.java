package me.yanaga.samples.domain.model;

import java.io.Serializable;
import java.util.Objects;

public record Name(String value) implements Serializable, Comparable<Name> {

    public Name {
        Objects.requireNonNull(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
    }

    public static Name of(String value) {
        return new Name(value);
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
