package com.sofka.ddd.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class VipStatus implements ValueObject<StatusEnum> {

    private final StatusEnum value;

    public VipStatus(StatusEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public StatusEnum value() {
        return value;
    }
}
