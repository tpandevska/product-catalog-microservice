package com.ecommerce.productcatalogmicroservice.service;

import com.ecommerce.productcatalogmicroservice.models.Product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    Optional<Product> save(Product product);
    Optional<Product> edit(Long id, Product product);
    void deleteById(Long id);
}
