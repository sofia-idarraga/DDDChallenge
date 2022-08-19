package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import com.sofka.ddd.domain.sale.commands.AddBarista;
import com.sofka.ddd.domain.sale.events.BaristaAdded;
import com.sofka.ddd.domain.sale.events.SaleCreated;
import com.sofka.ddd.domain.sale.values.BaristaID;
import com.sofka.ddd.domain.sale.values.DateOfSale;
import com.sofka.ddd.domain.sale.values.Hour;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.SaleID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddBaristaUseCaseTest {

    private final String SALE_ID = "1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addBaristaTest(){
        // Arrange
        var saleID = new SaleID().of(SALE_ID);
        var baristaID = new BaristaID();
        var baristaName = new Name("Sara Parker");
        var entranceHour = new Hour("12:30");
        var outHour = new Hour("08:00");
        var coffeeShopName = new CoffeeShopName("Starbucks");
        var date = new DateOfSale("12/08/2022");

        SaleCreated saleCreated = new SaleCreated(coffeeShopName,date);
        saleCreated.setAggregateRootId(SALE_ID);

        AddBarista command = new AddBarista(saleID,baristaID,baristaName,entranceHour,outHour);
        AddBaristaUseCase useCase = new AddBaristaUseCase();

        Mockito.when(repository.getEventsBy(SALE_ID))
                .thenReturn(List.of(saleCreated));

        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(SALE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding barista"))
                .getDomainEvents();
        var event = (BaristaAdded) events.get(0);

        //Assert
        assertEquals("Sara Parker",event.getName().value());
        assertEquals(baristaID.value(), event.getBaristaID().value());
        Mockito.verify(repository).getEventsBy(SALE_ID);

    }

}