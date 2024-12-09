package com.proyecto.proyecto_market.Domain.Repository;

import java.util.List;
import java.util.Optional;
import com.proyecto.proyecto_market.Domain.Product;

public interface ProductRepository {

    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScaseProducts(int quantity);

    //CRUD
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
