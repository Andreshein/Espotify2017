/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author ninoh
 */
public interface IcontArtista {
  
    public abstract boolean IngresarArtista(String nickname, String nombre, String apellido,String correo, Date fechaNac, String biografia, String paginaWeb, String img);
    public abstract boolean SelectArtista(String nick);
    public abstract void CrearAlbum(String nombre,int anio);
    public abstract void ElegirGenero(String nombre);
    public abstract void AgregarTema(String nombre,String duracion,int ubicacion,String url_mp3);
    public abstract void ConfirmarAlbum();
    public abstract DtArtista ElegirArtista(String nomArtista);
    public abstract ArrayList<DtArtista> ListarArtistas(); 
//    public abstract ArrayList<DtArtista> obtenerArtista();
//    public abstract ArrayList<DtGenero> obtenerGenero(); //set(DtGenero);
    public abstract ArrayList<DtAlbum> BuscarGenero(String palabra);
    public abstract ArrayList<DtAlbum> BuscarArtista(String palabra);
    public abstract void seleccionarAlbum(String nick,String nombre);
    public abstract DtAlbum mostrarAlbum(); //DtAlbum
    public abstract Artista buscarArtista(String nickname);
    public abstract void LiberarMemoria();
    public abstract Genero buscar(Genero nombre);
    public abstract void corregir(String nickname,String nombre,String apellido,String correo,Date fechaNac,ImageIcon imagen);
    public abstract ArrayList<DtUsuario> BuscarUsuarios(String palabra);
    public abstract Usuario seleccionarUsuario(String Nickname);
    public abstract void CargarDatos();
    public abstract void SetContCliente(IcontCliente cli);
    public abstract List<DtArtista> BuscarArtistas(String nombre);
    public abstract ArrayList<DtAlbum> ListarAlbumes();
    public abstract void setArtista(HashMap<String,Artista> artistas);
    public abstract void setGenero(HashMap<String,Genero> generos);
    public abstract Map<String, Genero> GetGeneros();


}
