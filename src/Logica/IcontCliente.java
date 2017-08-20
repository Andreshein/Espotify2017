/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;


public interface IcontCliente{

    public abstract boolean IngresarCliente(String nickname, String nombre, String apellido,String correo, Date fechaNac, String img);
    public abstract boolean AltaDePerfil(String nickname,String nombre,String apellido,String correo,Date fechaNac,ImageIcon imagen);
    public abstract void AgregarArtista( String biografia, String link);
    public abstract void Corregir( String nick, String nombre, String apellido, String correo,Date fecha);
    public abstract void CorregirArt( String biografia, String link);
    public abstract void Cancelar();
    public abstract ArrayList<String> listarNickClientes();
    public abstract DtCliente verPerfilCliente( String nickname); //Dtcliente
    public abstract ArrayList<String> MostrarUsuariosSeguidos( String Nickname);
    public abstract void SeleccionarCliente(String nickname);
    public abstract ArrayList<DtUsuario> listarUsuarios();
    public abstract void seguir(String nickCli, String nickUsu);
    public abstract void crearListaRP(String nickname,String nombre,ImageIcon imagen);
    public abstract void crearListaRD(String genero,String nombre,ImageIcon imagen);
    public abstract void confirmar();
    public abstract void DejarSeguir(String NickCli, String NickUsu);
    public abstract ArrayList<DtCliente> BuscarClientes(String palabra);
    public abstract ArrayList<DtUsuario> BuscarUsuarios(String palabra);
    public abstract ArrayList<DtUsuario> BuscarUsuariosSeg(String Nickname, String palabra);
    public abstract void CargadeDatos();
}
//hellou papaguena
