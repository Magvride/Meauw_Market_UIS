package com.proyecto.proyecto_market.Persistence;

import com.proyecto.proyecto_market.Persistence.Crud.ProductoCrudRepository;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;
import jakarta.persistence.Column;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository //indicando a spring que esta clase se encarga de interactuar con la BD
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public Iterable<Producto> getAll(){
        return (ArrayList<Producto>) productoCrudRepository.findAll();
    }


    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);

    }

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

}
