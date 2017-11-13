/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;     

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaP extends DtLista{
    private String Usuario;
    private boolean Privada;
    private String Fechacreacion;

    public DtListaP(String Nombre, ArrayList<DtTema> temas, String Usuario,  Boolean Privada, String rutaImg, String Fechacreacion) {
        this.Usuario = Usuario;
        this.Privada = Privada;
        this.nombre = Nombre;
        this.temas = temas;
        this.rutaImagen = rutaImg;
        this.Fechacreacion=Fechacreacion;
    }
    public DtListaP(String Nombre, String Usuario, String Fechacreacion) {
        this.Usuario = Usuario;
        this.Privada = false;
        this.nombre = Nombre;
        this.temas = null;
        this.rutaImagen = null;
        this.Fechacreacion=Fechacreacion;
    }

    public String getUsuario() {
        return Usuario;
    }

    public boolean isPrivada() {
        return Privada;
    }
    
    public DtListaP(String nombre, ArrayList<DtTema> temas, String cli, String Fechacreacion) {
        this.nombre = nombre;
        this.temas = temas;
        this.Usuario = cli;
        this.Fechacreacion=Fechacreacion;
    }

    /**
     * @return the Fechacreacion
     */
    public String getFechacreacion() {
        return Fechacreacion;
    }

    /**
     * @param Fechacreacion the Fechacreacion to set
     */
    public void setFechacreacion(String Fechacreacion) {
        this.Fechacreacion = Fechacreacion;
    }
    
    
}
