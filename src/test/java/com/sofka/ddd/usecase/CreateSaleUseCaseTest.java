package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import com.sofka.ddd.domain.sale.commands.CreateSale;
import com.sofka.ddd.domain.sale.events.SaleCreated;
import com.sofka.ddd.domain.sale.values.DateOfSale;
import com.sofka.ddd.domain.sale.values.SaleID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CreateSaleUseCaseTest {

    @Test
    public void createSaleCaseTest() {
        //Arrange
        var id = new SaleID();
        var name = new CoffeeShopName("Starbucks");
        var date = new DateOfSale("12/08/2022");
        CreateSale command = new CreateSale(id, name, date);
        CreateSaleUseCase useCase = new CreateSaleUseCase();

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong creating sale"))
                .getDomainEvents();

        SaleCreated event = (SaleCreated) events.get(0);

        //Assert
        assertEquals(command.getCoffeeShopName().value(), event.getCoffeeShopName().value());
    }

    @Test
    public void createSaleCaseTest_DateError() {
        //Arrange
        var id = new SaleID();
        var name = new CoffeeShopName("Starbucks");

        var message = assertThrows(IllegalArgumentException.class, () -> {
            var date = new DateOfSale("12 08 2022");

            CreateSale command = new CreateSale(id, name, date);
            CreateSaleUseCase useCase = new CreateSaleUseCase();

            //Act
            var events = UseCaseHandler
                    .getInstance()
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow(() -> new IllegalArgumentException("Something went wrong creating sale"))
                    .getDomainEvents();

            SaleCreated event = (SaleCreated) events.get(0);
        }).getMessage();


        //Assert
        assertEquals("The VO Date of Sale don't match the pattern: dd/MM/yyyy", message);
    }
}