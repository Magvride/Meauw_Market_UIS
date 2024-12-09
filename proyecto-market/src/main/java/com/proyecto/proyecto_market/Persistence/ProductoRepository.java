package com.proyecto.proyecto_market.Persistence;

import com.proyecto.proyecto_market.Persistence.Crud.ProductoCrudRepository;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


}
