package com.proyecto.proyecto_market.Persistence;

import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Domain.Repository.ProductRepository;
import com.proyecto.proyecto_market.Persistence.Crud.ProductoCrudRepository;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;
import com.proyecto.proyecto_market.Persistence.Mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository //indicando a spring que esta clase se encarga de interactuar con la BD
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;



    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId)
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScaseProducts(int quantity) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

//----------------------------------------------------------------------------------------------


    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
        return productoCrudRepository.findByIdCantidadStockLessThanAndEstado(cantidad,  true);
    }

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


    private ProductMapper mapper;

    public List<Product> getAll(){
         ArrayList<Producto> p =(ArrayList<Producto>) productoCrudRepository.findAll();
         return  mapper.toProducts(p);
    }




}
