package com.sofka.ddd.domain.course.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.validator.GenericValidator;

import java.util.Objects;

import static java.lang.Float.parseFloat;

public class Price implements ValueObject<String> {

    private final String value;

    public Price(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The VO price can't be blank");
        }
        if(!GenericValidator.isFloat(this.value)){
            throw new IllegalArgumentException("The VO price must be a number");
        }
        if(!GenericValidator.minValue(parseFloat(this.value),0)){
            throw new IllegalArgumentException("The VO price can't be a negative number");
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
        Price price = (Price) o;
        return Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
