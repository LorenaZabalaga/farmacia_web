package cl.ejb;

import cl.model.Farmaco;

public class Item { //Éste Item lo ocupará el carro
    private Farmaco farmaco;
    private int cantidad;

    public Item() {
    }

    public Item(Farmaco farmaco, int cantidad) {
        this.farmaco = farmaco;
        this.cantidad = cantidad;
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
}