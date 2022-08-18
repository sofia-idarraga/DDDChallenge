package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import com.sofka.ddd.domain.sale.values.DateOfSale;

public class SaleCreated extends DomainEvent {

    private final CoffeeShopName coffeeShopName;

    private final DateOfSale dateOfSale;


    public SaleCreated(CoffeeShopName coffeeShopName, DateOfSale dateOfSale){
        super("ddd.domain.cafe.SaleCreated");
        this.coffeeShopName = coffeeShopName;
        this.dateOfSale = dateOfSale;

    }

    public DateOfSale getDateOfSale() {
        return dateOfSale;
    }

    public CoffeeShopName getCoffeeShopName() {
        return coffeeShopName;
    }

}
