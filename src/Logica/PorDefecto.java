/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author ninoh
 */
public class PorDefecto extends Lista{
    private int id;
    private int genero;
    private String nombre;

    public PorDefecto(int id, int genero, String nombre) {
        this.id = id;
        this.genero = genero;
        this.nombre = nombre;
    }
            
            
    public PorDefecto(String nombre) {
        this.nombre=nombre;
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
}
