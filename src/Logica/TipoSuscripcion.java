/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Admin
 */
public class TipoSuscripcion {
    private String cuota;
    private int id;
    private int monto;

    public TipoSuscripcion(String cuota, int id, int monto) {
        this.cuota = cuota;
        this.id = id;
        this.monto = monto;
    }

    public String getCuota() {
        return cuota;
    }

    public int getId() {
        return id;
    }

    public int getMonto() {
        return monto;
    }
    
}
