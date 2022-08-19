package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.ProductID;

public class ProductNameUpdated extends DomainEvent {

    private final ProductID productID;
    private final Name name;

    public ProductNameUpdated(ProductID productID, Name name) {
        super("ddd.domain.sale.ProductNameUpdated");
        this.productID = productID;
        this.name = name;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Name getName() {
        return name;
    }
}
