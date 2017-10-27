/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ninoh
 */
public class Genero {
    private int id;
    private String nombre;
    private int idPapa;
    private Genero Padre;
    private HashMap<String, Album> Albumes;
    private HashMap<String, PorDefecto> Listas;


    public Genero(int id, String nombre,int Papa) {
        this.id = id;
        this.nombre = nombre;
        this.idPapa = Papa;
        this.Padre = null;
        this.Albumes = new HashMap();
        this.Listas = new HashMap();
    }
    
    public int getid(){
        return id;
    }
    
    public int getidpadre(){
        return idPapa;
    }
    public Genero getPadre(){
        return Padre;
    }

    public void setPadre(Genero Padre) {
        this.Padre = Padre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Album> getAlbumes() {
        return Albumes;
    }

    public void setAlbumes(HashMap<String, Album> albumes) {
        this.Albumes = albumes;
    }

    public HashMap<String, PorDefecto> getListas() {
        return Listas;
    }

    public void setListas(HashMap<String, PorDefecto> Listas) {
        this.Listas = Listas;
    }
    public void AddLista(PorDefecto pd){
        this.Listas.put(pd.getNombre(), pd);
    }
    public void AddAlbum(Album a){
        this.Albumes.put(a.getNombre(), a);
    }
    
    public DtGenero getDatos(ArrayList<DtGenero> hijos){
        return new DtGenero(this.nombre,this.getDtAlbumes(), this.getDtListas(), hijos);
    }
    
    public ArrayList<DtAlbum> getDtAlbumes(){
        ArrayList<DtAlbum> a = new ArrayList<>();
        Iterator it = this.getAlbumes().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry mentry = (Map.Entry)it.next();
            Album al=(Album) mentry.getValue();
            a.add(al.getDatos());
        }
        return a;
    }
    
    public ArrayList<DtListaPD> getDtListas(){
        ArrayList<DtListaPD> a = new ArrayList<>();
        Iterator it = this.getListas().values().iterator();
        while(it.hasNext()){
            PorDefecto lpd = (PorDefecto)it.next();
            a.add(lpd.getDatos());
        }
        return a;
    }
    
    public ArrayList<DtAlbum> getAlbumesGenero() {
    ArrayList<DtAlbum> albumes = new ArrayList();
    for (Album a : this.Albumes.values()) {
        albumes.add(a.getDatos());
    }
    return albumes;
    }
        
    public ArrayList<DtTema> reproducirListaPD(String lista){
        return this.Listas.get(lista).getTemasReproducir();
    }    
}
