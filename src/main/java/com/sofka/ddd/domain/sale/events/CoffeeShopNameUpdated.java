package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.generics.CoffeeShopName;

public class CoffeeShopNameUpdated extends DomainEvent {
    private final CoffeeShopName coffeeShopName;

    public CoffeeShopNameUpdated(CoffeeShopName coffeeShopName) {
        super("ddd.domain.cafe.CoffeeShopNameUpdated");
        this.coffeeShopName = coffeeShopName;
    }

    public CoffeeShopName getCoffeeShopName() {
        return coffeeShopName;
    }
}
