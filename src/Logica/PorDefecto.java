/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author ninoh
 */
public class PorDefecto extends Lista{
    private int id;
    private Genero genero;
    private HashMap<String, PorDefecto> Listas;
    

    public PorDefecto(int id, Genero genero, String nombre, String imagen) {
        this.id = id;
        this.genero = genero;
        this.nombre = nombre;
        this.temas = new ArrayList();
        this.imagen = imagen;
    }
    public PorDefecto(int id, String nombre, String img) {
        this.id = id;
        this.genero = null;
        this.nombre = nombre;
        this.imagen = img;
        this.temas = new ArrayList();
    }
            
            
    public int getId(){
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }
    
    public void setTema(Tema t) {
        this.temas.add(t);
    }
    
    public DtListaPD getDatosResumidos(){
        return new DtListaPD(nombre, null, genero.getNombre(), imagen);
    }
    public Genero getGenero(){
        return this.genero;
    }
    public void setGenero(Genero g){
        this.genero = g;
    }
    public void AddTema(Tema t){
        this.getTemas().add(t);
    }

    public String getImagen(){
        return imagen;
    }
    
    DtListaPD getDatos() {        
        return new DtListaPD(nombre, this.getDtTemas(), this.getGenero().getNombre(), imagen);
    }
    
    public ArrayList<DtTema> getDtTemas(){
        ArrayList<DtTema> retorno = new ArrayList<>();
        Iterator iterador = this.temas.iterator();
        while(iterador.hasNext()){
            Tema aux = (Tema)iterador.next();
            retorno.add(aux.getDatos());
        }
        return retorno;
    }

    public HashMap<String, PorDefecto> getListas() {
        return Listas;
    }

    public void setListas(HashMap<String, PorDefecto> Listas) {
        this.Listas = Listas;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public ArrayList<DtTema> getTemasReproducir(){
        ArrayList<DtTema> listaTemas = new ArrayList<>();
        for (Tema tema : this.temas) {
            if(tema.getArchivo() != null){
                listaTemas.add(tema.getDatos());
            }
        }
        
        return listaTemas;
    }

    DtListaPD getDatos(String Pertenece) {        
        return new DtListaPD(nombre, this.getDtTemas(), Pertenece, imagen);
    }
}
