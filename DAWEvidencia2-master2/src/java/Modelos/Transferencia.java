package Modelos;

import java.time.LocalDate;

/**
 *
 * @author Brandon
 */
public class Transferencia {
    private String numeroCuentaOrigen;
    private String numeroCuentaDestino;
    private double cantidad;
    private LocalDate fecha;

    public Transferencia(String origen, String destino, double cantidad, LocalDate fecha) {
        this.numeroCuentaOrigen = origen;
        this.numeroCuentaDestino = destino;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    /**
     * @return the numeroCuentaOrigen
     */
    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    /**
     * @param numeroCuentaOrigen the numeroCuentaOrigen to set
     */
    public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
        this.numeroCuentaOrigen = numeroCuentaOrigen;
    }

    /**
     * @return the numeroCuentaDestino
     */
    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    /**
     * @param numeroCuentaDestino the numeroCuentaDestino to set
     */
    public void setNumeroCuentaDestino(String numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
