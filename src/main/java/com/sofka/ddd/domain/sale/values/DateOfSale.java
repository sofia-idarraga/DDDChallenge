package com.sofka.ddd.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.validator.GenericValidator;

import java.util.Objects;

public class DateOfSale implements ValueObject<String> {
    private final String value;

    public DateOfSale(String value) {
        this.value = value;
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The VO Date of Sale can't be blank");
        }
        if(!GenericValidator.isDate(this.value, "dd/MM/yyyy", true)){
            throw new IllegalArgumentException("The VO Date of Sale don't match the pattern: dd/MM/yyyy");
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
        DateOfSale dateOfSale = (DateOfSale) o;
        return Objects.equals(value, dateOfSale.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
