/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author stephiRM
 */

@XmlSeeAlso({DtArtista.class, DtCliente.class})//Se usa esta etiqueta para que las clases abstractas funcionen bien en web services
@XmlAccessorType(XmlAccessType.FIELD)
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
