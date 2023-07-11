package com.platzi.cursoSpring.domain.service;

import com.platzi.cursoSpring.domain.Product;
import com.platzi.cursoSpring.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    public  Product saveProduct(Product product){
        return productRepository.saveProduct(product);
    }
    public boolean deleteProduct(int productId){
        try{
            productRepository.deleteProduct(productId);
            return true;
        }
        catch(EmptyResultDataAccessException e){
            return false;
        }
    }
}
