package com.proyecto.proyecto_market.Persistence.Mapper;

import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Mappings({
            @Mapping( source="idproducto", target="productId")
            @Mapping(source="nombre", target="name")
            @Mapping(source="idcategoria", target="categoryId")
            @Mapping(source="precioVenta", target="price")
            @Mapping(source="cantidadStock", target="stock")
            @Mapping(source="estado", target="active")
            @Mapping(source="categoria", target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);


    Producto toProducto(Product product);
}
