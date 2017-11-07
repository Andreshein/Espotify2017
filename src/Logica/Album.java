/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.DBUsuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    public Album(String artista,String nombre, int anio, String img) {
        this.artista = artista;
        this.nombre = nombre;
        this.anio = anio;
        this.generos = new ArrayList();
        this.temas = new HashMap<>();
        this.Imagen = img;
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
    public Album(String artista,String nombre, int anio, String img, HashMap<String, Tema> temas, ArrayList<Genero> generos) {
        this.artista = artista;
        this.nombre = nombre;
        this.anio = anio;
        this.generos = generos;
        this.temas = temas;
        this.Imagen = img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public HashMap<String, Tema> getTemas(){
        return temas;
    }
    public ArrayList<Genero> getGeneros(){
        return generos;
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

    public int getAnio() {
        return anio;
    }
    
    public Tema getTema(String nombre){
        return this.temas.get(nombre);
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public void setTema(Tema tema){
        this.temas.put(tema.getNombre(), tema);
    }
    
    public DtAlbum getDatos(String art){
        return new DtAlbum(nombre, art, anio, this.getDtTemas(), null, Imagen); 
    }
    
    public DtAlbum getDatos(){        
        ArrayList <String> listaGeneros = new ArrayList<>();
        for (Genero genero : generos) {
            listaGeneros.add(genero.getNombre());
        }
        return new DtAlbum(nombre, artista, anio, this.getDtTemas(), listaGeneros, Imagen); 
    }
    
    public ArrayList<DtTema> getDtTemas(){
        ArrayList<DtTema> retorno = new ArrayList<>();
        Iterator iterador = this.temas.values().iterator();
        while(iterador.hasNext()){
            Tema aux = (Tema)iterador.next();
            retorno.add(aux.getDatos());
        }
        
        //Ordenar temas segun su orden en el album
        Collections.sort(retorno, new Comparator<DtTema>() {
            @Override
            public int compare(DtTema tema1, DtTema tema2) {
                Integer orden1 = tema1.getOrden();
                Integer orden2 = tema2.getOrden();
                return orden2.compareTo(orden1);
            }
        });
        
        return retorno;
    }
    public void AddGenero(Genero e){
        this.generos.add(e);
    }
    public void AddTema (Tema t){
        this.temas.put(t.getNombre(), t);
    }
    public String getImagen(){
        return this.Imagen;
    }
    public ArrayList<DtTema> getAlbumesTema() {
        ArrayList<DtTema> tema = new ArrayList();
        for (Tema a : this.temas.values()) {
            tema.add(a.getDatos());
        }
        return tema;
    }

    public void setTemas(HashMap<String, Tema> temas) {
        this.temas = temas;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }
    
    public ArrayList<DtTema> getTemasReproducir(){
        ArrayList<DtTema> listaTemas = new ArrayList<>();
        for (Tema tema : this.temas.values()) {
            if(tema.getArchivo() != null){
                listaTemas.add(tema.getDatos());
            }
        }
        
        //Ordenar temas segun su orden en el album
        Collections.sort(listaTemas, new Comparator<DtTema>() {
            @Override
            public int compare(DtTema tema1, DtTema tema2) {
                Integer orden1 = tema1.getOrden();
                Integer orden2 = tema2.getOrden();
                return orden1.compareTo(orden2);
            }
        });
        
        return listaTemas;
    }
    
        public ArrayList<DtTema> coincideciaT(String palabra){
        ArrayList<DtTema> temas = new ArrayList<>();
        String cadena = palabra.toUpperCase();
        for(Tema tem: this.temas.values()){
        if(tem.getNombre().toUpperCase().contains(cadena) || tem.getNombrealbum().toUpperCase().contains(cadena) || this.artista.toUpperCase().contains(cadena))
            temas.add(tem.getDatos());
        }
        return temas;
    }
    public void nuevaDescargaTema (String tema){
      Tema tem = this.temas.get(tema);
      int cantidad = tem.getCantDescargas();
      tem.setCantDescargas(cantidad + 1);
      
      DBUsuario dbUsuario = new DBUsuario();
      dbUsuario.sumaDescarga(tem.getId());
      
    }
    
    public void nuevaReproduccionTema (String tema){
      Tema tem = this.temas.get(tema);
      int cantidad = tem.getCantReproduccion();
      tem.setCantReproduccion(cantidad + 1);
       
      DBUsuario dbUsuario = new DBUsuario();
      dbUsuario.sumaReproduccion(tem.getId());
    }
}


