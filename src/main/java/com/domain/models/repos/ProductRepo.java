package com.domain.models.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.domain.models.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {

    // Search by name
    List<Product> findByNameContains(String name);

}
