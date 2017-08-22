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
public class PorDefecto extends Lista{
    private int id;
    private Genero genero;
    private String nombre;
    private HashMap<String, PorDefecto> Listas;
    

    public PorDefecto(int id, Genero genero, String nombre) {
        this.id = id;
        this.genero = genero;
        this.nombre = nombre;
        this.temas = new ArrayList();
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
        return new DtListaPD(nombre, null, null, "Genero"); // falta implementar puntero a genero
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
    
    String getNombtre() {
        return this.nombre;
    }

    DtListaPD getDatos(String Pertenece) {
        return new DtListaPD(nombre, null, this.getDtTemas(), Pertenece);
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
    
}
