package com.dinesh.project.ms.dp.command.api.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteProductEvent {
    private String id;
}
