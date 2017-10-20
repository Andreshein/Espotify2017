/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Encapsuladores;

import Logica.DtLista;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataListas {    

    private final ArrayList<DtLista> listas;

    public DataListas(ArrayList<DtLista> listas) {
        this.listas = listas;
    }

    public ArrayList<DtLista> getListas() {
        return listas;
    }
    
}
