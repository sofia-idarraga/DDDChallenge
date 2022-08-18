package com.sofka.ddd.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.validator.GenericValidator;

import java.util.Objects;

import static java.lang.Float.parseFloat;

public class ContactNumber implements ValueObject<String> {

    private final String value;

    public ContactNumber(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The VO contact number can't be blank");
        }
        if(!GenericValidator.isInt(this.value)){
            throw new IllegalArgumentException("The VO contact number must be a number");
        }
        if(!GenericValidator.minValue(parseFloat(this.value),0)){
            throw new IllegalArgumentException("The VO contact number can't be a negative number");
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
        ContactNumber contactNumber = (ContactNumber) o;
        return Objects.equals(value, contactNumber.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
