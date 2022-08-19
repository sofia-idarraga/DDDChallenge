package com.sofka.ddd.domain.course.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.validator.GenericValidator;

import java.util.Objects;

import static java.lang.Float.parseFloat;

public class Age implements ValueObject<String> {

    private final String value;

    public Age(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The VO age can't be blank");
        }
        if (!GenericValidator.isInt(this.value)) {
            throw new IllegalArgumentException("The VO age must be a number");
        }
        if (!GenericValidator.minValue(parseFloat(this.value), 15)) {
            throw new IllegalArgumentException("The VO age must be at least 15");
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
        Age age = (Age) o;
        return Objects.equals(value, age.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
