package com.proyecto.proyecto_market.Persistence;

import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Domain.Repository.ProductRepository;
import com.proyecto.proyecto_market.Persistence.Crud.ProductoCrudRepository;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;
import com.proyecto.proyecto_market.Persistence.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository //indicando a spring que esta clase se encarga de interactuar con la BD
public class ProductoRepository implements ProductRepository {
    @Autowired //los objetos que reciban esta anotación, Spring tendrá el control de inicializar los objetos.
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;


    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScaseProducts(int quantity) {
        Optional<List<Producto>> productos =  productoCrudRepository.findByIdCantidadStockLessThanAndEstado(quantity,  true);
        return productos.map(prods-> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        productoCrudRepository.findById(productId).map(producto-> mapper.toProduct(producto));
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        Producto p= mapper.toProducto(product);
        return mapper.toProduct((productoCrudRepository.save(p)));
    }

//----------------------------------------------------------------------------------------------


    //Obtener producto dado su ID
    public Optional<Producto> getProducto(int idProducto) {

        return productoCrudRepository.findById(idProducto);
    }


    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);

    }

    public void delete(int idProducto){

        productoCrudRepository.deleteById(idProducto);
    }




    public List<Product> getAll(){
         ArrayList<Producto> p =(ArrayList<Producto>) productoCrudRepository.findAll();
         return  mapper.toProducts(p);
    }




}
