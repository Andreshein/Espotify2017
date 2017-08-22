
package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;


public class Particular extends Lista{
    private String nombre;
    boolean esPrivado;
    

    public Particular(String nombre) {
        this.nombre= nombre;
        this.esPrivado = true;
      
    }

    public boolean isEsPrivado() {
        return esPrivado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEsPrivado(boolean esPrivado) {
        this.esPrivado = esPrivado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public DtListaP getDatosResumidos(){
        return new DtListaP(nombre, null, null, "Creador", esPrivado); //Creador = Usuario, falta implementar
    }

    public DtListaP getDatos(String Pertenece){
        return new DtListaP(nombre, null, this.getDtTemas(), Pertenece, this.esPrivado);
    }
    
    public ArrayList<DtTema> getDtTemas(){
        ArrayList<DtTema> retorno = new ArrayList<>();
        Iterator iterador = this.getTemas().iterator();
        while(iterador.hasNext()){
            Tema aux = (Tema)iterador.next();
            retorno.add(aux.getDatos());
        }
        return retorno;
    }

    void setTema(Tema t) {
        this.temas.add(t);
    }

    void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }

    String getNombtre() {
        return this.nombre;
    }

    ArrayList<Tema> getTemas() {
        return this.temas;
    }
    
    
    public DtListaP getDtListaP(){
        return new DtListaP(nombre,getDtTemas());
    }
    
}
