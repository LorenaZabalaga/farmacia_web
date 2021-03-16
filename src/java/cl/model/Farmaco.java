package cl.model;

public class Farmaco {
    int id;
    String nombre;
    String tipo;
    String accion;
    String descripcion;
    String laboratorio;
    int precio;
    int stock;

    public Farmaco() {
    }

    public Farmaco(int id, String nombre, String tipo, String accion, String descripcion, String laboratorio, int precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.accion = accion;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}