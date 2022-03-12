package com.dinesh.project.ms.dp.command.api.controller;

import com.dinesh.project.ms.dp.command.api.cmds.CreateProductCommand;
import com.dinesh.project.ms.dp.command.api.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductCommandController {

    private final CommandGateway commandGateway;

    @PostMapping("/")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {

        // Create appropriate command..
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .id(UUID.randomUUID().toString())
                .name(productDto.getName())
                .quantity(productDto.getQuantity())
                .price(productDto.getPrice())
                .build();

        String productId = commandGateway.sendAndWait(createProductCommand);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }
}
