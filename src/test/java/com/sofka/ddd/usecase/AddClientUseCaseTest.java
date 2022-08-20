package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import com.sofka.ddd.domain.sale.commands.AddClient;
import com.sofka.ddd.domain.sale.events.ClientAdded;
import com.sofka.ddd.domain.sale.events.SaleCreated;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.ContactNumber;
import com.sofka.ddd.domain.sale.values.DateOfSale;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.SaleID;
import com.sofka.ddd.domain.sale.values.StatusEnum;
import com.sofka.ddd.domain.sale.values.VipStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {

    private final String SALE_ID = "1";
    @Mock
    private DomainEventRepository repository;

    @Test
    void addClientTest() {
        // Arrange
        var saleID = new SaleID().of(SALE_ID);
        var clientID = new ClientID();
        var clientName = new Name("Bryan");
        var number = new ContactNumber("12345");
        var vip = new VipStatus(StatusEnum.ALLY);
        var coffeeShopName = new CoffeeShopName("Starbucks");
        var date = new DateOfSale("12/08/2022");

        SaleCreated saleCreated = new SaleCreated(coffeeShopName, date);
        saleCreated.setAggregateRootId(SALE_ID);

        AddClient command = new AddClient(saleID, clientID, clientName, number, vip);
        AddClientUseCase useCase = new AddClientUseCase();

        Mockito.when(repository.getEventsBy(SALE_ID))
                .thenReturn(List.of(saleCreated));

        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(SALE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding client"))
                .getDomainEvents();
        var event = (ClientAdded) events.get(0);


        //Assert
        assertEquals("12345", event.getContactNumber().value());
        assertEquals("Bryan", event.getName().value());
        Mockito.verify(repository).getEventsBy(SALE_ID);
    }
}