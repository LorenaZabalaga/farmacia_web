package cl.model;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String rut;
    private String nombre;
    private String apellido;
    private String clave;
    private List<Historial> historial;

    public Vendedor() {
    }

    public Vendedor(String rut, String nombre, String apellido, String clave) { //Al realizar el constructor así, el Vendedor iniciará siempre con un Historial nuevo.
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.historial = new ArrayList();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
    }
}