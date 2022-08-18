package com.sofka.ddd.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.validator.GenericValidator;

import java.util.Objects;

public class Hour implements ValueObject<String> {

    private final String value;

    public Hour(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The VO hour can't be blank");
        }
        if(!GenericValidator.isDate(this.value, "hh:mm", true)){
            throw new IllegalArgumentException("The VO hour don't match the pattern: hh:mm");
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
        Hour hour = (Hour) o;
        return Objects.equals(value, hour.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
