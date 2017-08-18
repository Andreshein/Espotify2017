/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class DtListaPD extends DtLista {
    private String Genero;

    public DtListaPD(String Nombre, ImageIcon imagen, ArrayList<DtTema> temas, String Genero) {
        this.Genero = Genero;
        this.nombre = Nombre;
        this.imagen= imagen;
        this.temas = temas;
    }

    public String getGenero() {
        return Genero;
    }   
    
    
}
