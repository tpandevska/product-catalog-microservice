package com.ecommerce.productcatalogmicroservice.service.impl;

import com.ecommerce.productcatalogmicroservice.models.Product;
import com.ecommerce.productcatalogmicroservice.models.exceptions.ProductNotFoundException;
import com.ecommerce.productcatalogmicroservice.repository.ProductRepository;
import com.ecommerce.productcatalogmicroservice.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.productRepository.findProductByProductName(name);
    }

    @Override
    @Transactional
    public Optional<Product> save(Product product) {
        return Optional.of(this.productRepository.save(product));
    }
    @Override
    @Transactional
    public Optional<Product> edit(Long id, Product product) {
        Product p =  this.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        p.setProductName(product.getProductName());
        p.setCategory(product.getCategory());
        p.setPrice(product.getPrice());
        p.setBrand(product.getBrand());
        p.setProductImage(product.getProductImage());
        return Optional.of(this.productRepository.save(p));
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
