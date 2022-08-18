package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.Price;
import com.sofka.ddd.domain.sale.values.ProductID;
import com.sofka.ddd.domain.sale.values.Type;

public class ProductTypeChanged extends DomainEvent {

    private final ProductID productID;
    public final Type type;

    public ProductTypeChanged( ProductID productID, Type type) {
        super("ddd.domain.sale.ProductTypeUpdated");
        this.productID = productID;
        this.type = type;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Type getType() {
        return type;
    }
}
