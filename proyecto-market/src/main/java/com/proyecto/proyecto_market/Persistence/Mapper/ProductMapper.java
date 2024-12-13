package com.proyecto.proyecto_market.Persistence.Mapper;

import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idproducto", target = "productId", defaultValue = "0"),
            @Mapping(source = "nombre", target = "name", defaultValue = "null"),
            @Mapping(source = "idcategoria", target = "categoryId", defaultValue = "0"),
            @Mapping(source = "precioVenta", target = "price", defaultValue = "0.0"),
            @Mapping(source = "cantidadStock", target = "stock", defaultValue = "0"),
            @Mapping(source = "estado", target = "active", defaultValue = "false"),
            @Mapping(source = "categoria", target = "category") // Aquí se usa el CategoryMapper
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);


    @InheritInverseConfiguration
    @Mapping(target ="codigoBarras", ignore= true)
    Producto toProducto(Product product);
}





