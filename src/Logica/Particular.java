
package Logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ImageIcon;


public class Particular extends Lista{
    private int id;
    private String nombreusuario;
    private boolean esPrivado;
    private String Fechacreacion;
    
    public Particular(int id, String nombreusuario, String nombre, boolean esPrivado,String imagen,String Fechacreacion) {
        this.id = id;
        this.nombreusuario = nombreusuario;
        this.nombre = nombre;
        this.esPrivado = esPrivado;
        this.temas = new ArrayList();
        this.imagen=imagen;
        this.Fechacreacion=Fechacreacion;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.nombreusuario = usuario;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return nombreusuario;
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
        return new DtListaP(nombre, null, nombreusuario, esPrivado, imagen);
    }
    
    public void AddTema(Tema t){
        this.temas.add(t);
    }

    public String getImagen(){
        return imagen;
    }
    
    public DtListaP getDatos(String Pertenece){
        return new DtListaP(nombre, this.getDtTemas(), Pertenece, this.esPrivado, imagen);
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
        return new DtListaP(nombre,this.getDtTemas(),nombreusuario);
    }
    
    public ArrayList<DtTema> getTemasReproducir(){
        ArrayList<DtTema> listaTemas = new ArrayList<>();
        for (Tema tema : this.temas) {
            if(tema.getArchivo() != null){
                listaTemas.add(tema.getDatos());
            }
        }
        
        return listaTemas;
    }

    /**
     * @return the Fechacreacion
     */
    public String getFechacreacion() {
        return Fechacreacion;
    }

    /**
     * @param Fechacreacion the Fechacreacion to set
     */
    public void setFechacreacion(String Fechacreacion) {
        this.Fechacreacion = Fechacreacion;
    }
}
