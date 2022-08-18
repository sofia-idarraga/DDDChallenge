package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.SaleID;
import com.sofka.ddd.domain.generics.CoffeeShopName;

public class UpdateCoffeeShopName extends Command {

    private final SaleID saleID;
    private final CoffeeShopName coffeeShopName;

    public UpdateCoffeeShopName(SaleID saleID, CoffeeShopName coffeeShopName) {
        this.saleID = saleID;
        this.coffeeShopName = coffeeShopName;
    }

    public SaleID getCafeID() {
        return saleID;
    }

    public CoffeeShopName getCoffeeShopName() {
        return coffeeShopName;
    }
}
