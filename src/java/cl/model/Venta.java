package cl.model;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    int total;
    String fecha;
    String cliente;
    Vendedor vendedor;
    List<DetalleVenta> detalle;

    public Venta() {
    }

    public Venta(int total, String fecha, String cliente, Vendedor vendedor) {
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.detalle = new ArrayList();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<DetalleVenta> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleVenta> detalle) {
        this.detalle = detalle;
    }
}