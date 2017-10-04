/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author stephiRM
 */
public abstract class DtLista {
    protected String nombre;
    protected ImageIcon imagen;
    protected ArrayList<DtTema> temas;  
    protected String rutaImagen;  

    public String getNombre() {
        return nombre;
    }

    public ImageIcon getImagen() {
        return imagen;
    }    

    public ArrayList<DtTema> getTema() {
        return this.temas;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
    
}
