package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.Price;
import com.sofka.ddd.domain.sale.values.ProductID;
import com.sofka.ddd.domain.sale.values.Type;

public class ProductAdded extends DomainEvent {
    private final ProductID entityID;
    private final Name name;
    private final Price price;
    private final Type type;

    public ProductAdded(ProductID entityID, Name name, Price price, Type type) {
        super("ddd.domain.sale.ProductAdded");
        this.entityID = entityID;
        this.name = name;
        this.price = price;
        this.type = type;
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
