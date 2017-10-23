/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Encapsuladores;

import Logica.DtTipoSuscripcion;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataTiposDeSus {    

    private final ArrayList<DtTipoSuscripcion> tiposDeSus;

    public DataTiposDeSus(ArrayList<DtTipoSuscripcion> tiposDeSus) {
        this.tiposDeSus = tiposDeSus;
    }

    public ArrayList<DtTipoSuscripcion> getTiposDeSus() {
        return tiposDeSus;
    }
    
}
