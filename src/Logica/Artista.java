/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;

/**
 *
 * @author ninoh
 */
public class Artista extends Usuario {
    private String biografia;
    private String paginaWeb;

    public Artista(String nickname, String nombre, String apellido, Date fechaNac, String biografia, String paginaWeb) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.biografia = biografia;
        this.paginaWeb = paginaWeb;
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
    
    
    
}
