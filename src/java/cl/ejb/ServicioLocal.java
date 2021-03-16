package cl.ejb;

import cl.model.*;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ServicioLocal {
    // Contiene los métodos a implementar.
    // Posee la definición de los métodos, no tiene los métodos propios, sino que métodos abstractos.

    Farmaco buscarFarmaco(int id);
    Vendedor buscarVendedor(String rut);
    Vendedor iniciarSesion(String rut, String clave);
    void ingresarFarmaco(Farmaco nuevo);
    void eliminarFarmaco(int id);
    void actualizarFarmaco(int id, int precio, int stock);
    void ingresarHistorial(String rut, Historial nuevo);
    void ingresarVenta(Venta venta);
    List<Farmaco> farmacoList();
}