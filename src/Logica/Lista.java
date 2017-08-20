/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author ninoh
 */
abstract class Lista {
    protected String nombre;
    protected ArrayList<Tema> temas;
    protected String imagen;

    abstract String getNombre();

    abstract void setNombre(String nombre);
    
}
