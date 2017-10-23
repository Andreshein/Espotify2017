/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Encapsuladores;

import Logica.DtGenero;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataGeneros {    

    private final ArrayList<DtGenero> generos;

    public DataGeneros(ArrayList<DtGenero> generos) {
        this.generos = generos;
    }

    public ArrayList<DtGenero> getGeneros() {
        return generos;
    }
    
}
