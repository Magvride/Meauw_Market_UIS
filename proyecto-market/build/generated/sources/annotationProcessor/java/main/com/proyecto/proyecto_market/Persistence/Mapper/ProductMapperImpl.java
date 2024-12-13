package com.proyecto.proyecto_market.Persistence.Mapper;

import com.proyecto.proyecto_market.Domain.Product;
import com.proyecto.proyecto_market.Persistence.Entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-13T11:39:33+0100",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Product toProduct(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Product product = new Product();

        if ( producto.getIdproducto() != null ) {
            product.setProductId( producto.getIdproducto() );
        }
        else {
            product.setProductId( 0 );
        }
        if ( producto.getNombre() != null ) {
            product.setName( producto.getNombre() );
        }
        else {
            product.setName( "null" );
        }
        if ( producto.getIdcategoria() != null ) {
            product.setCategoryId( producto.getIdcategoria() );
        }
        else {
            product.setCategoryId( 0 );
        }
        if ( producto.getPrecioVenta() != null ) {
            product.setPrice( producto.getPrecioVenta() );
        }
        else {
            product.setPrice( 0.0 );
        }
        if ( producto.getCantidadStock() != null ) {
            product.setStock( producto.getCantidadStock() );
        }
        else {
            product.setStock( 0 );
        }
        if ( producto.getEstado() != null ) {
            product.setActive( producto.getEstado() );
        }
        else {
            product.setActive( false );
        }
        product.setCategory( categoryMapper.toCategory( producto.getCategoria() ) );

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

        producto.setIdproducto( product.getProductId() );
        producto.setNombre( product.getName() );
        producto.setIdcategoria( product.getCategoryId() );
        producto.setPrecioVenta( product.getPrice() );
        producto.setCantidadStock( product.getStock() );
        producto.setEstado( product.isActive() );
        producto.setCategoria( categoryMapper.toCategoria( product.getCategory() ) );

        return producto;
    }
}
