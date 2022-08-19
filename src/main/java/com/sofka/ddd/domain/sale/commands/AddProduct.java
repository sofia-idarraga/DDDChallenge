package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.SaleID;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.Price;
import com.sofka.ddd.domain.sale.values.ProductID;
import com.sofka.ddd.domain.sale.values.Type;

public class AddProduct extends Command {

    private final SaleID saleID;
    private final ProductID entityID;
    private final Name name;
    private final Price price;
    private final Type type;

    public AddProduct(SaleID saleID, ProductID entityID, Name name, Price price, Type type){
        this.saleID = saleID;
        this.entityID=entityID;
        this.name=name;
        this.price=price;
        this.type=type;
    }

    public SaleID getSaleID() {
        return saleID;
    }

    public ProductID getEntityID() {
        return entityID;
    }

    public Name getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }
}
