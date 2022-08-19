package com.sofka.ddd.domain.course.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.validator.GenericValidator;

import java.util.Objects;

import static java.lang.Float.parseFloat;

public class Quantity implements ValueObject<String> {

    private final String value;

    public Quantity(String value){
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The VO quantity can't be blank");
        }
        if (!GenericValidator.isInt(this.value)) {
            throw new IllegalArgumentException("The VO quantity must be a number");
        }
        if (!GenericValidator.minValue(parseFloat(this.value), 1)) {
            throw new IllegalArgumentException("The VO quantity must be at least 1");
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
        Quantity quantity = (Quantity) o;
        return Objects.equals(value, quantity.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
