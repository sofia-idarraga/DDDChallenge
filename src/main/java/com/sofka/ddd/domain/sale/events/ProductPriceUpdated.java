package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.Price;
import com.sofka.ddd.domain.sale.values.ProductID;

public class ProductPriceUpdated extends DomainEvent {

    private final ProductID productID;
    public final Price price;

    public ProductPriceUpdated( ProductID productID, Price price) {
        super("ddd.domain.sale.ProductPriceUpdated");
        this.productID = productID;
        this.price = price;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Price getPrice() {
        return price;
    }
}
