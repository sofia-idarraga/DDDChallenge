package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.generics.CoffeeShopName;

public class CoffeeShopNameUpdated extends DomainEvent {
    private final CoffeeShopName coffeeShopName;

    public CoffeeShopNameUpdated(CoffeeShopName coffeeShopName) {
        super("ddd.domain.sale.CoffeeShopNameUpdated");
        this.coffeeShopName = coffeeShopName;
    }

    public CoffeeShopName getCoffeeShopName() {
        return coffeeShopName;
    }
}
