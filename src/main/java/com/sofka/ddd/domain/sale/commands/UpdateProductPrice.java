package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.Price;
import com.sofka.ddd.domain.sale.values.ProductID;
import com.sofka.ddd.domain.sale.values.SaleID;

public class UpdateProductPrice extends Command {

    private final SaleID saleID;
    private final ProductID productID;
    public final Price price;

    public UpdateProductPrice(SaleID saleID, ProductID productID, Price price) {
        this.saleID = saleID;
        this.productID = productID;
        this.price = price;
    }

    public SaleID getSaleID() {
        return saleID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Price getPrice() {
        return price;
    }
}
