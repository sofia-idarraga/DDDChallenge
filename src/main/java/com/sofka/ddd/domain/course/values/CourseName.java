package com.sofka.ddd.domain.course.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CourseName implements ValueObject<String> {
    private final String value;

    public CourseName(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The VO Course Name can't be blank");
        }
        if (this.value.length() < 5) {
            throw new IllegalArgumentException("The VO Course Name can't have less than 5 letters");
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
        CourseName name = (CourseName) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
