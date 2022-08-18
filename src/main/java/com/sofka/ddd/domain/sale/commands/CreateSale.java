package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import com.sofka.ddd.domain.sale.values.DateOfSale;
import com.sofka.ddd.domain.sale.values.SaleID;

public class CreateSale extends Command {

    private final SaleID saleID;
    private final CoffeeShopName coffeeShopName;

    private final DateOfSale dateOfSale;

    public CreateSale(SaleID saleID, CoffeeShopName coffeeShopName, DateOfSale dateOfSale){
        this.saleID = saleID;
        this.coffeeShopName = coffeeShopName;
        this.dateOfSale =dateOfSale;
    }

    public SaleID getSaleID() {
        return saleID;
    }

    public DateOfSale getDateOfSale() {
        return dateOfSale;
    }
    public CoffeeShopName getCoffeeShopName() {
        return coffeeShopName;
    }
}
