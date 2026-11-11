package me.yanaga.samples.view;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.StringExpression;

import java.io.Serializable;
import java.util.Objects;

/**
 * Text typed in a search field. Never null: an empty field is {@link #EMPTY}, which adds no
 * condition to the query (null object pattern), so forms need no null checks.
 * Plays the role of SingleStringArgument from the original demo's querydsl-args library.
 */
public record SearchText(String value) implements Serializable {

    public static final SearchText EMPTY = new SearchText("");

    public SearchText {
        Objects.requireNonNull(value);
        value = value.trim();
    }

    public static SearchText of(String value) {
        return value == null || value.isBlank() ? EMPTY : new SearchText(value);
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    // Adds a case-insensitive "contains" condition on the path, or nothing when empty
    public void appendContains(BooleanBuilder builder, StringExpression path) {
        if (!isEmpty()) {
            builder.and(path.containsIgnoreCase(value));
        }
    }
}
