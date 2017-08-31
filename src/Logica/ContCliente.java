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
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class ContCliente implements IcontCliente {

    private static ContCliente instancia;

    private Map<String, Cliente> clientes;
    private DBUsuario dbUsuario = null;
    private IcontArtista art;
    private Lista lista;
    private Genero genero;
    private Cliente cliente;

    public static ContCliente getInstance() {
        if (instancia == null) {
            instancia = new ContCliente();
        }
        return instancia;
    }

    private ContCliente() {

        this.clientes = new HashMap<>();
        this.dbUsuario = new DBUsuario();
        //this.art = Fabrica.getArtista()
        this.lista = null;
        this.genero = null;
        this.cliente = null;
    }

    public void SetContArtista(IcontArtista art) {
        this.art = art;
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
        this.dbUsuario.DejarSeguirUsu(NickCli, this.seleccionarUsuario(NickUsu));
    }

    @Override
    public void SeleccionarCliente(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<DtUsuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void confirmar() throws Exception {
        if (this.lista instanceof Particular) {
            Particular p = (Particular) this.lista;
            if (!this.cliente.getListas().containsKey(p.getNombre())) {
                p.setUsuario(this.cliente.getNickname());
                this.cliente.AddLista(p);
                p.setId(this.dbUsuario.insertarlista(p));
            } else {
                throw new Exception("El cliente ya tiene una lista con ese nombre");
            }
        } else {
            PorDefecto pd = (PorDefecto) this.lista;
            if (!this.genero.getListas().containsKey(pd.getNombre())) {
                pd.setGenero(this.genero);
                this.genero.AddLista(pd);
                pd.setId(this.dbUsuario.insertarlista(pd));
            } else {
                throw new Exception("El genero ya tiene una lista con ese nombre");
            }
        }
    }

    @Override
    public boolean IngresarCliente(String nickname, String nombre, String apellido, String correo, Date fechaNac, String Img) {
        if (this.clientes.get(nickname) != null) {
            return false;
        } else {
            Cliente c = new Cliente(nickname, nombre, apellido, correo, fechaNac, Img);

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
        if (palabra.equals("") == false) {
            while (iterador.hasNext()) {
                Cliente aux = (Cliente) iterador.next();

                // toUpperCase convierte todas las letras del string en mayusculas para buscar mejor
                palabra = palabra.toUpperCase();
                String nick = aux.getNickname().toUpperCase();
                String nombre = aux.getNombre().toUpperCase();
                String apellido = aux.getApellido().toUpperCase();
                String nomAp = aux.getNombre().toUpperCase() + aux.getApellido().toUpperCase();

                if (nick.contains(palabra) == true || nombre.contains(palabra) == true || apellido.contains(palabra) == true || nomAp.contains(palabra) == true) {
                    retornar.add(aux.getDatos());
                }
            }
        } else {
            System.out.println("Logica.ContCliente.BuscarClientes() -> palabra vacia");
            for (Cliente cliente : this.clientes.values()) {
                retornar.add(cliente.getDatosResumidos());
            }
        }

        return retornar;
    }

    public ArrayList<DtUsuario> BuscarUsuarios(String palabra) {
        ArrayList<DtUsuario> retornar = this.art.BuscarUsuarios(palabra);
        retornar.addAll(this.BuscarClientes(palabra));
        return retornar;
    }

    public void seguir(String nickCli, String nickUsu) throws Exception {
        Cliente cli = (Cliente) this.clientes.get(nickCli);
        boolean control = cli.setSiguiendo(this.seleccionarUsuario(nickUsu));
        if (control) {
            this.dbUsuario.SeguirUsu(nickCli, this.seleccionarUsuario(nickUsu));
        }else{
        throw new Exception("El cliente ya esta siendo seguigo");
        }
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

    public void CargadeDatos() {
        this.dbUsuario.CargarDatosdePrueba();
        Fabrica.cargarDatos();
    }

    public ArrayList<DtCliente> getSeguidores(String nickname) {
        ArrayList<DtCliente> seguidores = new ArrayList<>();

        for (Cliente cliente : this.clientes.values()) {
            // Busca si el nickname esta en la lista de usuarios seguidos de cada cliente
            if (cliente.getSiguiendo().containsKey(nickname)) {
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
        this.art = art;
    }

    public ArrayList<DtListaP> ListarListaP() {
        ArrayList<DtListaP> devolver = new ArrayList<DtListaP>();
        Set set = clientes.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Cliente aux = (Cliente) mentry.getValue();
            devolver.addAll(aux.ObtenerLista());

        }
        return devolver;
    }

    public ArrayList<DtListaPD> ListarListaPD() {
        return this.art.ListarListaPD();

    }

    public DtGenero listarGArbol() {
        return this.art.listarGArbol();
    }

    public void crearListaP(String Nickname, String nombre, ImageIcon imagen) {
        this.cliente = this.clientes.get(Nickname);
        this.lista = new Particular(0, "x", nombre, false);
    }

    public void crearListaPD(String Genero, String nombre, ImageIcon imagen) {
        Genero g = null;
        this.genero = this.art.getGenero(Genero);
        this.lista = new PorDefecto(0, g, nombre);
    }

    
    public void publicarLista(String nickname, String nomLista){
        this.clientes.get(nickname).publicarLista(nomLista);
    }
    
    @Override
    public ArrayList<DtTema> listarTemasListaP(String nickname,String listaP){
	Cliente cli=(Cliente) this.clientes.get(nickname);
        Particular p=cli.getListas().get(listaP);
        return p.getDtTemas();
    }
}
