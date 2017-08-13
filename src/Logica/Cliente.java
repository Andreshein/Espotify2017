/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Cliente extends Usuario{
    private HashMap<String, Particular> Listas;
    private ArrayList<Lista> favListas;
    private ArrayList<Album> favAlbumes;
    private ArrayList<Tema> favTemas;
    private HashMap<String, Usuario> Siguiendo;
    
    public Cliente(String nickname, String nombre, String apellido, DtDate fechaNac, String correo) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.correo = correo;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaNac(DtDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public DtDate getFechaNac() {
        return fechaNac;
    }

    public HashMap<String, Particular> getListas() {
        return Listas;
    }

    public void setListas(HashMap<String, Particular> Listas) {
        this.Listas = Listas;
    }

    public ArrayList<Lista> getFavListas() {
        return favListas;
    }

    public void setFavListas(ArrayList<Lista> favListas) {
        this.favListas = favListas;
    }

    public ArrayList<Album> getFavAlbumes() {
        return favAlbumes;
    }

    public void setFavAlbumes(ArrayList<Album> favAlbumes) {
        this.favAlbumes = favAlbumes;
    }

    public ArrayList<Tema> getFavTemas() {
        return favTemas;
    }

    public void setFavTemas(ArrayList<Tema> favTemas) {
        this.favTemas = favTemas;
    }

    public HashMap<String, Usuario> getSiguiendo() {
        return Siguiendo;
    }

    public void setSiguiendo(HashMap<String, Usuario> Siguiendo) {
        this.Siguiendo = Siguiendo;
    }
    
    public void setFavAlbum(Album a) {
        this.favAlbumes.add(a);
    }
    
    public void setFavTema(Tema t) {
        this.favTemas.add(t);
    }
    
    public void setFavLista(Lista l) {
        this.favListas.add(l);
    }
    
    public void setLista(Particular p) {
        this.Listas.put(p.getNombre(), p);
    }

    public void setSiguiendo(Usuario u) {
        this.Siguiendo.put(u.getNickname(), u);
    }
    
}
