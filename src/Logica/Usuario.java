/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import java.util.Date;

public abstract class Usuario {
    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Date fechaNac;
    //Falta implementar imagen

    abstract void setNickname(String nickname);

    abstract void setNombre(String nombre);

    abstract void setApellido(String apellido);

    abstract void setCorreo(String correo);

    abstract void setFechaNac(Date fechaNac);

    abstract String getNickname();

    abstract String getNombre();

    abstract String getApellido();

    abstract String getCorreo();

    abstract Date getFechaNac(); 
    
    
}




