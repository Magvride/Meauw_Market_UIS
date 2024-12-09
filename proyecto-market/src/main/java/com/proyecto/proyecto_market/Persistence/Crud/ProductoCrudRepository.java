package com.proyecto.proyecto_market.Persistence.Crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer>{

    //@Query(value= " SELECT * FROM productos WHERE id_categoria = ?", nativeQuery=true)
    ArrayList<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByIdCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}

