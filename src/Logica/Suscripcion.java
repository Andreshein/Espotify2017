/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Suscripcion {
    private TipoSuscripcion tp;
    private Date fecha;
    private String Estado;
    private int idTipo;
    private String nickcliente;

    public Suscripcion(Date fecha, String Estado, int tipo, String nick) {
        this.fecha = fecha;
        this.Estado = Estado;
        this.idTipo = tipo;
        this.nickcliente = nick;
    }

    public String getNickcliente() {
        return nickcliente;
    }

    public void setNickcliente(String nickcliente) {
        this.nickcliente = nickcliente;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public TipoSuscripcion getTp() {
        return tp;
    }

    public void setTp(TipoSuscripcion tp) {
        this.tp = tp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
}
