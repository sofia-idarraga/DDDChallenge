package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.Price;

public class PriceChanged extends DomainEvent {

    private final Price price;

    public PriceChanged(Price price) {
        super("ddd.domain.course.PriceChanged");
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }
}
