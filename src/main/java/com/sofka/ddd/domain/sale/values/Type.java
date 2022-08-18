package com.sofka.ddd.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Type implements ValueObject<String> {

    private final String value;

    public Type(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The VO Product Type cant be blank");
        }
        if(this.value.length() < 3){
            throw new IllegalArgumentException("The VO Product Type cant have less than 5 letters");
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
        Type type = (Type) o;
        return Objects.equals(value, type.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
