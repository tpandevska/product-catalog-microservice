package com.ecommerce.productcatalogmicroservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String productName;
    private Double price;
    private String brand;
    private String category;
    private String productImage;

    //Attributes: Additional attributes specific to the product, such as size, color, weight, etc.
    //Variants: If the product has variations (e.g., different sizes or colors), you can store details about each variant.
    //Ratings and Reviews: Fields to store ratings and customer reviews for the product.
    //Created/Updated Date: Timestamps indicating when the product was created or last updated.
    // SKU (Stock Keeping Unit): A unique code used for inventory management and tracking.
}
