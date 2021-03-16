package cl.ejb;

import cl.model.Farmaco;
import cl.model.Historial;
import cl.model.Vendedor;
import cl.model.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class Servicio implements ServicioLocal {

    private final List<Farmaco> farmacos;
    private final List<Venta> ventas;
    private final List<Vendedor> vendedores;

    public Servicio() {
        farmacos = new ArrayList();
        ventas = new ArrayList();
        vendedores = new ArrayList();
        farmacos.add(new Farmaco(1, "Paracetamol 50mg", "Generico", "Gripe", "Medicamento para la gripe", "Chile", 1200, 20));
        farmacos.add(new Farmaco(2, "Nastizol 200mg", "Generico", "Gripe", "Medicamento para la gripe", "Chile", 1500, 10));
        farmacos.add(new Farmaco(3, "Amoxicilina 500mg", "Antibiotico", "Antibiotico", "Medicamento para la Infecciones", "Andromaco", 1800, 20));
        farmacos.add(new Farmaco(4, "PaltoMiel 200ML", "Jarabe", "Bronquitis", "Medicamento antitusivo", "Knob", 5200, 20));
        vendedores.add(new Vendedor("1-1", "Tomas", "Diaz", "123456"));
        vendedores.add(new Vendedor("1-2", "Francisca", "Rojas", "123456"));
        vendedores.add(new Vendedor("1-3", "Pablo", "Reyes", "123456"));
    }

    @Override
    public Farmaco buscarFarmaco(int id) {
       for (Farmaco f : farmacos) {
            if (f.getId() == id){
                return f;
            }
        }
        return null;
    }

    @Override
    public Vendedor buscarVendedor(String rut) {
        for (Vendedor v : vendedores) {
            if (v.getRut().equals(rut)){
                return v;
            }
        }
        return null;
    }

    @Override
    public Vendedor iniciarSesion(String rut, String clave) {
        for (Vendedor v : vendedores) {
            if (v.getRut().equals(rut) && v.getClave().equals(clave)){
                return v; 
            }
        }
        return null;
    }

    @Override
    public void ingresarFarmaco(Farmaco nuevo) {
        int id;
        if (farmacos.isEmpty()){
            id = 1;
        } else {
            id = farmacos.get(farmacos.size()-1).getId()+1; //Sacamos el último ID (posición array) y para el nuevo objeto le agregamos +1; 
        }
        nuevo.setId(id);
        farmacos.add(nuevo);
    }

    @Override
    public void eliminarFarmaco(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarFarmaco(int id, int precio, int stock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarHistorial(String rut, Historial nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarVenta(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Farmaco> farmacoList() {
        return farmacos;
    }
}