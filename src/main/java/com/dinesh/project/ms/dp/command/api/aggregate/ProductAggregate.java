package com.dinesh.project.ms.dp.command.api.aggregate;

import com.dinesh.project.ms.dp.command.api.cmds.CreateProductCommand;
import com.dinesh.project.ms.dp.command.api.cmds.DeleteProductByIdCommand;
import com.dinesh.project.ms.dp.command.api.cmds.UpdateProductCommand;
import com.dinesh.project.ms.dp.command.api.event.CreateProductEvent;
import com.dinesh.project.ms.dp.command.api.event.DeleteProductEvent;
import com.dinesh.project.ms.dp.command.api.event.UpdateProductEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private Integer quantity;
    private BigDecimal price;

    public ProductAggregate() {
        // Default Constructor..
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {

        // Create appropriate event for this command..
        CreateProductEvent createProductEvent = CreateProductEvent.builder()
                .id(createProductCommand.getId())
                .name(createProductCommand.getName())
                .quantity(createProductCommand.getQuantity())
                .price(createProductCommand.getPrice())
                .build();

        // Pass this event to EventHandler..
        AggregateLifecycle.apply(createProductEvent);
    }

    @CommandHandler
    public void update(UpdateProductCommand updateProductCommand) {

        // Create appropriate event for this command..
        UpdateProductEvent updateProductEvent = UpdateProductEvent.builder()
                .id(updateProductCommand.getId())
                .name(updateProductCommand.getName())
                .quantity(updateProductCommand.getQuantity())
                .price(updateProductCommand.getPrice())
                .build();

        // Pass this event to EventHandler..
        AggregateLifecycle.apply(updateProductEvent);
    }

    @CommandHandler
    public void delete(DeleteProductByIdCommand deleteProductByIdCommand) {

        // Create appropriate event for this command..
        DeleteProductEvent deleteProductEvent = DeleteProductEvent.builder()
                .id(deleteProductByIdCommand.getId())
                .build();

        // Pass this event to EventHandler..
        AggregateLifecycle.apply(deleteProductEvent);
    }

    @EventSourcingHandler
    public void onCreateProductEvent(CreateProductEvent createProductEvent) {
        this.id = createProductEvent.getId();
        this.name = createProductEvent.getName();
        this.price = createProductEvent.getPrice();
        this.quantity = createProductEvent.getQuantity();
    }

    @EventSourcingHandler
    public void onUpdateProductEvent(UpdateProductEvent updateProductEvent) {
        this.id = updateProductEvent.getId();
        this.name = updateProductEvent.getName();
        this.price = updateProductEvent.getPrice();
        this.quantity = updateProductEvent.getQuantity();
    }

    @EventSourcingHandler
    public void onDeleteProductEvent(DeleteProductEvent deleteProductEvent) {
        this.id = deleteProductEvent.getId();
    }
}
