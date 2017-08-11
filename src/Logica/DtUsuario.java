/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author stephiRM
 */
public class DtUsuario {
    private final String nickname;
    private final String nombre;
    private final String apellido;
    private final String correo;
    private final Date fechaNac;
    private final ImageIcon imagen;

    public DtUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, ImageIcon imagen) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
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

    public ImageIcon getImagen() {
        return imagen;
    }
    
    
    
}
