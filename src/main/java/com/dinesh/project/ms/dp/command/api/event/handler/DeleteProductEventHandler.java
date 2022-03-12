package com.dinesh.project.ms.dp.command.api.event.handler;

import com.dinesh.project.ms.dp.command.api.event.DeleteProductEvent;
import com.dinesh.project.ms.dp.common.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteProductEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void handleDeleteProductEvent(DeleteProductEvent deleteProductEvent) {
        // Delete product from the repository..
        productRepository.deleteById(deleteProductEvent.getId());
    }

}
