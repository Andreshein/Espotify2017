/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Encapsuladores;

import Logica.DtAlbum;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataAlbumes {    

    private final ArrayList<DtAlbum> albumes;

    public DataAlbumes(ArrayList<DtAlbum> albumes) {
        this.albumes = albumes;
    }

    public ArrayList<DtAlbum> getAlbumes() {
        return albumes;
    }
    
}
