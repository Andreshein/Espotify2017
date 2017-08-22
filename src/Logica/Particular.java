
package Logica;

import java.util.ArrayList;
import java.util.Iterator;


public class Particular extends Lista{
    private int id;
    private String nombreusuario;
    private Cliente usuario;
    private String nombre;
    private boolean esPrivado;
    

    public Particular(int id, String usuario, String nombre, boolean esPrivado, String img) {
        this.id = id;
        this.nombreusuario = usuario;
        this.nombre= nombre;
        this.esPrivado = esPrivado;
        this.imagen = img;
        this.temas = new ArrayList();
      
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
        return new DtListaP(nombre, null, null, "Creador", esPrivado); //Creador = Usuario, falta implementar
    }    
    public void setCliente(Cliente c){
        this.usuario = c;
    }
    public Cliente getCliente(){
        return this.usuario;
    }
    public void AddTema(Tema t){
        this.temas.add(t);
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
}
