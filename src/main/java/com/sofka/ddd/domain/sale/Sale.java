package com.sofka.ddd.domain.sale;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.events.BaristaAdded;
import com.sofka.ddd.domain.sale.events.BaristaEntranceHourChanged;
import com.sofka.ddd.domain.sale.events.BaristaNameUpdated;
import com.sofka.ddd.domain.sale.events.BaristaOutHourChanged;
import com.sofka.ddd.domain.sale.events.ClientAdded;
import com.sofka.ddd.domain.sale.events.ClientContactNumberUpdated;
import com.sofka.ddd.domain.sale.events.ClientNameUpdated;
import com.sofka.ddd.domain.sale.events.ClientVipStatusUpdated;
import com.sofka.ddd.domain.sale.events.CoffeeShopNameUpdated;
import com.sofka.ddd.domain.sale.events.DateOfSaleChanged;
import com.sofka.ddd.domain.sale.events.ProductAdded;
import com.sofka.ddd.domain.sale.events.ProductNameUpdated;
import com.sofka.ddd.domain.sale.events.ProductPriceUpdated;
import com.sofka.ddd.domain.sale.events.ProductTypeChanged;
import com.sofka.ddd.domain.sale.values.BaristaID;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.ContactNumber;
import com.sofka.ddd.domain.sale.values.DateOfSale;
import com.sofka.ddd.domain.sale.values.Hour;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.Price;
import com.sofka.ddd.domain.sale.values.ProductID;
import com.sofka.ddd.domain.sale.values.Type;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import com.sofka.ddd.domain.sale.events.SaleCreated;
import com.sofka.ddd.domain.sale.values.SaleID;
import com.sofka.ddd.domain.sale.values.VipStatus;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Sale extends AggregateEvent<SaleID> {

    protected CoffeeShopName coffeeShopName;
    protected DateOfSale dateOfSale;
    protected Set<Client> clients;
    protected Set<Barista> baristas;
    protected Set<Product> products;

    public Sale(SaleID entityId, CoffeeShopName coffeeShopName, DateOfSale dateOfSale) {
        super(entityId);
        appendChange(new SaleCreated(coffeeShopName, dateOfSale)).apply();
    }

    private Sale(SaleID saleID) {
        super(saleID);
        subscribe(new SaleChange(this));
    }

    public static Sale from(SaleID saleID, List<DomainEvent> events) {
        var sale = new Sale(saleID);
        events.forEach(sale::applyEvent);
        return sale;
    }

    //------------- FINDERS
    public Optional<Product> getProductById(ProductID productID) {
        return products.stream().filter((product -> product.identity().equals(productID))).findFirst();
    }

    public Optional<Client> getClientById(ClientID clientID) {
        return clients.stream().filter((client -> client.identity().equals(clientID))).findFirst();
    }

    public Optional<Barista> getBaristaById(BaristaID baristaID) {
        return baristas.stream().filter((barista -> barista.identity().equals(baristaID))).findFirst();
    }
    //------------

    //----------- BEHAVIORS

    public void updateCoffeeShopName(CoffeeShopName coffeeShopName) {
        Objects.requireNonNull(coffeeShopName);
        appendChange(new CoffeeShopNameUpdated(coffeeShopName)).apply();
    }

    public void changeDateOfSale(DateOfSale dateOfSale) {
        Objects.requireNonNull(dateOfSale);
        appendChange(new DateOfSaleChanged(dateOfSale)).apply();
    }

    public void addProduct(ProductID entityID, Name name, Price price, Type type) {
        Objects.requireNonNull(entityID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);
        Objects.requireNonNull(type);
        appendChange(new ProductAdded(entityID, name, price, type)).apply();
    }

    public void updateProductName(ProductID productID, Name name) {
        Objects.requireNonNull(productID);
        Objects.requireNonNull(name);
        appendChange(new ProductNameUpdated(productID, name)).apply();
    }

    public void updateProductPrice(ProductID productID, Price price) {
        Objects.requireNonNull(productID);
        Objects.requireNonNull(price);
        appendChange(new ProductPriceUpdated(productID, price)).apply();
    }

    public void changeProductType(ProductID productID, Type type) {
        Objects.requireNonNull(productID);
        Objects.requireNonNull(type);
        appendChange(new ProductTypeChanged(productID, type)).apply();
    }

    public void addBarista(BaristaID baristaID, Name name, Hour entranceHour, Hour outHour) {
        Objects.requireNonNull(baristaID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(entranceHour);
        Objects.requireNonNull(outHour);
        appendChange(new BaristaAdded(baristaID, name, entranceHour, outHour)).apply();
    }

    public void updateBaristaName(BaristaID baristaID, Name name) {
        Objects.requireNonNull(baristaID);
        Objects.requireNonNull(name);
        appendChange(new BaristaNameUpdated(baristaID, name)).apply();
    }

    public void changeBaristaEntranceHour(BaristaID baristaID, Hour entranceHour) {
        Objects.requireNonNull(baristaID);
        Objects.requireNonNull(entranceHour);
        appendChange(new BaristaEntranceHourChanged(baristaID, entranceHour)).apply();
    }

    public void changeBaristaOutHour(BaristaID baristaID, Hour outHour) {
        Objects.requireNonNull(baristaID);
        Objects.requireNonNull(outHour);
        appendChange(new BaristaOutHourChanged(baristaID, outHour)).apply();
    }

    public void addClient(ClientID entityID, Name name, ContactNumber contactNumber, VipStatus vipStatus) {
        Objects.requireNonNull(entityID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(contactNumber);
        Objects.requireNonNull(vipStatus);
        appendChange(new ClientAdded(entityID, name, contactNumber, vipStatus)).apply();
    }

    public void updateClientName(ClientID clientID, Name name) {
        Objects.requireNonNull(clientID);
        Objects.requireNonNull(name);
        appendChange(new ClientNameUpdated(clientID, name)).apply();
    }

    public void updateClientContactNumber(ClientID clientID, ContactNumber contactNumber) {
        Objects.requireNonNull(clientID);
        Objects.requireNonNull(contactNumber);
        appendChange(new ClientContactNumberUpdated(clientID, contactNumber)).apply();
    }

    public void updateClientVipStatus(ClientID clientID, VipStatus vipStatus) {
        Objects.requireNonNull(clientID);
        Objects.requireNonNull(vipStatus);
        appendChange(new ClientVipStatusUpdated(clientID, vipStatus)).apply();
    }

    //-----

    //----- ACCESS

    public CoffeeShopName coffeeShopName() {
        return coffeeShopName;
    }

    public DateOfSale dateOfSale() {
        return dateOfSale;
    }

    public Set<Client> clients() {
        return clients;
    }

    public Set<Barista> baristas() {
        return baristas;
    }

    public Set<Product> products() {
        return products;
    }
}
