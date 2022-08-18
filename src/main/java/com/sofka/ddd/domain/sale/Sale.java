package com.sofka.ddd.domain.sale;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.events.CoffeeShopNameUpdated;
import com.sofka.ddd.domain.sale.events.ProductAdded;
import com.sofka.ddd.domain.sale.events.ProductNameUpdated;
import com.sofka.ddd.domain.sale.values.BaristaID;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.DateOfSale;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.Price;
import com.sofka.ddd.domain.sale.values.ProductID;
import com.sofka.ddd.domain.sale.values.Type;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import com.sofka.ddd.domain.sale.events.SaleCreated;
import com.sofka.ddd.domain.sale.values.SaleID;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Sale extends AggregateEvent<SaleID> {

    protected CoffeeShopName coffeeShopName;

    protected DateOfSale dateOfSale;
    protected Set<Client> clients;
    protected Set<Barista> baristas;
    protected Set <Product> products;
    public Sale(SaleID entityId, CoffeeShopName coffeeShopName, DateOfSale dateOfSale) {
        super(entityId);
        appendChange(new SaleCreated(coffeeShopName)).apply();
    }

    private Sale(SaleID saleID){
        super(saleID);
        subscribe(new SaleChange(this));
    }

    public static Sale from(SaleID saleID, List<DomainEvent> events){
        var sale = new Sale(saleID);
        events.forEach(sale::applyEvent);
        return sale;
    }

    //------------- FINDERS
    public Optional<Product> getProductById(ProductID productID){
        return products.stream().filter((product -> product.identity().equals(productID))).findFirst();
    }

    public Optional<Client> getClientById(ClientID clientID){
        return clients.stream().filter((client -> client.identity().equals(clientID))).findFirst();
    }

    public Optional<Barista> getBaristaById(BaristaID baristaID){
        return baristas.stream().filter((barista -> barista.identity().equals(baristaID))).findFirst();
    }
    //------------

    public void updateCoffeeShopName(CoffeeShopName coffeeShopName){
        Objects.requireNonNull(coffeeShopName);
        appendChange(new CoffeeShopNameUpdated(coffeeShopName)).apply();
    }

    public void addProduct(ProductID entityID, Name name, Price price, Type type){
        Objects.requireNonNull(entityID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);
        Objects.requireNonNull(type);
        appendChange(new ProductAdded(entityID,name,price,type)).apply();
    }

    public void updateProductName(ProductID productID, Name name){
        Objects.requireNonNull(productID);
        Objects.requireNonNull(name);
        appendChange(new ProductNameUpdated(productID,name)).apply();
    }
}
