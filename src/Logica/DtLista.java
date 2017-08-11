/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.swing.ImageIcon;

/**
 *
 * @author stephiRM
 */
public class DtLista {
    private final String nombre;
    private final ImageIcon imagen;
    private final DtGenero genero;
    private final DtCliente cliente;
    private final String archivo;
    private final String url;
    private final DtTema tema;

    public DtLista(String nombre, ImageIcon imagen, DtGenero genero, DtCliente cliente, String archivo, String url, DtTema tema) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.genero = genero;
        this.cliente = cliente;
        this.archivo = archivo;
        this.url = url;
        this.tema = tema;
    }

    public String getNombre() {
        return nombre;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public DtGenero getGenero() {
        return genero;
    }

    public DtCliente getCliente() {
        return cliente;
    }

    public String getArchivo() {
        return archivo;
    }

    public String getUrl() {
        return url;
    }

    public DtTema getTema() {
        return tema;
    }
    
    
    
}
