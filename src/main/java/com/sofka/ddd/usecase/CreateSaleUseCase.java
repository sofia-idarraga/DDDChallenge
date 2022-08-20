package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.sale.Sale;
import com.sofka.ddd.domain.sale.commands.CreateSale;

public class CreateSaleUseCase extends UseCase<RequestCommand<CreateSale>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateSale> createCafeRequestCommand) {
        var command = createCafeRequestCommand.getCommand();
        var sale = new Sale(
                command.getSaleID(),
                command.getCoffeeShopName(),
                command.getDateOfSale()
        );

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
