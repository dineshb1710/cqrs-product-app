package com.dinesh.project.ms.dp.command.api.controller;

import com.dinesh.project.ms.dp.command.api.cmds.CreateProductCommand;
import com.dinesh.project.ms.dp.command.api.cmds.DeleteProductByIdCommand;
import com.dinesh.project.ms.dp.command.api.cmds.UpdateProductCommand;
import com.dinesh.project.ms.dp.command.api.dto.ProductDto;
import com.dinesh.project.ms.dp.command.api.dto.ProductDtoWithId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDtoWithId productDtoWithId) {

        // Create appropriate command..
        UpdateProductCommand updateProductCommand = UpdateProductCommand.builder()
                .id(productDtoWithId.getId())
                .name(productDtoWithId.getName())
                .quantity(productDtoWithId.getQuantity())
                .price(productDtoWithId.getPrice())
                .build();

        String productId = commandGateway.sendAndWait(updateProductCommand);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id) {

        // Create appropriate command..
        DeleteProductByIdCommand deleteProductByIdCommand = DeleteProductByIdCommand.builder()
                .id(id)
                .build();

        String productId = commandGateway.sendAndWait(deleteProductByIdCommand);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }
}
