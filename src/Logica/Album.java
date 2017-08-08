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
public class Album {
    private int id;
    private String nombre;
    private String año;

    public Album(int id, String nombre, String año) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAño() {
        return año;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAño(String año) {
        this.año = año;
    }
   

}


