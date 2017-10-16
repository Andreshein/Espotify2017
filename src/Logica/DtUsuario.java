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
    protected String contrasenia;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected String fechaNac;
    protected String rutaImagen;
    
    public String getNickname() {
        return nickname;
    }

    public String getContrasenia() {
        return contrasenia;
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

    public String getFechaNac() {
        return fechaNac;
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }


}
