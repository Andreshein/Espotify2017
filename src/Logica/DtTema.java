/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Kevin
 */
public class DtTema {
    private final String artista;
    private final String album;
    private final String nombre;
    private final String duracion;
    private final int orden;
    private final String direccion;
    private final String archivo;

    public DtTema(String artista, String album, String nombre, String duracion, int orden, String direccion, String archivo) {
        this.artista = artista;
        this.album = album;
        this.nombre = nombre;
        this.duracion = duracion;
        this.orden = orden;
        this.direccion = direccion;
        this.archivo = archivo;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getOrden() {
        return orden;
    }

    public String getDireccion() {
        return direccion;
    }
    public String getArchivo() {
        return archivo;
    }
    
}
