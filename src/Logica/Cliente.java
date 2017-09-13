/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Cliente extends Usuario {

    private HashMap<String, Particular> Listas;
    private ArrayList<Lista> favListas;
    private ArrayList<Album> favAlbumes;
    private ArrayList<Tema> favTemas;
    private HashMap<String, Usuario> Siguiendo;
    
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public Cliente(String nickname, String contrasenia,String nombre, String apellido, String correo, Date fechaNac, String Imagen) {
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.correo = correo;
        this.Imagen = Imagen;
        this.Listas = new HashMap<>();
        this.favListas = new ArrayList<>();
        this.favAlbumes = new ArrayList<>();
        this.favTemas = new ArrayList<>();
        this.Siguiendo = new HashMap<>();
    }
    
    //Se usa para la carga de datos de prueba
    public Cliente(String nickname, String nombre, String apellido, String correo, String fechaNac, String Imagen) {
        try {
            Date fechaN = formato.parse(fechaNac);
            
            this.nickname = nickname;
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaNac = fechaN;
            this.correo = correo;
            this.Imagen = Imagen;
            this.Listas = new HashMap<>();
            this.favListas = new ArrayList<>();
            this.favAlbumes = new ArrayList<>();
            this.favTemas = new ArrayList<>();
            this.Siguiendo = new HashMap<>();
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNickname() {
        return nickname;
    }

    public String getImage() {
        return Imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public HashMap<String, Particular> getListas() {
        return Listas;
    }

    public void setListas(HashMap<String, Particular> Listas) {
        this.Listas = Listas;
    }

    public ArrayList<Lista> getFavListas() {
        return favListas;
    }
    
    public ArrayList<DtListaPD> getFavDtListasPD(){
        ArrayList<DtListaPD> retorno = new ArrayList();
        for (int i=0;i<favListas.size();i++){
            Lista x = favListas.get(i);
            if (x instanceof PorDefecto){
                PorDefecto p = (PorDefecto)x;
                DtListaPD dt = new DtListaPD(p.getNombre(),p.getGenero().getNombre());
                retorno.add(dt);
            }        
        }
        return retorno;
    }
    
    public ArrayList<DtListaP> getFavDtListasP(){
        ArrayList<DtListaP> retorno = new ArrayList();
        for (int i=0;i<favListas.size();i++){
            Lista x = favListas.get(i);
            if (x instanceof Particular){
                Particular p = (Particular)x;
                DtListaP dt = new DtListaP(p.getNombre(),p.getUsuario());
                retorno.add(dt);
            }        
        }
        return retorno;
    }
    
    public ArrayList<DtAlbum> getFavDtAlbumes(){
        ArrayList<DtAlbum> retorno = new ArrayList();
        for (int i=0;i<favAlbumes.size();i++){
            Album a = favAlbumes.get(i);
            DtAlbum dt = new DtAlbum(a.getNombre(),a.getArtista(),a.getAño());
            retorno.add(dt);
        }
        return retorno;
    }
    
    public ArrayList<DtTema> getFavDtTemas(){
        ArrayList<DtTema> retorno = new ArrayList();
        for (int i=0;i<favTemas.size();i++){
            Tema t = favTemas.get(i);
            DtTema dt = new DtTema(t.getNombre(),t.getNombrealbum(),t.getNombreartista());
            retorno.add(dt);
        }
        return retorno;
    }

    public void setFavListas(ArrayList<Lista> favListas) {
        this.favListas = favListas;
    }

    public ArrayList<Album> getFavAlbumes() {
        return favAlbumes;
    }

    public void setFavAlbumes(ArrayList<Album> favAlbumes) {
        this.favAlbumes = favAlbumes;
    }

    public ArrayList<Tema> getFavTemas() {
        return favTemas;
    }

    public void setFavTemas(ArrayList<Tema> favTemas) {
        this.favTemas = favTemas;
    }

    public HashMap<String, Usuario> getSiguiendo() {
        return Siguiendo;
    }

    public void setSiguiendo(HashMap<String, Usuario> Siguiendo) {
        this.Siguiendo = Siguiendo;
    }

    public void setFavAlbum(Album a) {
        this.favAlbumes.add(a);
    }

    public void setFavTema(Tema t) {
        this.favTemas.add(t);
    }

    public void setFavLista(Lista l) {
        this.favListas.add(l);
    }

    public void setLista(Particular p) {
        this.Listas.put(p.getNombre(), p);
    }

    public boolean setSiguiendo(Usuario u) {
        if (!this.Siguiendo.containsKey(u.getNickname())) {
            this.Siguiendo.put(u.getNickname(), u);
            return true;
        }
        return false;
    }

    public DtCliente getDatos() {
        ArrayList<DtListaP> listasCreadas = new ArrayList<>();
        ArrayList<DtUsuario> siguiendo = new ArrayList<>();
        ArrayList<DtAlbum> albumes = new ArrayList<>();
        ArrayList<DtTema> temas = new ArrayList<>();
        ArrayList<DtLista> listas = new ArrayList<>();

        for (Particular lista : this.Listas.values()) {
            listasCreadas.add(lista.getDatosResumidos());
        }

        for (Album album : this.favAlbumes) {
            albumes.add(album.getDatos());
        }

        for (Tema tema : this.favTemas) {
            temas.add(tema.getDatos());
        }

        for (Lista lista : this.favListas) {
            if (lista instanceof Particular) {
                listas.add(((Particular) lista).getDatosResumidos());
            } else {
                listas.add(((PorDefecto) lista).getDatosResumidos());
            }
        }

        for (Usuario usuario : this.Siguiendo.values()) {
            if (usuario instanceof Cliente) {
                siguiendo.add(((Cliente) usuario).getDatosResumidos());
            } else {
                siguiendo.add(((Artista) usuario).getDatosResumidos());
            }
        }
        
        //La imagen es opcinonal, verificar si una
        ImageIcon imagen = null;
        if(Imagen != null){
            File archivo = new File(Imagen);
            String Rutaimagen = archivo.getPath();

            imagen = new ImageIcon(Rutaimagen); //genera la imagen que seleccionamos
        }

        return new DtCliente(nickname, nombre, apellido, fechaNac, correo, imagen, siguiendo, listasCreadas, listas, temas, albumes);
    }

    public DtCliente getDatosResumidos() {
        return new DtCliente(nickname, nombre, apellido, fechaNac, correo, null, null, null, null, null, null);
    }

    public ArrayList<DtUsuario> buscarEnUsuarios(String palabra) {
        ArrayList<DtUsuario> retornar = new ArrayList<>();
        palabra = palabra.toUpperCase();
        Iterator iterador = this.Siguiendo.values().iterator();
        while (iterador.hasNext()) {
            Usuario aux = (Usuario) iterador.next();
            String nick = aux.getNickname().toUpperCase();
            String nombre = aux.getNombre().toUpperCase();
            String apellido = aux.getApellido().toUpperCase();
            String nomAp = aux.getNombre().toUpperCase() + aux.getApellido().toUpperCase();
            if (nick.contains(palabra) == true || nombre.contains(palabra) == true || apellido.contains(palabra) == true || nomAp.contains(palabra)) {
                retornar.add(aux.getDatos());
            }
        }
        return retornar;
    }

    public void dejarSeguir(String Nickname) {
        this.Siguiendo.remove(Nickname);
    }

    public void AddLista(Particular p) {
        this.Listas.put(p.getNombre(), p);
    }

    public ArrayList<DtListaP> ObtenerLista() {
        ArrayList<DtListaP> retorno = new ArrayList<DtListaP>();
        for (Particular lista : this.Listas.values()) {
            retorno.add(lista.getDatos(nickname));

        }
        return retorno;
    }
    
    public ArrayList<DtListaP> listarListasPrivadas(){
        ArrayList<DtListaP> listasPrivadas = new ArrayList<>();
        
        for (Particular lista : this.Listas.values()) {
            if(lista.isEsPrivado()){
                listasPrivadas.add(lista.getDatos(this.nickname));
            }
        }
        return listasPrivadas;
    }
    
    public void publicarLista(String nomLista){
        this.Listas.get(nomLista).setEsPrivado(false);
    }
}
