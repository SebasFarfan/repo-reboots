package ar.edu.unju.fi.tp4.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Compra {
    private int id;
    @Autowired
    private Producto producto;
    private int cantidad;
    private double total;


    public Compra() {
    }

    public Compra(int id, Producto producto, int cantidad, double total) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", producto='" + getProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", total='" + getTotal() + "'" +
            "}";
    }

}
