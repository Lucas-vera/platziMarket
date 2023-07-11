package com.platzi.cursoSpring.web.controller;

import com.platzi.cursoSpring.domain.Purchase;
import com.platzi.cursoSpring.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compras")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>( purchaseService.getAll(), HttpStatus.OK );
    }
    @GetMapping(value = "/{idCliente}/compras")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idCliente") String idClient){
        return purchaseService.getByClient(idClient)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping(value = "/save")
    public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase){
        return new ResponseEntity<>( purchaseService.save(purchase), HttpStatus.CREATED );
    }
}
