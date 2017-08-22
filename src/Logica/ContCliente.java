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

    private Map<String, Cliente> clientes;
    private DBUsuario dbUsuario=null;
    private IcontArtista art;

    public static ContCliente getInstance() {
        if (instancia == null) {
            instancia = new ContCliente();
        }
        return instancia;
    }

private ContCliente(){
        
        this.clientes=new HashMap<>();
        this.dbUsuario=new DBUsuario();
        //this.art = Fabrica.getArtista();
    }
    public void SetContArtista(IcontArtista art){
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
    public boolean IngresarCliente(String nickname, String nombre, String apellido, String correo,Date fechaNac, String Img) {
        if (this.clientes.get(nickname)!=null){
            return false;
        }else{
            Cliente c = new Cliente(nickname, nombre, apellido, correo, fechaNac, Img);
           
            boolean tru =this.dbUsuario.agregarCliente(c);
            if (tru){
                
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
    public void CargadeDatos(){
        this.dbUsuario.CargarDatosdePrueba();
        this.art.CargarDatos();
        clientes = dbUsuario.cargarClientes();
        Map<Integer, Particular> ListaPar=new HashMap();
        Map<Integer, Tema> temas=new HashMap();
        Map<String, Artista> artistas=new HashMap();
        Map<Integer, PorDefecto> ListaPD=new HashMap();
        artistas = dbUsuario.cargarArtistas();
        temas = dbUsuario.cargarTema();
        ListaPar = dbUsuario.cargarListaP();
        ListaPD = dbUsuario.cargarListaPD();
        Particular lp1 = ListaPar.get(1);
        Particular lp2 = ListaPar.get(2);
        Particular lp3 = ListaPar.get(3);
        Particular lp4 = ListaPar.get(4);
        Particular lp5 = ListaPar.get(5);
        Particular lp6 = ListaPar.get(6);
        Cliente padrino = clientes.get("el_padrino");
        Cliente scar = clientes.get("scarlettO");
        Cliente Walt = clientes.get("Heisenberg");
        Cliente ml = clientes.get("lachiqui");
        Cliente cacho = clientes.get("cbochinche");
        Cliente pepe = clientes.get("ppArgento");
        Cliente obiwan = clientes.get("benKenobi");
        Cliente e11 = clientes.get("Eleven11");
        padrino.AddLista(lp1); //Agregar listas a los clientes
        scar.AddLista(lp2);
        Walt.AddLista(lp3);
        ml.AddLista(lp4);
        cacho.AddLista(lp5);
        cacho.AddLista(lp6);
        lp1.setCliente(padrino); //Fijar un cliente a una lista
        lp2.setCliente(scar);
        lp3.setCliente(Walt);
        lp4.setCliente(ml);
        lp5.setCliente(cacho);
        lp6.setCliente(cacho);
        Tema t1 = temas.get(1); 
        Tema t2 = temas.get(2);
        Tema t3 = temas.get(3);
        Tema t4 = temas.get(4);
        Tema t5 = temas.get(5);
        Tema t6 = temas.get(6);
        Tema t7 = temas.get(7);
        Tema t8 = temas.get(8);
        Tema t9 = temas.get(9);
        Tema t11 = temas.get(11);
        Tema t12 = temas.get(12);
        Tema t13 = temas.get(13);
        Tema t15 = temas.get(15);
        Tema t16 = temas.get(16);
        Tema t17 = temas.get(17);
        Tema t18 = temas.get(18);
        Tema t19 = temas.get(19);
        Tema t20 = temas.get(20);
        lp1.AddTema(t15); //Agregar temas a las listas
        lp1.AddTema(t16);
        lp1.AddTema(t4);
        lp2.AddTema(t6);
        lp2.AddTema(t7);
        lp2.AddTema(t11);
        lp2.AddTema(t15);
        lp3.AddTema(t4);
        lp3.AddTema(t5);
        lp3.AddTema(t8);
        lp3.AddTema(t9);
        lp4.AddTema(t6);
        lp4.AddTema(t11);
        lp4.AddTema(t16);
        lp4.AddTema(t17);
        lp4.AddTema(t19);
        lp5.AddTema(t1);
        lp5.AddTema(t2);
        lp5.AddTema(t3);
        lp5.AddTema(t9);
        lp5.AddTema(t20);
        lp6.AddTema(t12);
        lp6.AddTema(t6);
        lp6.AddTema(t18);
        Artista vp = artistas.get("vpeople");
        Artista dm = artistas.get("dmode");
        Artista cl = artistas.get("clauper");
        Artista bs = artistas.get("bruceTheBoss");
        Artista tn = artistas.get("tripleNelson");
        Artista ll = artistas.get("la_ley");
        Artista tj = artistas.get("tigerOfWales");
        Artista pt = artistas.get("chaiko");
        Artista nn = artistas.get("nicoleneu");
        Artista pi = artistas.get("lospimpi");
        Artista dy = artistas.get("dyangounchained");
        Artista al = artistas.get("alcides");
        padrino.setSiguiendo(vp); //Agregar clientes y artistas seguidos a un cliente seguidor
        padrino.setSiguiendo(dm);
        padrino.setSiguiendo(cl);
        padrino.setSiguiendo(obiwan);
        padrino.setSiguiendo(ml);
        padrino.setSiguiendo(cacho);
        padrino.setSiguiendo(e11);
        scar.setSiguiendo(bs);
        scar.setSiguiendo(tj);
        scar.setSiguiendo(tn);
        scar.setSiguiendo(dm);
        scar.setSiguiendo(Walt);
        scar.setSiguiendo(obiwan);
        scar.setSiguiendo(ml);
        pepe.setSiguiendo(dm);
        pepe.setSiguiendo(bs);
        pepe.setSiguiendo(tn);
        pepe.setSiguiendo(obiwan);
        pepe.setSiguiendo(ml);
        pepe.setSiguiendo(cacho);
        pepe.setSiguiendo(e11);
        Walt.setSiguiendo(bs);
        Walt.setSiguiendo(tj);
        Walt.setSiguiendo(tn);
        Walt.setSiguiendo(pi);
        Walt.setSiguiendo(dy);
        Walt.setSiguiendo(al);
        Walt.setSiguiendo(dm);
        Walt.setSiguiendo(padrino);
        Walt.setSiguiendo(scar);
        Walt.setSiguiendo(pepe);
        Walt.setSiguiendo(obiwan);
        Walt.setSiguiendo(ml);
        Walt.setSiguiendo(e11);
        obiwan.setSiguiendo(ll);
        obiwan.setSiguiendo(pt);
        obiwan.setSiguiendo(nn);
        obiwan.setSiguiendo(pi);
        obiwan.setSiguiendo(al);
        obiwan.setSiguiendo(dm);
        obiwan.setSiguiendo(bs);
        obiwan.setSiguiendo(padrino);
        obiwan.setSiguiendo(pepe);
        obiwan.setSiguiendo(ml);
        obiwan.setSiguiendo(cacho);
        obiwan.setSiguiendo(e11);
        ml.setSiguiendo(bs);
        ml.setSiguiendo(ll);
        ml.setSiguiendo(pi);
        ml.setSiguiendo(al);
        ml.setSiguiendo(padrino);
        ml.setSiguiendo(scar);
        ml.setSiguiendo(pepe);
        cacho.setSiguiendo(ll);
        cacho.setSiguiendo(pi);
        cacho.setSiguiendo(dy);
        cacho.setSiguiendo(al);
        cacho.setSiguiendo(pepe);
        e11.setSiguiendo(ll);
        e11.setSiguiendo(padrino);
        e11.setSiguiendo(scar);
        e11.setSiguiendo(pepe);
        PorDefecto lpd1 = ListaPD.get(1);
        PorDefecto lpd2 = ListaPD.get(2);
        PorDefecto lpd3 = ListaPD.get(3);
        Map<Integer, Album> albumes=new HashMap();
        albumes = dbUsuario.cargarAlbumes();
        Album album2 = albumes.get(2);
        Album album8 = albumes.get(8);
        Album album9 = albumes.get(9);
        Album album11 = albumes.get(11);
        Walt.setFavLista(lp1); //Agregar listas a favoritos
        padrino.setFavLista(lpd1);
        padrino.setFavLista(lpd3);
        scar.setFavLista(lpd3);
        pepe.setFavLista(lpd1);
        pepe.setFavLista(lpd2);
        cacho.setFavLista(lpd1);
        cacho.setFavLista(lpd2);
        padrino.setFavTema(t13); //Agregar temas a favoritos
        pepe.setFavTema(t12);
        cacho.setFavTema(t16);
        e11.setFavTema(t17);
        padrino.setFavAlbum(album2); //Agregar albumes a favoritos
        padrino.setFavAlbum(album8);
        padrino.setFavAlbum(album9);
        obiwan.setFavAlbum(album9);
        obiwan.setFavAlbum(album8);
        cacho.setFavAlbum(album11);
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
    
    public ArrayList<DtListaP> ListarListaP(){
        ArrayList<DtListaP> devolver= new ArrayList<DtListaP>();
        Set set = clientes.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mentry =(Map.Entry)iterator.next();
            Cliente aux=(Cliente) mentry.getValue();
            devolver.addAll(aux.ObtenerLista());
            
        }
        return devolver;
    }
    public ArrayList<DtListaPD> ListarListaPD(){
        return this.art.ListarListaPD();
    
    }
    

   
    
}
