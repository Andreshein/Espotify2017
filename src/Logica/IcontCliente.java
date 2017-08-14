/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Date;


public interface IcontCliente{
    public abstract boolean IngresarCliente(String nickname, String nombre, String apellido, Date fechaNac,String correo);
    public abstract boolean AltaDePerfil( String nick, String nombre, String apellido,DtDate fechaNac ,String correo);
    public abstract void AgregarArtista( String biografia, String link);
    public abstract void Corregir( String nick, String nombre, String apellido, String correo,Date fecha);
    public abstract void CorregirArt( String biografia, String link);
    public abstract void Cancelar();
    public abstract ArrayList<String> listarNickClientes();
    public abstract void verPerfilCliente( String nickname); //Dtcliente
    public abstract ArrayList<String> MostrarUsuariosSeguidos( String Nickname);
    public abstract void DejarSeguir( String NickCli, String NickUsu);
}
//hellou papaguena