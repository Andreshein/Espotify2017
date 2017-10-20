/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Encapsuladores;

import Logica.DtTema;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataTemas {    

    private final ArrayList<DtTema> temas;

    public DataTemas(ArrayList<DtTema> temas) {
        this.temas = temas;
    }

    public ArrayList<DtTema> getTemas() {
        return temas;
    }
    
}
