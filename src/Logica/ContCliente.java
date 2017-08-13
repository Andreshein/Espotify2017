/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import Persistencia.*;


public class ContCliente implements IcontCliente{
    private static ContCliente instancia;

    private Map<String, Cliente> clientes;
    private DBUsuario dbUsuario=null;

    public static ContCliente getInstance(){
        if (instancia == null){
            instancia = new ContCliente();
        }
        return instancia;
    }

private ContCliente(){
      
        this.clientes=new HashMap<>();
        this.dbUsuario=new DBUsuario();
    }

    @Override
    public boolean AltaDePerfil(String nick, String nombre, String apellido, DtDate fechaNac, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AgregarArtista(String biografia, String link) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Corregir(String nick, String nombre, String apellido, String correo, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CorregirArt(String biografia, String link) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> listarNickClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verPerfilCliente(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> MostrarUsuariosSeguidos(String Nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DejarSeguir(String NickCli, String NickUsu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void IngresarCliente(String text, String text0, String text1, DtDate dtDate, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}

