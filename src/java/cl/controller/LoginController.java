package cl.controller;

import cl.model.Vendedor;
import cl.ejb.ServicioLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    @EJB
    private ServicioLocal servicio;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getSession().getAttribute("vendedor")!=null) { //Si existe la Sesión
             request.getRequestDispatcher("WEB-INF/menu.jsp").forward(request, response); //Redirecciona a menu.jsp, pudiendo acceder porque existe Sesión.
        } else { //Si no existe la Sesión.
            response.sendRedirect("login.jsp"); //Redirecciona a login.jsp
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("x1");
        String clave = request.getParameter("x2");
        
        Vendedor v = servicio.iniciarSesion(rut, clave);
        if(v!=null){
            //Crear la Sesión
            request.getSession().setAttribute("vendedor", v); //Guarda en el Ámbito de Sesión el objeto vendedor, con nombre "vendedor". Todos pueden acceder al ámbito.
            request.getSession().setMaxInactiveInterval(180); //Define el tiempo de inactividad en la sesión a 3 minutos.
            request.getRequestDispatcher("WEB-INF/menu.jsp").forward(request, response); //Envía el mensaje al menu.jsp; Esta es la forma de acceder a WEB-INF, que es privada
        } else {
            request.setAttribute("error", "Usuario no existe");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}