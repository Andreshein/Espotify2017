/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Encapsuladores;

import Logica.DtUsuario;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataUsuarios {    

    private final ArrayList<DtUsuario> usuarios;

    public DataUsuarios(ArrayList<DtUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<DtUsuario> getUsuarios() {
        return usuarios;
    }
    
}
