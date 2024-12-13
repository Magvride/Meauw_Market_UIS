package com.proyecto.proyecto_market.Web.Controller;

import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Domain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //GARANTIZA A SPRING QUE ES UN CONTROALDOR DE LA API rest
@RequestMapping("/products") // que clase va a llamar
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    //cuerpo de la petición : lista de productos
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId).map(product->new ResponseEntity<>(product,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId).map(products ->new ResponseEntity<>(products, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {

        try {
            System.out.println("Datos recibidos en JSON: " + product);
            Product savedProduct = productService.save(product);
            System.out.println("Producto guardado correctamente: " + savedProduct);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al guardar el producto: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>("Error al guardar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/{id}")
    public  ResponseEntity delete(@PathVariable("id") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        } else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
