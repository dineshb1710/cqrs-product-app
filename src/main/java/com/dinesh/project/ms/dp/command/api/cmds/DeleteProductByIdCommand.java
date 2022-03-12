package com.dinesh.project.ms.dp.command.api.cmds;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DeleteProductByIdCommand {

    @TargetAggregateIdentifier
    private String id;
}
