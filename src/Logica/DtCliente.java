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
public class DtCliente extends DtUsuario{
    private final ArrayList<DtUsuario> usuariosSeguidos;
    private final ArrayList<DtListaP> listas;
    private final ArrayList<DtLista> favListas;
    private final ArrayList<DtTema> favTemas;
    private final ArrayList<DtAlbum> favAlbumes;
    
    SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
    
    public DtCliente(String nickname, String nombre, String apellido, Date fechaNac, String correo, ImageIcon imagen, ArrayList<DtUsuario> usuariosSeguidos, ArrayList<DtListaP> listas, ArrayList<DtLista> favListas, ArrayList<DtTema> favTemas, ArrayList<DtAlbum> favAlbumes) {
        this.nickname = nickname;
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
    
    

    
}
