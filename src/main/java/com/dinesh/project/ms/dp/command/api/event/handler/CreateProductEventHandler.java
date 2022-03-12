package com.dinesh.project.ms.dp.command.api.event.handler;

import com.dinesh.project.ms.dp.command.api.event.CreateProductEvent;
import com.dinesh.project.ms.dp.common.entities.Product;
import com.dinesh.project.ms.dp.common.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void handleCreateProductEvent(CreateProductEvent createProductEvent) {

        // Build appropriate entity object from this event..
        Product product = new Product();
        BeanUtils.copyProperties(createProductEvent, product);

        // Persist..
        productRepository.save(product);
    }
}
