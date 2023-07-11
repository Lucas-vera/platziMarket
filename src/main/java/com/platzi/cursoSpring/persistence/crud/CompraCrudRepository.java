package com.platzi.cursoSpring.persistence.crud;

import com.platzi.cursoSpring.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer>{
    List<Compra> findByIdCliente(String idCliente);
}
