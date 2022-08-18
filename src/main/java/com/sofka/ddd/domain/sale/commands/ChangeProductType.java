package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.ProductID;
import com.sofka.ddd.domain.sale.values.SaleID;
import com.sofka.ddd.domain.sale.values.Type;

public class ChangeProductType extends Command {

    private final SaleID saleID;
    private final ProductID productID;
    public final Type type;

    public ChangeProductType(SaleID saleID, ProductID productID, Type type) {
        this.saleID = saleID;
        this.productID = productID;
        this.type = type;
    }

    public SaleID getSaleID() {
        return saleID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Type getType() {
        return type;
    }
}
