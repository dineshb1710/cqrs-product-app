package com.dinesh.project.ms.dp.command.api.event.handler;

import com.dinesh.project.ms.dp.command.api.event.UpdateProductEvent;
import com.dinesh.project.ms.dp.common.entities.Product;
import com.dinesh.project.ms.dp.common.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateProductEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void handleUpdateProductEvent(UpdateProductEvent updateProductEvent) {
        // Build appropriate entity from event..
        Product product = new Product();
        BeanUtils.copyProperties(updateProductEvent, product);

        // Perform database operation..
        productRepository.save(product);
    }
}
