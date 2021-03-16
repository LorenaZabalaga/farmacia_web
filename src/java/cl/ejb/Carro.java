package cl.ejb;

import cl.model.Farmaco;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class Carro implements CarroLocal {

    private final List<Item> items;

    public Carro() {
        this.items = new ArrayList();
    }

    private Item find (Farmaco farmaco){ //Busca un item en el carrito. Función privada de la clase, no declarada por lo tanto en la Interfaz CarroLocal.
        for (Item item : items) {
            if (item.getFarmaco() == farmaco){
                return item;
            }
        }
        return null;
    }

    @Override
    public void addItem(Item item) { //Agregar a la Lista (Ver si el Fármaco está o no en la Lista)
        Item i = find(item.getFarmaco()); //Llama a find() para buscar si ya está el fármaco en el carrito.
        if (i != null) { //Si el Fármaco ya está en el carrito
            if(i.getFarmaco().getStock() > i.getCantidad()){ //Controlar Stock de los 
                i.setCantidad(i.getCantidad()+1); //Actualiza la cantidad en el carro a +1;
            }      
        } else { //Si no está en el carrito
            items.add(item); //Agrega el item al carrito
        }

    }

    @Override
    @Remove //Permite liberar recursos, al ser llamado.
    public void clear() { //Limpiar la Lista
        items.clear();
    }

    @Override
    public List<Item> carroList() { //Mostrar la Lista
        return items;
    }
}
