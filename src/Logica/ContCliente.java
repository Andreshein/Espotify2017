/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import Persistencia.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;

public class ContCliente implements IcontCliente {

    private static ContCliente instancia;

    private HashMap<String, Cliente> clientes;
    private DBUsuario dbUsuario = null;
    private IcontArtista art;

    public static ContCliente getInstance() {
        if (instancia == null) {
            instancia = new ContCliente();
        }
        return instancia;
    }
    private ContCliente() {
        this.clientes = new HashMap<>();
        this.dbUsuario = new DBUsuario();
    }

    @Override
    public boolean AltaDePerfil(String nickname, String nombre, String apellido, String correo, Date fechaNac, ImageIcon imagen) {
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
        ArrayList<String> listaNicknames = new ArrayList<>();

        for (Cliente cliente : this.clientes.values()) {
            listaNicknames.add(cliente.getNickname());
        }

        return listaNicknames;
    }

    @Override
    public DtCliente verPerfilCliente(String nickname) {        
        return this.clientes.get(nickname).getDatos();
    }

    @Override
    public ArrayList<String> MostrarUsuariosSeguidos(String Nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DejarSeguir(String NickCli, String NickUsu) {
        Cliente cli = (Cliente) this.clientes.get(NickCli);
        cli.dejarSeguir(NickUsu);
    }

    @Override
    public void SeleccionarCliente(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<DtUsuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaRP(String nickname, String nombre, ImageIcon imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaRD(String genero, String nombre, ImageIcon imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void confirmar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean IngresarCliente(String nickname, String nombre, String apellido, String correo, Date fechaNac) {
        if (this.clientes.get(nickname) != null) {
            return false;
        } else {
            Cliente c = new Cliente(nickname, nombre, apellido, correo, fechaNac);

            boolean tru = this.dbUsuario.agregarCliente(c);
            if (tru) {

                this.clientes.put(nickname, c);
            }
            return tru;

        }
    }

    public ArrayList<DtCliente> BuscarClientes(String palabra) {
        ArrayList<DtCliente> retornar = new ArrayList<>();
        Iterator iterador = this.clientes.values().iterator();
        while (iterador.hasNext()) {
            Cliente aux = (Cliente) iterador.next();
            if (aux.getNickname().contains(palabra) == true || aux.getNombre().contains(palabra) == true || aux.getApellido().contains(palabra) == true) {
                retornar.add(aux.getDatos());
            }
        }
        return retornar;
    }

    public ArrayList<DtUsuario> BuscarUsuarios(String palabra) {
        ArrayList<DtUsuario> retornar = this.art.BuscarUsuarios(palabra);
        Iterator iterador = this.clientes.values().iterator();
        while (iterador.hasNext()) {
            Cliente aux = (Cliente) iterador.next();
            if (aux.getNickname().contains(palabra) == true || aux.getNombre().contains(palabra) == true || aux.getApellido().contains(palabra) == true) {
                retornar.add(aux.getDatos());
        }}
        return retornar;
    }

    public void seguir(String nickCli, String nickUsu) {
        Cliente cli = (Cliente) this.clientes.get(nickCli);
        cli.setSiguiendo(this.seleccionarUsuario(nickUsu));
    }

    public Usuario seleccionarUsuario(String Nickname) {
        Usuario u = this.art.seleccionarUsuario(Nickname);
        if (u == null) {
            u = this.clientes.get(Nickname);
        }
        return u;
    }

    public ArrayList<DtUsuario> BuscarUsuariosSeg(String Nickname, String palabra) {
        Cliente cli = (Cliente) this.clientes.get(Nickname);
        return cli.buscarEnUsuarios(palabra);
    }
    
    public ArrayList<DtCliente> getSeguidores(String nickname){
        ArrayList<DtCliente> seguidores = new ArrayList<>();
        
        for (Cliente cliente : this.clientes.values()) {
            // Busca si el nickname esta en la lista de usuarios seguidos de cada cliente
            if(cliente.getSiguiendo().containsKey(nickname)){
                seguidores.add(cliente.getDatosResumidos());
            }
        }
        
        return seguidores;
    }

    public ArrayList<DtGenero> ListarGeneros(String palabra) {
        ArrayList<DtGenero> ret;
        return null;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setCA(IcontArtista art) {
         this.art=art;
    }
    
    public ArrayList<Particular> ListarListaP(){
        List<DtListaP> devolver= new ArrayList<DtListaP>();
        Set set = clientes.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mentry =(Map.Entry)iterator.next();
            Cliente aux=(Cliente) mentry.getValue();
            Set set2 = aux.getListas().entrySet();
            Iterator iterator2 = set2.iterator();
            while(iterator2.hasNext()){
                Map.Entry mentry2 =(Map.Entry)iterator2.next();
                Particular auxl=(Particular) mentry2.getValue();                
                devolver.add(auxl.getDtListaP());
            }
            
        }
        return (ArrayList)devolver;
    }
    

   
    
}
