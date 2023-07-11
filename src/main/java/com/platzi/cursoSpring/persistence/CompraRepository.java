package com.platzi.cursoSpring.persistence;

import com.platzi.cursoSpring.domain.Purchase;
import com.platzi.cursoSpring.domain.repository.PurchaseRepository;
import com.platzi.cursoSpring.persistence.crud.CompraCrudRepository;
import com.platzi.cursoSpring.persistence.entity.Compra;
import com.platzi.cursoSpring.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraRepository;
    @Autowired
    private PurchaseMapper mapper;
    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>)compraRepository.findAll());
    }
    @Override
    public Optional<List<Purchase>> getByClient(String idClient) {
        return Optional.of(mapper.toPurchases(compraRepository.findByIdCliente(idClient)));
    }

    @Override
    public Purchase save(Purchase purchase) {
        return mapper.toPurchase(compraRepository.save(mapper.toCompra(purchase)));
    }
}
