/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ninoh
 */
abstract class Lista {
    protected String nombre;
    protected String imagen;
    protected ArrayList<Tema> temas;
    protected Date Fechacreacion;


    abstract String getNombre();
    abstract void setNombre(String nombre);
    abstract void setTema(Tema t);
    abstract void setTemas(ArrayList<Tema> temas);
    abstract ArrayList<Tema> getTemas();
    abstract DtLista getDatos(String Pertenece);
    abstract Date getFechacreacion();
    abstract void setFechacreacion(Date Fechacreacion);
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}