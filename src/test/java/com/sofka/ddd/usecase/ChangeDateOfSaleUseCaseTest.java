package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import com.sofka.ddd.domain.sale.commands.ChangeDateOfSale;
import com.sofka.ddd.domain.sale.events.DateOfSaleChanged;
import com.sofka.ddd.domain.sale.events.SaleCreated;
import com.sofka.ddd.domain.sale.values.DateOfSale;
import com.sofka.ddd.domain.sale.values.SaleID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
class ChangeDateOfSaleUseCaseTest {

    private final String SALE_ID = "1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void changeDateOfSaleTest() {

        // Arrange
        var saleID = new SaleID().of(SALE_ID);
        var coffeeShopName = new CoffeeShopName("Starbucks");
        var date = new DateOfSale("12/08/2022");
        var newDate = new DateOfSale("13/08/2022");

        SaleCreated saleCreated = new SaleCreated(coffeeShopName, date);
        saleCreated.setAggregateRootId(SALE_ID);

        ChangeDateOfSale command = new ChangeDateOfSale(saleID, newDate);
        ChangeDateOfSaleUseCase useCase = new ChangeDateOfSaleUseCase();

        Mockito.when(repository.getEventsBy(SALE_ID))
                .thenReturn(List.of(saleCreated));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(SALE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong changing date"))
                .getDomainEvents();

        var event = (DateOfSaleChanged) events.get(0);

        //Assert
        assertEquals("13/08/2022", event.getDateOfSale().value());
        assertNotEquals("12/08/2022", event.getDateOfSale().value());
        Mockito.verify(repository).getEventsBy(SALE_ID);
    }

}