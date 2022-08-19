package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import com.sofka.ddd.domain.sale.commands.AddProduct;
import com.sofka.ddd.domain.sale.events.ProductAdded;
import com.sofka.ddd.domain.sale.events.SaleCreated;
import com.sofka.ddd.domain.sale.values.DateOfSale;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.Price;
import com.sofka.ddd.domain.sale.values.ProductID;
import com.sofka.ddd.domain.sale.values.SaleID;
import com.sofka.ddd.domain.sale.values.Type;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AddProductUseCaseTest {

    private final String SALE_ID = "1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addProduct() {

        // Arrange
        var saleID = new SaleID().of(SALE_ID);
        var productID = new ProductID();
        var productName = new Name("Capuccino");
        var price = new Price("2.50");
        var type = new Type("Coffee Drink");
        var coffeeShopName = new CoffeeShopName("Starbucks");
        var date = new DateOfSale("12/08/2022");

        SaleCreated saleCreated = new SaleCreated(coffeeShopName, date);
        saleCreated.setAggregateRootId(SALE_ID);

        AddProduct command = new AddProduct(saleID, productID, productName, price, type);
        AddProductUseCase useCase = new AddProductUseCase();

        Mockito.when(repository.getEventsBy(SALE_ID))
                .thenReturn(List.of(saleCreated));

        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(SALE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding product"))
                .getDomainEvents();
        var event = (ProductAdded) events.get(0);

        //Assert
        assertEquals("Capuccino", event.getName().value());
        assertEquals(SALE_ID, event.aggregateRootId());
        assertEquals("2.50", event.getPrice().value());
        Mockito.verify(repository).getEventsBy(SALE_ID);
    }

    @Test
    void addProduct_PriceError() {

        // Arrange
        var saleID = new SaleID().of(SALE_ID);
        var productID = new ProductID();
        var productName = new Name("Capuccino");


        var message = assertThrows(IllegalArgumentException.class, () -> {
            var price = new Price("two dollars");
            var type = new Type("Coffee Drink");
            var coffeeShopName = new CoffeeShopName("Starbucks");
            var date = new DateOfSale("12/08/2022");

            SaleCreated saleCreated = new SaleCreated(coffeeShopName, date);
            saleCreated.setAggregateRootId(SALE_ID);

            AddProduct command = new AddProduct(saleID, productID, productName, price, type);
            AddProductUseCase useCase = new AddProductUseCase();

            Mockito.when(repository.getEventsBy(SALE_ID))
                    .thenReturn(List.of(saleCreated));

            useCase.addRepository(repository);

            //Act
            var events = UseCaseHandler.getInstance()
                    .setIdentifyExecutor(SALE_ID)
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding product"))
                    .getDomainEvents();
            var event = (ProductAdded) events.get(0);

        }).getMessage();

        //Assert
        assertEquals("The VO price must be a number", message);
    }
}