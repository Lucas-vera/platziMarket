package com.platzi.cursoSpring.persistence;

import com.platzi.cursoSpring.persistence.crud.ProductoCrudRepository;
import com.platzi.cursoSpring.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    ProductoCrudRepository productoRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoRepository.findAll();
    }
    public List<Producto> getByCategoria(int idCategoria){
        return (List<Producto>) productoRepository.findByIdCategoria(idCategoria);
    }
}
