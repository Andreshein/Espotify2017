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
    private int id;
    private String nombre;
    private int idPapa;
    private Genero Padre;
    private HashMap<String, Album> Albumes;
    private HashMap<String, PorDefecto> Listas;


    public Genero(int id, String nombre,int Papa) {
        this.id = id;
        this.nombre = nombre;
        this.idPapa = Papa;
        this.Padre = null;
        this.Albumes = new HashMap();
        this.Listas = new HashMap();
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

    public HashMap<String, Album> getAlbumes() {
        return Albumes;
    }

    public void setAlbumes(HashMap<String, Album> albumes) {
        this.Albumes = albumes;
    }

    public HashMap<String, PorDefecto> getListas() {
        return Listas;
    }

    public void setListas(HashMap<String, PorDefecto> Listas) {
        this.Listas = Listas;
    }
    public void AddLista(PorDefecto pd){
        this.Listas.put(pd.getNombre(), pd);
    }
    public void AddAlbum(Album a){
        this.Albumes.put(a.getNombre(), a);
    }
}
