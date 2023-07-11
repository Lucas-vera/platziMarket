package com.platzi.cursoSpring.domain.repository;

import com.platzi.cursoSpring.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String idClient);
    Purchase save(Purchase purchase);
}
