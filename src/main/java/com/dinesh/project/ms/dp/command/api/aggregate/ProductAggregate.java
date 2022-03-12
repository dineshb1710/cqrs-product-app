package com.dinesh.project.ms.dp.command.api.aggregate;

import com.dinesh.project.ms.dp.command.api.cmds.CreateProductCommand;
import com.dinesh.project.ms.dp.command.api.event.CreateProductEvent;
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

    @EventSourcingHandler
    public void onCreateProductEvent(CreateProductEvent createProductEvent) {
        this.id = createProductEvent.getId();
        this.name = createProductEvent.getName();
        this.price = createProductEvent.getPrice();
        this.quantity = createProductEvent.getQuantity();
    }
}
