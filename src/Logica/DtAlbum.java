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
    private final int anio;
    private final ArrayList<DtTema> temas;
    private final ArrayList<String> generos;
    private final String rutaImagen;

    public DtAlbum(String nombre, String nombreArtista, int anio, ArrayList<DtTema> temas, ArrayList<String> generos, String rutaImg) {
        this.nombre = nombre;
        this.nombreArtista = nombreArtista;
        this.anio = anio;
        this.temas = temas;
        this.generos=generos;
        this.rutaImagen = rutaImg;
    }
    public DtAlbum(String nombre, String nombreArtista, int anio) {
        this.nombre = nombre;
        this.nombreArtista = nombreArtista;
        this.anio = anio;
        this.temas = null;
        this.generos = null;
        this.rutaImagen = null;
    }

    

    public String getNombre() {
        return nombre;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public int getAnio() {
        return anio;
    }

    public ArrayList<DtTema> getTemas() {
        return temas;
    }

    public ArrayList<String> getGeneros() {
        return generos;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
    
}
