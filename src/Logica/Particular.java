
package Logica;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ImageIcon;


public class Particular extends Lista{
    private int id;
    private String nombreusuario;
    private boolean esPrivado;

    public Particular(int id, String nombreusuario, String nombre, boolean esPrivado,String imagen, Date Fechacreacion) {
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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return new DtListaP(nombre, null, nombreusuario, esPrivado, imagen, formato.format(Fechacreacion));
    }
    
    public void AddTema(Tema t){
        this.temas.add(t);
    }

    public String getImagen(){
        return imagen;
    }
    
    public DtListaP getDatos(String Pertenece){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return new DtListaP(nombre, this.getDtTemas(), Pertenece, this.esPrivado, imagen, formato.format(Fechacreacion));
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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return new DtListaP(nombre,this.getDtTemas(),nombreusuario,formato.format(Fechacreacion));
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

    public Date getFechacreacion() {
        return Fechacreacion;
    }

    public void setFechacreacion(Date Fechacreacion) {
        this.Fechacreacion = Fechacreacion;
    }

    

}
