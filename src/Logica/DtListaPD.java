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
public class DtListaPD extends DtLista {
    private String Genero;
    private String Fechacreacion;

    public DtListaPD(String Nombre, ArrayList<DtTema> temas, String Genero, String rutaImg, String Fechacreacion) {
        this.Genero = Genero;
        this.nombre = Nombre;
        this.temas = temas;
        this.rutaImagen = rutaImg;
        this.Fechacreacion=Fechacreacion;
    }
    public DtListaPD(String Nombre, String Genero, String Fechacreacion) {
        this.Genero = Genero;
        this.nombre = Nombre;
        this.temas = null;
        this.rutaImagen = null;
        this.Fechacreacion=Fechacreacion;
    }

    public String getGenero() {
        return Genero;
    }   
    
    public String getNombre(){
        return nombre;
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
