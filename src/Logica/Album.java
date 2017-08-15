/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;

/**
 *
 * @author ninoh
 */
public class Album {
    private int id;
    private String nombre;
    private int anio;
    private HashMap<String, Tema> temas;

    public Album(int id, String nombre, int anio) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.temas = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAño() {
        return anio;
    }
    
    public Tema getTema(String nombre){
        return this.temas.get(nombre);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAño(int anio) {
        this.anio = anio;
    }
    
    public void setTema(Tema tema){
        this.temas.put(tema.getNombre(), tema);
    }
    
    public DtAlbum getDatos(){
        // Falta artista y temas(para CU ver Perfil Cliente no se necesitan)
        return new DtAlbum(nombre, "nomArtista", String.valueOf(anio), null); 
    }
   

}


