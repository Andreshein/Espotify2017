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
public abstract class DtUsuario {
    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Date fechaNac;
    protected ImageIcon imagen;

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
