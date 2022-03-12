package com.dinesh.project.ms.dp.query.api.controller;

import com.dinesh.project.ms.dp.common.entities.Product;
import com.dinesh.project.ms.dp.query.api.queries.GetAllProductsQuery;
import com.dinesh.project.ms.dp.query.api.queries.GetProductByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductQueryController {

    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {

        // Create appropriate query for this request..
        GetAllProductsQuery getAllProductsQuery = new GetAllProductsQuery();

        // Send this command to 'QueryGateway'..
        return queryGateway.query(getAllProductsQuery, ResponseTypes.multipleInstancesOf(Product.class)).join();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {

        // Create appropriate query for this request..
        GetProductByIdQuery getProductByIdQuery = new GetProductByIdQuery(id);

        // Send this command to 'QueryGateway'..
        return queryGateway.query(getProductByIdQuery, ResponseTypes.instanceOf(Product.class)).join();
    }
}
