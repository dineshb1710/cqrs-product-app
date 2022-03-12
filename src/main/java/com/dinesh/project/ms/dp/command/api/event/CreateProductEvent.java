package com.dinesh.project.ms.dp.command.api.event;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateProductEvent {
    private String id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
