package com.dinesh.project.ms.dp.common.repo;

import com.dinesh.project.ms.dp.common.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // Custom methods goes here ..
}
