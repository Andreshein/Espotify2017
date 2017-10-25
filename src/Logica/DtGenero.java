/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author stephiRM
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class DtGenero {
    private final String nombre;
    private final int idpadre;
    private final int id;
    private final ArrayList<DtAlbum> albumes;
    private final ArrayList<DtListaPD> listaspordefecto;
    private final ArrayList<DtGenero> hijos;
    
    public DtGenero(){
        this.nombre = null;
        this.albumes = new ArrayList<>();
        this.listaspordefecto = new ArrayList<>();
        this.hijos = new ArrayList<>();
        this.idpadre = 0;
        this.id = 0;
    }

    public DtGenero(String nombre, ArrayList<DtAlbum> albumes, ArrayList<DtListaPD> listas, ArrayList<DtGenero> hijos) {
        this.nombre = nombre;
        this.albumes = albumes;
        this.listaspordefecto = listas;
        this.hijos = hijos;
        this.idpadre = 0;
        this.id = 0;
    }
    
    public DtGenero(String nombre, int idpa, int id) {
        this.nombre = nombre;
        this.idpadre = idpa;
        this.id = id;
        this.albumes = null;
        this.listaspordefecto = null;
        this.hijos = null;
    }

    public int getIdpadre() {
        return idpadre;
    }

    public int getId() {
        return id;
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

    public ArrayList<DtGenero> getHijos() {
        return hijos;
    }
    
}
