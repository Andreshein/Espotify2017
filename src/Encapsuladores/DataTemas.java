/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Encapsuladores;

import Logica.DtTema;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataTemas {    

    //private ArrayList<DtTema> temas;
    private List<DtTema> temas;

    public DataTemas() {
        temas = new ArrayList<>();
    }
    
    public DataTemas(List<DtTema> temas) {
        this.temas = temas;
    }

    public void setTemas(List<DtTema> temas) {
        this.temas = temas;
    }

    public List<DtTema> getTemas() {
        return temas;
    }
    
    public void setTema(String nombre, String duracion, int orden, String direccion, String archivo, byte[] arch, int cantDescarga,int cantReproduccion){
        DtTema tem = new DtTema(archivo, nombre, nombre, duracion, orden, direccion, archivo, cantDescarga, cantReproduccion);
        this.temas.add(tem);
    }
    
}
