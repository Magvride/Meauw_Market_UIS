package com.proyecto.proyecto_market.Persistence.Mapper;
import com.proyecto.proyecto_market.Domain.Category;
import com.proyecto.proyecto_market.Persistence.Entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")

    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration//hace la operacion inversa
    @Mapping(target="productos",ignore = true)
    Categoria toCategoria(Category category);
}
