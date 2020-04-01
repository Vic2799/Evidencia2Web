package Controladores;

import Modelos.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DAVID
 */
public class iniciarSesion_Servlet extends HttpServlet {

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

        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("user");
        String contrasena = request.getParameter("pass");

        HttpSession session = request.getSession();
        ServletContext sc = getServletContext();
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) sc.getAttribute("listaclientes");

        boolean seEncontroCliente = false;
        try {
            for (Cliente c : clientes) {
                if (c.getNombreUsuario().equals(usuario) && c.getContrasena().equals(contrasena)) {
                    session.setAttribute("usuario", c);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    seEncontroCliente = true;
                    break;
                }
            }
            if (!seEncontroCliente) {
                out.println("<center>");
                out.print("<p>Error en los campos, verifique su informacion</p>");
                out.println("</center>");
                request.getRequestDispatcher("InicioSesion.jsp").include(request, response);
            }
            out.close();
        } catch (NullPointerException e) {
            log("Error en inicio de sesion", e);
            request.getRequestDispatcher("InicioSesion.jsp").forward(request, response);

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
