package com.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.handler.ResponseHandler;
import com.domain.models.entities.Product;
import com.domain.models.repos.ProductRepo;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public ResponseEntity<Object> findOne(Long id) {

        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return ResponseHandler.generateResponse("success", HttpStatus.OK, null, 2);
        }
        return ResponseHandler.generateResponse("success", HttpStatus.OK, product.get(), 2);
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return productRepo.findByNameContains(name);
    }

}
