package com.proyecto.proyecto_market.Domain.Service;


import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Domain.Repository.ProductRepository;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;
import com.proyecto.proyecto_market.Persistence.Mapper.ProductMapper;
import com.proyecto.proyecto_market.Persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //servicio de nuestra logica de negocio
public class ProductService {
     @Autowired //internamente inicializará una clase de su implementacion, es decir, la clase de productReposittory
     private ProductRepository productRepository;
     @Autowired
     private ProductoRepository productoRepository;
     @Autowired
     private ProductMapper mapper;


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

         try {

             Producto p = mapper.toProducto(product);
             System.out.println(p.getCantidadStock());
             System.out.println(p.getIdproducto());
             productoRepository.save(p); //el problema es este save
             System.out.println("Se guardó exitosamente");

         }catch(Exception e) {
            System.out.println("No se logró guardar"+ e);

        }
        return(product);

    }

    public boolean delete(int productId){
         productRepository.getProduct(productId);
         productRepository.delete(productId);
         productRepository.getProduct(productId);
        return false;
    }
}
