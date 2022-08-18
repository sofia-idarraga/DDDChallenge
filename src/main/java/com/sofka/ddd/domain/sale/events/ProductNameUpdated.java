package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.ProductID;

public class ProductNameUpdated extends DomainEvent {

    private final ProductID productID;
    public final Name name;

    public ProductNameUpdated(ProductID productID, Name name) {
        super("ddd.domain.cafe.ProductNameChanged");
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
