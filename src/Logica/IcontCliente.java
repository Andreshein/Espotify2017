/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Date;


public interface IcontCliente{
    abstract public boolean AltaDePerfil( String nick, String nombre, String apellido, String correo, String fecha);
    abstract public void AgregarArtista( String biografia, String link);
    abstract public void Corregir( String nick, String nombre, String apellido, String correo,Date fecha);
    abstract public void CorregirArt( String biografia, String link);
    abstract public void Cancelar();
    abstract public ArrayList<String> listarNickClientes();
    abstract public void verPerfilCliente( String nickname); //Dtcliente
    abstract public ArrayList<String> MostrarUsuariosSeguidos( String Nickname);
    abstract public void DejarSeguir( String NickCli, String NickUsu);
}
