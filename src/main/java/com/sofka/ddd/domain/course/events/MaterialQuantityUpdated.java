package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Quantity;

public class MaterialQuantityUpdated extends DomainEvent {

    private final MaterialID materialID;
    private final Quantity quantity;

    public MaterialQuantityUpdated(MaterialID materialID, Quantity quantity) {
        super("ddd.domain.course.MaterialQuantityUpdated");
        this.materialID = materialID;
        this.quantity = quantity;
    }

    public MaterialID getMaterialID() {
        return materialID;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
