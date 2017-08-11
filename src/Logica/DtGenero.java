/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author stephiRM
 */
public class DtGenero {
    private final String nombre;
    private final ArrayList<DtAlbum> albumes;
    private final ArrayList<DtListaPD> listaspordefecto;

    public DtGenero(String nombre, ArrayList<DtAlbum> albumes, ArrayList<DtListaPD> listas) {
        this.nombre = nombre;
        this.albumes = albumes;
        this.listaspordefecto = listas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<DtAlbum> getAlbumes() {
        return albumes;
    }

    public ArrayList<DtListaPD> getListaspordefecto() {
        return listaspordefecto;
    }   
    
}
