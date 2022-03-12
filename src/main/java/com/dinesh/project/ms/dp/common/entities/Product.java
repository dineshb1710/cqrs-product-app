package com.dinesh.project.ms.dp.common.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
