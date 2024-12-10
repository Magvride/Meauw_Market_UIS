package com.proyecto.proyecto_market.Web.Controller;

import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Domain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController //GARANTIZA A SPRING QUE ES UN CONTROALDOR DE LA API rest
@RequestMapping("/products") // que clase va a llamar
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<Product> getAll(){
        return productService.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productService.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productService.save(product);
    }

    public  void delete(int productId){
        productService.getProduct(productId);
        productService.delete(productId);
        productService.getProduct(productId);
    }

}
