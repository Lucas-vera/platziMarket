package com.platzi.cursoSpring.domain.repository;

import com.platzi.cursoSpring.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);

    Optional<Product> getProduct(int productId);
    Product saveProduct(Product product);
    void deleteProduct(int productId);
}
