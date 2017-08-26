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
    private String artista;
    private String nombre;
    private int anio;
    private String Imagen;
    private HashMap<String, Tema> temas;
    private ArrayList<Genero> generos;

    public Album(String artista,String nombre, int anio) {
        this.artista = artista;
        this.nombre = nombre;
        this.anio = anio;
        this.temas = new HashMap<>();
        this.generos = new ArrayList();
    }
    public Album(int id, String artista,String nombre, int anio, String img) {
        this.id = id;
        this.artista = artista;
        this.nombre = nombre;
        this.anio = anio;
        this.generos = new ArrayList();
        this.temas = new HashMap<>();
        this.Imagen = img;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
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
        return new DtAlbum(nombre, artista, anio, this.getDtTemas()); 
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
    public void AddGenero(Genero e){
        this.generos.add(e);
    }
    public void AddTema (Tema t){
        this.temas.put(t.getNombre(), t);
    }
    public ArrayList<DtTema> getAlbumesTema() {
        ArrayList<DtTema> tema = new ArrayList();
        for (Tema a : this.temas.values()) {
            tema.add(a.getDatos());
        }
        return tema;
        }

    public void setId(int id) {
        this.id = id;
    }

    public void setTemas(HashMap<String, Tema> temas) {
        this.temas = temas;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }
    
}


