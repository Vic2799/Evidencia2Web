package Modelos;

/**
 *
 * @author huert
 */
public class CuentaCliente {

    public String NumCuenta;
    public String NumCliente;
    public Tipo TipoCuenta;
    public double Monto;

    public CuentaCliente() {

    }

    public String getNumCuenta() {
        return NumCuenta;
    }

    public void setNumCuenta(String NumCuenta) {
        this.NumCuenta = NumCuenta;
    }

    public String getNumCliente() {
        return NumCliente;
    }

    public void setNumCliente(String NumCliente) {
        this.NumCliente = NumCliente;
    }

    public Tipo getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(Tipo TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public void addToMonto(double valor) {
        this.Monto = this.Monto + valor;
    }

    public enum Tipo {
        DEBITO("Débito"), RETIRO("Retiro");

        String valor;

        Tipo(String valor) {
            this.valor = valor;
        }

        public String getValor() {
            return this.valor;
        }
    }
}
