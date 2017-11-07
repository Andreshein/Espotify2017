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

    private List<DtTema> temas;

    public DataTemas() {
        temas = new ArrayList<>();
    }
    
    public DataTemas(ArrayList<DtTema> temas) {
        this.temas = new ArrayList<>();
        this.temas.addAll(temas);
    }

    public void setTemas(ArrayList<DtTema> temas) {
        this.temas = temas;
    }

    public List<DtTema> getTemas() {
        return temas;
    }
    
}
