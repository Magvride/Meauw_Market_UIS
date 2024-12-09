package com.proyecto.proyecto_market.Persistence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class CompraProductoPK implements Serializable {
    @Column(name="id_compra")
    private Integer idCompra;

    @Column(name="id_producto")
    private Integer idProducto;

    @ManyToOne
    @JoinColumn(name ="id_compra" , insertable = false, updatable = false)
    private Compra compra;
    @ManyToOne
    @JoinColumn(name ="id_producto" , insertable = false, updatable = false)
    private Producto producto;



    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
