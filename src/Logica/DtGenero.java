/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author stephiRM
 */
public class DtGenero {
    private final String nombre;
    private final DtAlbum albumes;

    public DtGenero(String nombre, DtAlbum albumes) {
        this.nombre = nombre;
        this.albumes = albumes;
    }

    public String getNombre() {
        return nombre;
    }

    public DtAlbum getAlbumes() {
        return albumes;
    }
    
    
}
