package me.yanaga.samples.domain.model;

import java.io.Serializable;
import java.util.Objects;

public record Surname(String value) implements Serializable, Comparable<Surname> {

    public Surname {
        Objects.requireNonNull(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("Surname must not be blank");
        }
    }

    public static Surname of(String value) {
        return new Surname(value);
    }

    @Override
    public int compareTo(Surname o) {
        return this.value.compareTo(o.value);
    }

}
