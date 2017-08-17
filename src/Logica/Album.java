/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
    
    public DtAlbum getDatos(String Artista){
        return new DtAlbum(nombre, Artista, anio, this.getDtTemas()); 
    }
    
    public DtAlbum getDatos(){
        return new DtAlbum(nombre, "nomArtista", anio, this.getDtTemas()); 
    }
    
    public ArrayList<DtTema> getDtTemas(){
        ArrayList<DtTema> retorno = new ArrayList<>();
        Iterator iterador = this.temas.values().iterator();
        while(iterador.hasNext()){
            Tema aux = (Tema)iterador.next();
            retorno.add(aux.getDatos());
        }
        return retorno;
    }
   

}


