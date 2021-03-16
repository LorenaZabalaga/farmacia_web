package cl.ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface CarroLocal {
    void addItem(Item item); //Agregar a la Lista
    void clear(); //Limpiar la Lista
    List<Item> carroList(); //Mostrar la 
}