/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author ninoh
 */
public class Artista extends Usuario {
    private String biografia;
    private String paginaWeb;
    private HashMap<String, Album> albumes;

    public Artista(String nickname, String nombre, String apellido, Date fechaNac, String biografia, String paginaWeb) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.biografia = biografia;
        this.paginaWeb = paginaWeb;
        this.albumes= new HashMap<>();
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

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public HashMap<String, Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(HashMap<String, Album> albumes) {
        this.albumes = albumes;
    }
    
    public void setAlbum(Album a ){
        this.albumes.put(a.getNombre(),a);
    }
    
}
