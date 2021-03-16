package cl.controller;

import cl.ejb.CarroLocal;
import cl.ejb.Item;
import cl.ejb.ServicioLocal;
import cl.model.Farmaco;
import java.io.IOException;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaFarmacoController", urlPatterns = {"/ListaFarmacoController"})
public class ListaFarmacoController extends HttpServlet {

    @EJB
    private ServicioLocal servicio;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("farmacos", servicio.farmacoList());
        request.getRequestDispatcher("WEB-INF/farmacos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) //Recibo el botón y la id del Fármaco desde farmacos.jsp
            throws ServletException, IOException {
        String bt = request.getParameter("bt");
        CarroLocal carro = getCarroService(request);

        if (bt.equals("clear")) {
            carro.clear();
            request.getSession().removeAttribute("carro"); //Borro el carro, conservando el vendedor.

        } else {
            int id = Integer.parseInt(bt);
            Farmaco farmaco = servicio.buscarFarmaco(id);

            Item item = new Item(farmaco, 1); //Farmaco buscado en la línea anterior y Cantidad
            carro.addItem(item);
        }
        request.setAttribute("farmacos", servicio.farmacoList());
        request.getRequestDispatcher("WEB-INF/farmacos.jsp").forward(request, response);
    }

    public CarroLocal getCarroService(HttpServletRequest request) { //Método se requiere para trabajar con Carro (Stateful)
        CarroLocal carro = null;
        if (request.getSession().getAttribute("carro") == null) { //Trabajamos con elementos de Sesion
            //@EJB
            try {
                InitialContext ctx = new InitialContext();
                carro = (CarroLocal) ctx.lookup("java:global/Farmacia/Carro!cl.ejb.CarroLocal"); //Acceder a un servicio específico manualmente, como la clase Carro.(Raíz/NombreProjecto/Servicio!NombreCompletoInterfaz)
                request.getSession().setAttribute("carro", carro); // Guardamos en Ámbito de Sesión, el objeto carro
            } catch (Exception e) {
                e.printStackTrace(); //Muestra la línea de error, por la Consola de Payara
            }

        } else {
            carro = (CarroLocal) request.getSession().getAttribute("carro");
        }
        return carro;
    }
}
