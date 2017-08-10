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
public class DtTema {
    private final int id;
    private final String nombre;
    private final String duracion;
    private final String orden;
    private final String direccion;
//   private final String archivo; //aca me parece que no seria string, seria el tipo de archivo, tipo mp3

    public DtTema(int id, String nombre, String duracion, String orden, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.orden = orden;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getOrden() {
        return orden;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
}
