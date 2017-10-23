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

    public DtListaPD(String Nombre, ArrayList<DtTema> temas, String Genero, String rutaImg) {
        this.Genero = Genero;
        this.nombre = Nombre;
        this.temas = temas;
        this.rutaImagen = rutaImg;
    }
    public DtListaPD(String Nombre, String Genero) {
        this.Genero = Genero;
        this.nombre = Nombre;
        this.temas = null;
        this.rutaImagen = null;
    }

    public String getGenero() {
        return Genero;
    }   
    
    public String getNombre(){
        return nombre;
    }
    
}
