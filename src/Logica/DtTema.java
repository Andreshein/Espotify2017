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
    
    //Tuve que crearlo porque sino no se podia usar en web service
    public DtTema() {
        this.nombre = null;
        this.duracion = null;
        this.orden = 0;
        this.direccion = null;
        this.archivo = null;
        this.nomartista = null;
        this.nomalbum = null;
        this.archivobyte = null;
        this.cantDescarga = 0;
        this.cantReproduccion = 0;   
    }
    
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
        
        //Es para que las duraciones de menos de 10 minutos empiecen por 0. Ej: 2:30 -> 02:30
        //Es necesario para que se puedan ordenar bien en la pagina desde javascript
        String[] durDividida = duracion.split(":");
        int minutos = Integer.valueOf(durDividida[0]);
        int segundos = Integer.valueOf(durDividida[1]);
        if(minutos < 10){
            durDividida[0] = "0"+minutos;
        }
        if(segundos < 10){
            durDividida[1] = "0"+segundos;
        }
        duracion = durDividida[0]+":"+durDividida[1];
        //
        
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
