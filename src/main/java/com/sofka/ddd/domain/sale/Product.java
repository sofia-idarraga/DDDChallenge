package com.sofka.ddd.domain.sale;

import co.com.sofka.domain.generic.Entity;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.Price;
import com.sofka.ddd.domain.sale.values.ProductID;
import com.sofka.ddd.domain.sale.values.Type;

import java.util.Objects;

public class Product extends Entity<ProductID> {

    private Name name;

    private Price price;

    private Type type;


    public Product(ProductID entityId, Name name, Price price, Type type) {
        super(entityId);
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Name name() {
        return name;
    }

    public Price price() {
        return price;
    }

    public Type type() {
        return type;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void updatePrice(Price price) {
        this.price = Objects.requireNonNull(price);
    }

    public void changeType(Type type) {
        this.type = Objects.requireNonNull(type);
    }
}