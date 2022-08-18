package com.sofka.ddd.domain.sale;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.sale.events.SaleCreated;
import com.sofka.ddd.domain.sale.events.CoffeeShopNameUpdated;
import com.sofka.ddd.domain.sale.events.ProductAdded;
import com.sofka.ddd.domain.sale.events.ProductNameUpdated;

import java.util.HashSet;

public class SaleChange extends EventChange {

    public SaleChange(Sale sale){
        apply((SaleCreated event)->{
            sale.coffeeShopName = event.getCoffeeShopName();
            sale.dateOfSale = event.getDateOfSale();
            sale.baristas = new HashSet<>();
            sale.clients = new HashSet<>();
            sale.products = new HashSet<>();
        });

        apply((CoffeeShopNameUpdated event) ->{
            sale.coffeeShopName = event.getCoffeeShopName();
        });

        apply((ProductAdded event) ->{
            sale.products.add(new Product(
                    event.getEntityID(),
                    event.getName(),
                    event.getPrice(),
                    event.getType()
                    ));
        });

        apply((ProductNameUpdated event)->{
            var product = sale.getProductById(event.getProductID())
                    .orElseThrow(()->new IllegalArgumentException("Product ID doesn't exist"));
            product.updateName(event.getName());
        });
    }

}
