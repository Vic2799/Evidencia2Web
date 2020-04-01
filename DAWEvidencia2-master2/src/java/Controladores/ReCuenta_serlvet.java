package Controladores;

import Modelos.CuentaCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huert
 */
public class ReCuenta_serlvet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    List listacuentas = new ArrayList();
    List cuentas = new ArrayList();
    @Override
    public void init() throws ServletException {
        List<CuentaCliente> cuentasActuales = (List<CuentaCliente>) getServletContext().getAttribute("listacuentas");

        if (cuentasActuales != null) {
            this.cuentas = cuentasActuales;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
        String NumCuenta = request.getParameter("numeroCuenta");
        String NumCliente = request.getParameter("numeroCliente");
               
        ServletContext sc = getServletContext();
        List <CuentaCliente> cuentas = (ArrayList<CuentaCliente>) sc.getAttribute("listacuentas");
        CuentaCliente d1 = new CuentaCliente();
            boolean seEncontroCuenta = false;
        for(CuentaCliente d : cuentas){
            if(d.getNumCliente().equals(NumCliente) && d.getNumCuenta().equals(NumCuenta)){
                d1.setNumCuenta(d.getNumCuenta());
                d1.setNumCliente(d.getNumCliente());
                d1.setTipoCuenta(d.getTipoCuenta());
                d1.setMonto(d.getMonto());
                cuentas.remove(d);
                listacuentas.add(d1);
                request.setAttribute("cuentasguardadas",listacuentas);
                request.getRequestDispatcher("RegistroCuenta.jsp").forward(request, response);
               seEncontroCuenta = true;
               break;
            }
         } if(!seEncontroCuenta){
                out.println("<center>");
                out.print("<p>Error en los campos, verifique su informacion</p>");
                out.println("</center>");
                request.getRequestDispatcher("DetallesCuenta.jsp").include(request, response);
                
            }
        
       

     
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
    
        String NumCuenta = request.getParameter("NumCuenta");
        String NumCliente = request.getParameter("NumCliente");
        CuentaCliente.Tipo TipoCuenta = (request.getParameter("tipoCuenta").equalsIgnoreCase("debito")
                ? CuentaCliente.Tipo.DEBITO
                : CuentaCliente.Tipo.RETIRO);
        double Monto = Double.valueOf(request.getParameter("monto"));

        CuentaCliente d1 = new CuentaCliente();
        
        
                d1.setNumCuenta(NumCuenta);
                d1.setNumCliente(NumCliente);
                d1.setTipoCuenta(TipoCuenta);
                d1.setMonto(Monto);

                cuentas.add(d1);
                getServletContext().setAttribute("listacuentas", cuentas);
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
