package com.dinesh.project.ms.dp.command.api.cmds;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class UpdateProductCommand {

    @TargetAggregateIdentifier
    private String id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
