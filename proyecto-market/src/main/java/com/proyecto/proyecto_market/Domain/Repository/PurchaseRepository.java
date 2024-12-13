package com.proyecto.proyecto_market.Domain.Repository;

import com.proyecto.proyecto_market.Domain.Purchase;

import java.util.List;

public interface PurchaseRepository{

    List<Purchase> getAll();
    List<Purchase> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
