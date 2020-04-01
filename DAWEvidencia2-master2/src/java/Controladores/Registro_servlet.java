package Controladores;

import Modelos.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DAVID
 */
public class Registro_servlet extends HttpServlet implements ServletContextListener {

    List<Cliente> clientes = new ArrayList();
    
    @Override
    public void init() throws ServletException {
        List<Cliente> clientesActuales =
                (List<Cliente>)getServletContext().getAttribute("listaclientes");
        
        if(clientesActuales != null) {
            clientes = clientesActuales;
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String cp = request.getParameter("cp");
        String ciudad = request.getParameter("ciudad");
        String estado = request.getParameter("estado");
        String pais = request.getParameter("pais");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String fechanacimiento = request.getParameter("fechanac");
        String nombreusuario = request.getParameter("usuario");
        String numerocliente = request.getParameter("numcliente");
        String contrasena = request.getParameter("contrasena");
        String tipoCliente = request.getParameter("tipoCliente");

        Cliente c1 = new Cliente();
        c1.setNombre(nombre);
        c1.setApellido(apellido);
        c1.setDireccion(direccion);
        c1.setCp(cp);
        c1.setCiudad(ciudad);
        c1.setEstado(estado);
        c1.setPais(pais);
        c1.setTelefono(telefono);
        c1.setCorreo(correo);
        c1.setFecha_nacimiento(fechanacimiento);
        c1.setNombreUsuario(nombreusuario);
        c1.setNumeroCliente(numerocliente);
        c1.setContrasena(contrasena);
        c1.setAdministrador((tipoCliente.equals("administrador")));

        clientes.add(c1);

        getServletContext().setAttribute("listaclientes", clientes);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        Cliente admin = new Cliente();
        admin.setNumeroCliente("1");
        admin.setNombreUsuario("admin");
        admin.setContrasena("123456");
        admin.setNombre("admin");
        admin.setAdministrador(true);
        clientes.add(admin);
        event.getServletContext().setAttribute("listaclientes", clientes);
    }

}
