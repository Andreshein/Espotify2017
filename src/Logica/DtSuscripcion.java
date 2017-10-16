/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class DtSuscripcion { 
    private int id;
    private final String cliente;
    private final String fecha;
    private final String Estado;
    private final String Tipo;
    private final int Monto;

    public DtSuscripcion(int id, String cliente, Date fecha, String Estado, String Tipo, int Monto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        this.cliente = cliente;
        this.fecha = formato.format(fecha);
        this.Estado = Estado;
        this.Tipo = Tipo;
        this.Monto = Monto;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getFecha() {
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
