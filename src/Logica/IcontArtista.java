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
public interface IcontArtista {
    
    abstract public boolean SelectArtista(String nick);
    abstract public void CrearAlbum(String nombre,int anio);
    abstract public void ElegirGenero(String nombre);
    abstract public void AgregarTema(String nombre,String duracion,int ubicacion,String url_mp3);
    abstract public void ConfirmarAlbum();
    abstract public void ElegirArtista(String nomArtista); //:DtArtista
    abstract public void ListarArtistas(); //Set(DtArtista);
    abstract public void obtenerGenero(); //set(DtGenero);
    abstract public void obtenerArtista(); //set(DtArtista);
    abstract public void seleccionarAlbum(String nick,String nombre);
    abstract public void mostrarAlbum(); //DtAlbum
}
