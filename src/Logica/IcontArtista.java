/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;

/**
 *
 * @author ninoh
 */
public interface IcontArtista {
    
    public abstract boolean IngresarArtista(String nickname, String nombre, String apellido, DtDate fechaNac,String correo, String biografia, String paginaWeb);
    public abstract boolean SelectArtista(String nick);
    public abstract void CrearAlbum(String nombre,int anio);
    public abstract void ElegirGenero(String nombre);
    public abstract void AgregarTema(String nombre,String duracion,int ubicacion,String url_mp3);
    public abstract void ConfirmarAlbum();
    public abstract void ElegirArtista(String nomArtista); //:DtArtista
    public abstract void ListarArtistas(); //Set(DtArtista);
    public abstract void obtenerGenero(); //set(DtGenero);
    public abstract void obtenerArtista(); //set(DtArtista);
    public abstract void seleccionarAlbum(String nick,String nombre);
    public abstract void mostrarAlbum(); //DtAlbum
}
