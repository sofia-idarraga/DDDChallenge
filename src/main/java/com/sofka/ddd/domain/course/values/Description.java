package com.sofka.ddd.domain.course.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {

    private final String value;

    public Description(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The VO description can't be blank");
        }
        if (this.value.length() < 10) {
            throw new IllegalArgumentException("The VO description can't have less than 10 letters");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description description = (Description) o;
        return Objects.equals(value, description.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
