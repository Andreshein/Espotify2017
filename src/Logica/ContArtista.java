/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Map;
import Persistencia.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ImageIcon;

public class ContArtista implements IcontArtista {

    private static ContArtista instancia;

    private HashMap<String, Artista> artistas;
    private HashMap<String, Genero> generos;
    private DBUsuario dbUsuario = null;

    public static ContArtista getInstance() {
        if (instancia == null) {
            instancia = new ContArtista();
        }
        return instancia;
    }

    private ContArtista() {

        this.artistas = new HashMap<>();
        this.dbUsuario = new DBUsuario();
    }

    @Override
    public boolean SelectArtista(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CrearAlbum(String nombre, int anio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ElegirGenero(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ConfirmarAlbum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtArtista ElegirArtista(String nomArtista) {
        Artista a = (Artista) this.artistas.get(nomArtista);
        return a.getDatos();
    }

    @Override
    public ArrayList<DtArtista> ListarArtistas() {
        System.out.println("ContArtistaDatos:");
        System.out.println(this.artistas);
        System.out.println("Fin:");
        ArrayList<DtArtista> a = new ArrayList<>();
        Iterator iterador = this.artistas.values().iterator();
        while (iterador.hasNext()) {
            Artista aux = (Artista) iterador.next();
            a.add(aux.getDatos());
        }
        return a;

    }

    @Override
    public ArrayList<DtGenero> obtenerGenero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtArtista> obtenerArtista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarAlbum(String nick, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtAlbum mostrarAlbum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LiberarMemoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Genero buscar(Genero nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void corregir(String nickname, String nombre, String apellido, String correo, Date fechaNac, ImageIcon imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean IngresarArtista(String nickname, String nombre, String apellido, String correo, Date fechaNac, String biografia, String paginaWeb) {
        if (this.artistas.get(nickname) != null) {
            return false;
        } else {
            Artista a = new Artista(nickname, nombre, apellido, correo, fechaNac, biografia, paginaWeb);
            boolean tru = this.dbUsuario.agregarArtista(a);
            if (tru) {

                this.artistas.put(nickname, a);
            }
            return tru;
        }

    }

    @Override
    public void AgregarTema(String nombre, String duracion, int ubicacion, String url_mp3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Artista buscarArtista(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

    public ArrayList<DtUsuario> BuscarUsuarios(String palabra) {
        ArrayList<DtUsuario> retornar = new ArrayList<>();
        Iterator iterador = this.artistas.values().iterator();
        while (iterador.hasNext()) {
            Artista aux = (Artista) iterador.next();
            if (aux.getNickname().contains(palabra) == true || aux.getNombre().contains(palabra) == true || aux.getApellido().contains(palabra) == true) {
                retornar.add(aux.getDatos());
            }
        }
        return retornar;
    }

    public Usuario seleccionarUsuario(String Nickname) {
        return (Usuario) this.artistas.get(Nickname);
    }

    public ArrayList<DtAlbum> ListarAlbumes() {
        ArrayList<DtAlbum> a = new ArrayList<>();
        Iterator iterador = this.artistas.values().iterator();
        while (iterador.hasNext()) {
            Artista aux = (Artista) iterador.next();
            Iterator iterador2 = aux.getAlbumes().values().iterator();
            while (iterador2.hasNext()) {
                Album al = (Album)iterador2.next();
                a.add(al.getDatos());
            }
        }
        return a;
    }
    
    private ArrayList<DtGenero> buscaHijos(String nombre){
        ArrayList<DtGenero> a = new ArrayList<>();
        Iterator it = this.generos.values().iterator();
        while(it.hasNext()){
            Genero g = (Genero)it.next();
            if(g.getPadre().getNombre().equals(nombre)){
                DtGenero dtg = g.getDatos(this.buscaHijos(g.getNombre()));
                a.add(dtg);
            }
        }
        return a;
    }

    public void setArtista(HashMap<String, Artista> artistas) {
        this.artistas = artistas;
    }

    public void setGenero(HashMap<String, Genero> generos) {
        this.generos = generos;
    }
    
}
