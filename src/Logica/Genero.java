/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ninoh
 */
public class Genero {
    private String nombre;
    private Genero Padre;
    private ArrayList<Album> Albumes;
    private HashMap<String, PorDefecto> Listas;

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Genero getPadre() {
        return Padre;
    }

    public void setPadre(Genero Padre) {
        this.Padre = Padre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Album> getAlbumes() {
        return Albumes;
    }

    public void setAlbumes(ArrayList<Album> Albumes) {
        this.Albumes = Albumes;
    }

    public HashMap<String, PorDefecto> getListas() {
        return Listas;
    }

    public void setListas(HashMap<String, PorDefecto> Listas) {
        this.Listas = Listas;
    }
    
    public void setAlbum(Album a){
        this.Albumes.add(a);
    }
    
    public void setLista(PorDefecto pd){
        this.Listas.put(pd.getNombre(), pd);
    }
    
}
