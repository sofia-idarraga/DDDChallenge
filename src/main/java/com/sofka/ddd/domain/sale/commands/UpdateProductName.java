package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.SaleID;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.ProductID;

public class UpdateProductName extends Command {

    private final SaleID saleID;
    private final ProductID productID;
    private final Name name;

    public UpdateProductName(SaleID saleID, ProductID productID, Name name) {
        this.saleID = saleID;
        this.productID = productID;
        this.name = name;
    }

    public SaleID getCafeID() {
        return saleID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Name getName() {
        return name;
    }
}
