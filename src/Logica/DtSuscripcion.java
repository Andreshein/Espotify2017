/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Kevin
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class DtSuscripcion { 
    private int id;
    private final String cliente;
    private final String fecha;
    private final String Estado;
    private final String Tipo;
    private final int Monto;

    public DtSuscripcion(int id, String cliente, String fecha, String Estado, String Tipo, int Monto) {
        
        this.cliente = cliente;
        this.fecha = fecha;
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
