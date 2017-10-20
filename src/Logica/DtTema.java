/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Kevin
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class DtTema {
    private final String nombre;
    private final String duracion;
    private final int orden;
    private final String direccion;
    private final String archivo;
    private final String nomartista;
    private final String nomalbum;
    private final byte[] archivobyte;
    private final int cantDescarga;
    private final int cantReproduccion;
    
    public DtTema(String nombre, String duracion, int orden, String direccion, String archivo, byte[] arch, int cantDescarga,int cantReproduccion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.orden = orden;
        this.direccion = direccion;
        this.archivo = archivo;
        this.nomartista = null;
        this.nomalbum = null;
        this.archivobyte = arch;
        this.cantDescarga = cantDescarga;
        this.cantReproduccion = cantReproduccion;   
    }
    
    public DtTema(String nombre, String duracion, int orden, String direccion, String archivo) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.orden = orden;
        this.direccion = direccion;
        this.archivo = archivo;
        this.nomartista = null;
        this.nomalbum = null;
        this.archivobyte = null;
        this.cantDescarga = 0;
        this.cantReproduccion = 0; 
    }

    public DtTema(String artista, String album, String nombre, String duracion, int orden, String direccion, String archivo, int cantDescarga,int cantReproduccion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.orden = orden;
        this.direccion = direccion;
        this.archivo = archivo;
        this.nomartista = artista;
        this.nomalbum = album;
        this.archivobyte = null;
        this.cantDescarga = cantDescarga;
        this.cantReproduccion = cantReproduccion; 
    }
    
    public DtTema(String nombre, String alb, String art) {
        this.nombre = nombre;
        this.nomartista = art;
        this.nomalbum = alb;
        this.duracion = null;
        this.orden = 0;
        this.direccion = null;
        this.archivo = null;
        this.archivobyte = null;
        this.cantDescarga = 0;
        this.cantReproduccion = 0; 
    }

    public byte[] getArchivobyte() {
        return archivobyte;
    }

    public String getNomartista() {
        return nomartista;
    }

    public String getNomalbum() {
        return nomalbum;
    }

    public String getArtista() {
        return nomartista;
    }

    public String getAlbum() {
        return nomalbum;
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

    public int getCantDescarga() {
        return cantDescarga;
    }

    public int getCantReproduccion() {
        return cantReproduccion;
    }
}
