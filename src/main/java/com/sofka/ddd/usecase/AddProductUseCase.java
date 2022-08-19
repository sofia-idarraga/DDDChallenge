package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.sale.Sale;
import com.sofka.ddd.domain.sale.commands.AddProduct;

public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddProduct> addProductRequestCommand) {
        var command = addProductRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleID(), retrieveEvents(command.getSaleID().value()));
        sale.addProduct(command.getEntityID(), command.getName(), command.getPrice(), command.getType());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
