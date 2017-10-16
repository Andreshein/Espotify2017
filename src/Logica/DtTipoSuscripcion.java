/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Kevin
 */
public class DtTipoSuscripcion {
    private final int id;
    private final String cuota;
    private final int monto;

    public DtTipoSuscripcion(int id, String cuota, int monto) {
        this.id = id;
        this.cuota = cuota;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }
    
    public String getCuota() {
        return cuota;
    }

    public int getMonto() {
        return monto;
    }    
    
}
