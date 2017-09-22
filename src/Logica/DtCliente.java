/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author stephiRM
 */
public class DtCliente extends DtUsuario {

    private final ArrayList<DtUsuario> usuariosSeguidos;
    private final ArrayList<DtListaP> listas;
    private final ArrayList<DtLista> favListas;
    private final ArrayList<DtTema> favTemas;
    private final ArrayList<DtAlbum> favAlbumes;
    private final ArrayList<DtSuscripcion> suscripciones;
    private final boolean vigente;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public DtCliente(String nickname, String contrasenia, String nombre, String apellido, Date fechaNac, String correo, ImageIcon imagen, ArrayList<DtUsuario> usuariosSeguidos, ArrayList<DtListaP> listas, ArrayList<DtLista> favListas, ArrayList<DtTema> favTemas, ArrayList<DtAlbum> favAlbumes, ArrayList<DtSuscripcion> suscripciones) {
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = formato.format(fechaNac);
        this.correo = correo;
        this.imagen = imagen;
        this.usuariosSeguidos = usuariosSeguidos;
        this.listas = listas;
        this.favListas = favListas;
        this.favTemas = favTemas;
        this.favAlbumes = favAlbumes;
        if(suscripciones != null){
        this.suscripciones = suscripciones;
        boolean control = false;
        for (int i = 0; i < suscripciones.size(); i++) {
            control = suscripciones.get(i).getEstado().equals("Vigente");
        }
        this.vigente = control;
        }else{
        this.suscripciones = suscripciones;  
        this.vigente = false;
        }
    }

    public ArrayList<DtUsuario> getUsuariosSeguidos() {
        return this.usuariosSeguidos;
    }

    public ArrayList<DtListaP> getListas() {
        return listas;
    }

    public ArrayList<DtLista> getFavListas() {
        return favListas;
    }

    public ArrayList<DtTema> getFavTemas() {
        return favTemas;
    }

    public ArrayList<DtAlbum> getFavAlbumes() {
        return favAlbumes;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public ArrayList<DtSuscripcion> getSuscripciones() {
        return suscripciones;
    }

    public boolean isVigente() {
        return vigente;
    }
    
    
}
