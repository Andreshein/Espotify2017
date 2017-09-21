/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;

/**
 *
 * @author Kevin
 */
public class DtSuscripcion {
    private String cliente;
    private Date fecha;
    private String Estado;
    private String Tipo;
    private int Monto;

    public DtSuscripcion(String cliente, Date fecha, String Estado, String Tipo, int Monto) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.Estado = Estado;
        this.Tipo = Tipo;
        this.Monto = Monto;
    }

    public String getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public String getTipo() {
        return Tipo;
    }

    public int getMonto() {
        return Monto;
    }

    
}
