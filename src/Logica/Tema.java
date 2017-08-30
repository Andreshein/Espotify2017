/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author ninoh
 */
public class Tema {
    private int id;
    private String duracion;
    private String nombre;
    private int orden;
    private String archivo;
    private String direccion;

    public Tema(int id, String duracion, String nombre, int orden, String archivo, String direccion) {
        this.id = id;
        this.duracion = duracion;
        this.nombre = nombre;
        this.orden = orden;
        this.archivo = archivo;
        this.direccion = direccion;
    }
    public Tema(String duracion, String nombre, int orden, String archivo, String direccion) {
        this.duracion = duracion;
        this.nombre = nombre;
        this.orden = orden;
        this.archivo = archivo;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getOrden() {
        return orden;
    }

    public String getArchivo() {
        return archivo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public DtTema getDatos(){
        return new DtTema(nombre, duracion, orden, direccion);
    }
    
    
}
