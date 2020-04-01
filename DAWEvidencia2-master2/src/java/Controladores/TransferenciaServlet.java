/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.CuentaCliente;
import Modelos.Transferencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brandon
 */
public class TransferenciaServlet extends HttpServlet {
    private List<Transferencia> transferencias = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        List<Transferencia> transferenciasActuales = (List<Transferencia>) getServletContext()
                .getAttribute("transferencias");

        if (transferenciasActuales != null) {
            this.transferencias = transferenciasActuales;
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

        PrintWriter out = response.getWriter();

        String numCuentaOrigen = request.getParameter("numCuentaOrigen");
        String numCuentaDestino = request.getParameter("numCuentaDestino");
        double cantidad = Double.valueOf(request.getParameter("cantidad"));

        if (numCuentaOrigen.equals(numCuentaDestino)) {
            out.println("<center>");
            out.print("<p>No puedes transferir a la misma cuenta</p>");
            out.println("</center>");
            request.getRequestDispatcher("transferencia.jsp").include(request, response);
            return;
        }

        List<CuentaCliente> cuentas = (List<CuentaCliente>) getServletContext().getAttribute("listacuentas");

        if (cuentas == null) {
            out.println("<center>");
            out.print("<p>No se encontro alguna de las cuentas ingresadas</p>");
            out.println("</center>");
            request.getRequestDispatcher("transferencia.jsp").include(request, response);
            return;
        }

        OptionalInt indexCuentaOrigen = IntStream.range(0, cuentas.size())
                .filter(i -> cuentas.get(i).getNumCuenta().equals(numCuentaOrigen)).findAny();

        OptionalInt indexCuentaDestino = IntStream.range(0, cuentas.size())
                .filter(i -> cuentas.get(i).getNumCuenta().equals(numCuentaDestino)).findAny();

        if (indexCuentaOrigen.isPresent() && indexCuentaDestino.isPresent()) {
            CuentaCliente cuentaOrigen = cuentas.get(indexCuentaOrigen.getAsInt());
            CuentaCliente cuentaDestino = cuentas.get(indexCuentaDestino.getAsInt());

            if (cuentaOrigen.getMonto() < cantidad) {
                out.println("<center>");
                out.print("<p>No cuentas con fondos suficientes</p>");
                out.println("</center>");

                request.getRequestDispatcher("transferencia.jsp").include(request, response);
                return;
            }

            cuentaOrigen.addToMonto(cantidad * -1.0);
            cuentaDestino.addToMonto(cantidad);

            Transferencia transferencia = new Transferencia(numCuentaOrigen, numCuentaDestino, cantidad,
                    LocalDate.now());
            transferencias.add(transferencia);

            getServletContext().setAttribute("transferencias", transferencias);

            request.getRequestDispatcher("").include(request, response);
        } else {
            out.println("<center>");
            out.print("<p>No se encontro alguna de las cuentas ingresadas</p>");
            out.println("</center>");

            request.getRequestDispatcher("transferencia.jsp").include(request, response);
            return;
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
