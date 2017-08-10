/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class DtAlbum {
    private final String nombre;
    private final String nombreArtista;
    private final String anio;
    private final ArrayList<DtTema> temas;
    //falta implementar Imagen

    public DtAlbum(String nombre, String nombreArtista, String anio, ArrayList<DtTema> temas) {
        this.nombre = nombre;
        this.nombreArtista = nombreArtista;
        this.anio = anio;
        this.temas = temas;
    }

    

    public String getNombre() {
        return nombre;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public String getAnio() {
        return anio;
    }

    public ArrayList<DtTema> getTemas() {
        return temas;
    }
    
}
