/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author stephiRM
 */
public class DtCliente {
    private final String nickname;
    private final String nombre;
    private final String apellido;
    private final Date fechaNac;
    private final String email;
    private final ImageIcon imagen;
    private final ArrayList<String> seguidores;
    private final ArrayList<String> clientesSeguidos; 
    private final ArrayList<String> aristasSeguidos; 
    private final ArrayList<DtLista> listas;
    private final ArrayList<String> preferencias;

    public DtCliente(String nickname, String nombre, String apellido, Date fechaNac, String email, ImageIcon imagen, ArrayList<String> seguidores, ArrayList<String> clientesSeguidos, ArrayList<String> aristasSeguidos, ArrayList<DtLista> listas, ArrayList<String> preferencias) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.email = email;
        this.imagen = imagen;
        this.seguidores = seguidores;
        this.clientesSeguidos = clientesSeguidos;
        this.aristasSeguidos = aristasSeguidos;
        this.listas = listas;
        this.preferencias = preferencias;
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public ArrayList<String> getSeguidores() {
        return seguidores;
    }

    public ArrayList<String> getClientesSeguidos() {
        return clientesSeguidos;
    }

    public ArrayList<String> getAristasSeguidos() {
        return aristasSeguidos;
    }

    public ArrayList<DtLista> getListas() {
        return listas;
    }

    public ArrayList<String> getPreferencias() {
        return preferencias;
    }
}
