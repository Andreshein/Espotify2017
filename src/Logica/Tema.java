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
    private String nombre;
    private String duracion;
    private String orden;
    private String archivo;
    private String direccion;

    public Tema(int id, String nombre, String duracion, String orden, String archivo, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.orden = orden;
        this.archivo = archivo;
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

    public String getArchivo() {
        return archivo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
