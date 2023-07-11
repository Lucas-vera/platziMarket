package com.platzi.cursoSpring.persistence;

import com.platzi.cursoSpring.domain.Product;
import com.platzi.cursoSpring.domain.repository.ProductRepository;
import com.platzi.cursoSpring.persistence.crud.ProductoCrudRepository;
import com.platzi.cursoSpring.persistence.entity.Producto;
import com.platzi.cursoSpring.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    ProductoCrudRepository productoRepository;
    @Autowired
    ProductMapper mapper;
    @Override
    public List<Product> getAll(){
        return mapper.toProducts((List<Producto>) productoRepository.findAll() );
    }
    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        return Optional.of(mapper.toProducts(productoRepository.findByIdCategoria(categoryId) ));
    }
    @Override
    public Optional<Product> getProduct(int productId){
       // return Optional.of( mapper.toProduct( productoRepository.findById(productId).get())); //NO DEJA PASAR EL NULL
        return productoRepository.findById(productId).map(producto -> mapper.toProduct(producto));

    }
    @Override
    public Product saveProduct(Product product){
        return mapper.toProduct( productoRepository.save(mapper.toProducto(product)) );
    }
    @Override
    public void deleteProduct(int productId){
        productoRepository.deleteById(productId);
    }
}
