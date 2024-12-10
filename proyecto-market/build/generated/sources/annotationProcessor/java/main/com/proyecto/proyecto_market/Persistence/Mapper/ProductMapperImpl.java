package com.proyecto.proyecto_market.Persistence.Mapper;

import com.proyecto.proyecto_market.Domain.Category;
import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Persistence.Entity.Categoria;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T16:30:03+0100",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.5 (Eclipse Adoptium)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Product product = new Product();

        if ( producto.getIdproducto() != null ) {
            product.setProductId( producto.getIdproducto() );
        }
        product.setName( producto.getNombre() );
        if ( producto.getIdcategoria() != null ) {
            product.setCategoryId( producto.getIdcategoria() );
        }
        if ( producto.getPrecioVenta() != null ) {
            product.setPrice( producto.getPrecioVenta() );
        }
        if ( producto.getCantidadStock() != null ) {
            product.setStock( producto.getCantidadStock() );
        }
        if ( producto.getEstado() != null ) {
            product.setActive( producto.getEstado() );
        }
        product.setCategory( categoriaToCategory( producto.getCategoria() ) );

        return product;
    }

    @Override
    public List<Product> toProducts(List<Producto> productos) {
        if ( productos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productos.size() );
        for ( Producto producto : productos ) {
            list.add( toProduct( producto ) );
        }

        return list;
    }

    @Override
    public Producto toProducto(Product product) {
        if ( product == null ) {
            return null;
        }

        Producto producto = new Producto();

        return producto;
    }

    protected Category categoriaToCategory(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Category category = new Category();

        return category;
    }
}
