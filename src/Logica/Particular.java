/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author ninoh
 */
public class Particular extends Lista{
    private int id;
    private String nombreusuario;
    private Cliente usuario;
    private String nombre;
    boolean esPrivado;
    

    public Particular(int id, String usuario, String nombre, boolean esPrivado, String img) {
        this.id = id;
        this.nombreusuario = usuario;
        this.nombre= nombre;
        this.esPrivado = esPrivado;
        this.imagen = img;
      
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
}
