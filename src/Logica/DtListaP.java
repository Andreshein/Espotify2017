/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;     

import java.util.ArrayList;
import javax.swing.ImageIcon;


public class DtListaP extends DtLista{
    private String Usuario;
    private boolean Privada;

    public DtListaP(String Nombre, ImageIcon imagen, ArrayList<DtTema> temas, String Usuario,  Boolean Privada) {
        this.Usuario = Usuario;
        this.Privada = Privada;
        this.imagen = imagen;
        this.nombre = Nombre;
        this.temas = temas;
    }
    public DtListaP(String Nombre, String Usuario) {
        this.Usuario = Usuario;
        this.Privada = false;
        this.imagen = null;
        this.nombre = Nombre;
        this.temas = null;
    }

    public String getUsuario() {
        return Usuario;
    }

    public boolean isPrivada() {
        return Privada;
    }
    
    public DtListaP(String nombre, ArrayList<DtTema> temas, String cli) {
        this.nombre = nombre;
        this.temas = temas;
        this.Usuario = cli;
    }
    
    
}
