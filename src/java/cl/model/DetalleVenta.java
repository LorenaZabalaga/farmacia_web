package cl.model;

public class DetalleVenta {
    Farmaco farmaco;
    int cantidad;
    int precio;

    public DetalleVenta() {
    }

    public DetalleVenta(Farmaco farmaco, int cantidad, int precio) {
        this.farmaco = farmaco;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Farmaco getFarmaco() {
        return farmaco;
    }

    public void setFarmaco(Farmaco farmaco) {
        this.farmaco = farmaco;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}