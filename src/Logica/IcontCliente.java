/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;


public interface IcontCliente{
    public abstract ArrayList<DtListaPD> ListarListaPD(); 
    public abstract boolean IngresarCliente(String nickname, String contrasenia, String nombre, String apellido,String correo, Date fechaNac, String img);
    public abstract boolean IngresarCliente(DtCliente cli, byte[] imagen);
    public abstract ArrayList<DtListaP> ListarListaP();
    public abstract ArrayList<String> listarNickClientes();
    public abstract DtCliente verPerfilCliente( String nickname); //Dtcliente
    public abstract void seguir(String nickCli, String nickUsu) throws Exception;
    public abstract void confirmar() throws Exception;
    public abstract void DejarSeguir(String NickCli, String NickUsu);
    public abstract ArrayList<DtCliente> BuscarClientes(String palabra);
    public abstract List<DtCliente> BuscarClientesFav(String palabra);
    public abstract ArrayList<DtUsuario> BuscarUsuarios(String palabra);
    public abstract ArrayList<DtUsuario> BuscarUsuariosSeg(String Nickname, String palabra);
    public abstract void CargadeDatos();
    public abstract void SetContArtista(IcontArtista art);
    public abstract ArrayList<DtGenero> ListarGeneros(String palabra);
    public abstract ArrayList<DtCliente> getSeguidores(String nickname);
    public abstract void setClientes(HashMap<String,Cliente> clientes);
    public abstract void setCA(IcontArtista art);
    public abstract DtGenero listarGArbol();
    public abstract void crearListaP(String nickname, String nombre, String imagen);
    public abstract void crearListaPD(String genero, String nombre, String imagen);
    public abstract void publicarLista(String nickname, String nomLista);
    public abstract ArrayList<DtTema> listarTemasListaP(String nickname,String listaP);
    public abstract ArrayList<DtListaP> listarTodasListasP();
    public abstract boolean InsertarFavorito(String cliente, String[] elementos, int tipo);
    public abstract void EliminarFavorito(String cliente, String[] elemento, int tipo);
    public abstract ArrayList<DtListaP> listarListasPrivadas(String nickname);
    public abstract boolean verificarDatos(String nickname, String correo);
    public abstract Cliente BuscarUsuariosC(String nickname);
    public abstract boolean copiarArchivo(String rutaOrigenArchivo, String rutaDestino);
    public abstract boolean ClientesVacio();
    public abstract void addSuscripcion (TipoSuscripcion ts);
    public abstract DtUsuario verificarLoginCliente(String nickname,String contrasenia);
    public abstract boolean agregarTemaFavorito (String nickname, String artista, String album, String tema);
    public abstract boolean agregarAlbumFavorito (String nickname, String artista, String album);
    public abstract boolean agregarListaFavorito (String nickname, String cliente, String lista);
    public abstract boolean agregarListaFavorito (String nickname, String lista);
    public abstract ArrayList<DtTipoSuscripcion> listarTipoDeSus();
    public abstract ArrayList<DtSuscripcion> getSuscripCliente(String nickname);
    public abstract boolean SuscripcionVigente(String nickname);
    public abstract boolean contratarSuscripcion(String nickname, int idTipoSus);
    public abstract BufferedImage cargarImagen(String rutaImagen);
    public abstract void actualizarVigenciaSuscripciones(String nickname);
    public abstract boolean estaCliente(String nickname,String correo); 
    public abstract List<DtCliente> BuscarCliente2(String nickname,String correo);
    public abstract void CambiarEstadoSuscripcion(DtSuscripcion suscripcion);
    public abstract ArrayList<DtTema> reproducirListaP(String cliente, String lista);
    public abstract ArrayList<DtTema> resultadosT(String palabra);
    public abstract ArrayList<DtAlbum> resultadosA(String palabra);
    public abstract ArrayList<DtLista> resultadosL(String palabra);
    
    //Funciones web
    public abstract void crearListaPWeb(String nickname, String nombre, byte[] imagen);
}
//hellou papaguena
