package com.dinesh.project.ms.dp.command.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
