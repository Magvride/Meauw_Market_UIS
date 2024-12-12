package com.proyecto.proyecto_market.Web.Controller;

import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Domain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //GARANTIZA A SPRING QUE ES UN CONTROALDOR DE LA API rest
@RequestMapping("/products") // que clase va a llamar
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable("id") int productId){
        productService.getProduct(productId);
        productService.delete(productId);
        productService.getProduct(productId);
    }

}
