package com.platzi.cursoSpring.persistence.crud;

import com.platzi.cursoSpring.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true) se puede hacer de esta manera y nombrar
    //nuestro metodo con otro nombra y no aplicando query methods
    List<Producto> findByIdCategoria(int idCategoria);
    
}
