/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Collection;

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
    private String nombrealbum;
    private String nombreartista;

    public Tema(int id, String duracion, String nombre, int orden, String archivo, String direccion, String art, String alb) {
        this.id = id;
        this.duracion = duracion;
        this.nombre = nombre;
        this.orden = orden;
        this.archivo = archivo;
        this.direccion = direccion;
        this.nombrealbum = alb;
        this.nombreartista = art;
    }
    
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
    
    public Tema(String duracion, String nombre, int orden, String archivo, String direccion , String alb, String art) {
        this.duracion = duracion;
        this.nombre = nombre;
        this.orden = orden;
        this.archivo = archivo;
        this.direccion = direccion;
        this.nombrealbum = alb;
        this.nombreartista = art;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombrealbum() {
        return nombrealbum;
    }

    public String getNombreartista() {
        return nombreartista;
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
        return new DtTema(nombreartista, nombrealbum, nombre, duracion, orden, direccion, archivo);
    }

    
    
    
}
