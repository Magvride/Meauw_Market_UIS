package com.proyecto.proyecto_market.Persistence.Mapper;

import com.proyecto.proyecto_market.Domain.Category;
import com.proyecto.proyecto_market.Persistence.Entity.Categoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T16:30:03+0100",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoria.getIdCategoria() );
        category.setCategory( categoria.getDescripcion() );
        category.setActive( categoria.isEstado() );

        return category;
    }

    @Override
    public Categoria toCategoria(Category category) {
        if ( category == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( category.getCategoryId() );
        categoria.setDescripcion( category.getCategory() );
        categoria.setEstado( category.isActive() );

        return categoria;
    }
}
