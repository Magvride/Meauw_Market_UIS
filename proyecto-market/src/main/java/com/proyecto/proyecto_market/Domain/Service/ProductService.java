package com.proyecto.proyecto_market.Domain.Service;


import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Domain.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //servicio de nuestra logica de negocio
public class ProductService {
     @Autowired //internamente inicializará una clase de su implementacion, es decir, la clase de productReposittory
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

    public Product save(Product product){
         return productRepository.save(product);
    }

    public  void delete(int productId){
         productRepository.getProduct(productId);
         productRepository.delete(productId);
         productRepository.getProduct(productId);
    }
}
