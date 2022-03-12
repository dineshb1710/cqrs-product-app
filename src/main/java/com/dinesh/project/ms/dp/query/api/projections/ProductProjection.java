package com.dinesh.project.ms.dp.query.api.projections;

import com.dinesh.project.ms.dp.common.entities.Product;
import com.dinesh.project.ms.dp.common.repo.ProductRepository;
import com.dinesh.project.ms.dp.query.api.queries.GetAllProductsQuery;
import com.dinesh.project.ms.dp.query.api.queries.GetProductByIdQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductProjection {

    private final ProductRepository productRepository;

    @QueryHandler
    public List<Product> handleGetAllProductsQuery(GetAllProductsQuery getAllProductsQuery) {
        return productRepository.findAll();
    }

    @QueryHandler
    public Product handleGetProductByIdQuery(GetProductByIdQuery getProductByIdQuery) {
        return productRepository.findById(getProductByIdQuery.getId()).get();
    }
}
