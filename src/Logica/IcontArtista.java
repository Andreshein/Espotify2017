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

    public abstract ArrayList<DtListaPD> ListarListaPD();

    public abstract boolean IngresarArtista(String nickname, String nombre, String apellido, String correo, Date fechaNac, String biografia, String paginaWeb, String img);

    public abstract boolean SelectArtista(String nick);

    public abstract void CrearAlbum(String nombre, int anio);

    public abstract void ElegirGenero(String nombre);

    public abstract void AgregarTema(String nombre, String duracion, int ubicacion, String url_mp3);

    public abstract void ConfirmarAlbum();

    public abstract DtArtista ElegirArtista(String nomArtista);

    public abstract ArrayList<DtArtista> ListarArtistas();
//    public abstract ArrayList<DtGenero> obtenerGenero(); //set(DtGenero);
//    public abstract ArrayList<DtAlbum> BuscarGenero(String palabra);
    public abstract ArrayList<String> BuscarGenero(String palabra);
    public abstract ArrayList<DtAlbum> listarAlbumGenero(String genero);
    public abstract ArrayList<DtArtista> BuscarArtista(String palabra);
    public abstract boolean descargarArchivo(String rutaArchivo, String carpetaDestino, String nickArtista, String nomTema);
    public abstract ArrayList <DtTema> obtenerTema (String artista, String album);
    public abstract void seleccionarAlbum(String nick,String nombre);
    public abstract DtAlbum mostrarAlbum(); //DtAlbum

    public abstract Artista buscarArtista(String nickname);

    public abstract void LiberarMemoria();

    public abstract void corregir(String nickname, String nombre, String apellido, String correo, Date fechaNac, ImageIcon imagen);

    public abstract ArrayList<DtUsuario> BuscarUsuarios(String palabra);

    public abstract Usuario seleccionarUsuario(String Nickname);
//    public abstract void CargarDatos();

    public abstract void SetContCliente(IcontCliente cli);

    public abstract List<DtArtista> BuscarArtistas(String nombre);
    public abstract void setArtista(HashMap<String,Artista> artistas);
    public abstract void setGenero(HashMap<String,Genero> generos);
    public abstract void setListasPD(HashMap<String, PorDefecto> lpd);
    public abstract Map<String, DtGenero> GetDataGeneros();


    public abstract Map<String, Genero> GetGeneros();

    public abstract Map<String, Artista> GetArtistas();
    public abstract Map<String, PorDefecto> GetListasPD();
    public abstract void IngresarAlbum(String nomartista, String anio, String nombre, String imagen, HashMap<String, DtTema> temas, HashMap<String, DtGenero> generos);
    public abstract ArrayList<DtAlbum> listarTodosAlbumes();
    public abstract ArrayList<DtTema> listarTodosTemas();

    public abstract ArrayList<DtAlbum> ListarAlbum();

    public abstract ArrayList<DtAlbum> listarAlbumesArtista(String nick);

    public abstract ArrayList<DtCliente> listarSeguidores(String nick);

    public abstract DtGenero listarGArbol();

    public abstract Genero getGenero(String nombre);

    public abstract ArrayList<DtTema> listarTemasListaPD(String listaPD, String nombreG);

    public abstract ArrayList<DtTema> listarTemasListaA(String nickname, String nombre);

    public abstract ArrayList<DtGenero> listarGeneros(String nombreG);

    public abstract boolean verificarDatos(String nickname, String correo);

    //public abstract Artista BuscarUsuariosA(String nickname);
    public abstract void AgregarTemaListaG(String nickname, String Album, String Tema, String Genero, String Lista) throws Exception;

    public abstract void AgregarTemaListaC(String nickname, String Album, String Tema, String Cliente, String Lista) throws Exception;

    public abstract void BorrarTemaListaG(String nickname, String Album, String Tema, String Genero, String Lista) throws Exception;

    public abstract void BorrarTemaListaC(String nickname, String Album, String Tema, String Cliente, String Lista) throws Exception;
    
    public abstract void CrearGenero(String nombre, String padre) throws Exception;

}
