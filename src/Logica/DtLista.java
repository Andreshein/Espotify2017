/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author stephiRM
 */

@XmlSeeAlso({DtListaP.class, DtListaPD.class})//Se usa esta etiqueta para que las clases abstractas funcionen bien en web services
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class DtLista {
    protected String nombre;
    protected ArrayList<DtTema> temas;  
    protected String rutaImagen;  
    protected String Fechacreacion;
    

    public String getNombre() {
        return nombre;
    } 

    public ArrayList<DtTema> getTema() {
        return this.temas;
    }

    public String getRutaImagen() {
        return rutaImagen;
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
