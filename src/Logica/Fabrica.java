/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.DBUsuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ninoh
 */
public class Fabrica {

    //SINGLETON
    private static Fabrica instancia;
    private static IcontArtista Artista;
    private static IcontCliente Cliente;

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;

    }

    public static IcontArtista getArtista() {
        Artista = ContArtista.getInstance();
        return Artista;
    }

    public static IcontCliente getCliente() {
        Cliente = ContCliente.getInstance();
        return Cliente;
    }

    public static void SetControladores() {
        Cliente.SetContArtista(Artista);
        Artista.SetContCliente(Cliente);
    }

    private Fabrica() {
        this.getArtista();
        this.getCliente();
        Cliente.SetContArtista(Artista);
        Artista.SetContCliente(Cliente);
        this.cargarDatos();
    }

    public static void cargarDatos() {
        DBUsuario db = new DBUsuario();
        Map<String, Cliente> clientes = db.cargarClientes();
        Map<String, Genero> generos = db.cargarGenero();
        Map<String, Artista> artistas = db.cargarArtistas();

        for (Genero g : generos.values()) {
            g.setPadre(generos.get(db.getNombreGenero(g.getidpadre())));
            for (PorDefecto pd : g.getListas().values()) {
                ArrayList<String[]> temas = db.getTemasListaPD(pd.getId());
                for (String[] tema: temas) {
                    Artista a = artistas.get(tema[2]);
                    Album al = a.getAlbumes().get(tema[1]);
                    pd.setTema(al.getTema(tema[0]));
                }
            }
            ArrayList<String[]> albumes = db.getGeneroAlbum(g.getid());
            for (int i = 0; i < albumes.size(); i++) {
                String[] o = albumes.get(i);
                Artista a = artistas.get((String)o[1]);
                Album al = a.getAlbumes().get((String)o[0]);
                g.AddAlbum(al);
                al.AddGenero(g);
            }
        }

        for (Cliente c : clientes.values()) {
            ArrayList<String[]> albumes = db.getFAlbum(c.getNickname());
            for (int i = 0; i < albumes.size(); i++) {
                String[] o = albumes.get(i);
                Artista a = artistas.get((String)o[1]);
                Album al = a.getAlbumes().get((String)o[0]);
                c.setFavAlbum(al);
            }
            ArrayList<String[]> temas = db.getFTemas(c.getNickname());
            for (String[] tema: temas) {
                Artista a = artistas.get(tema[2]);
                Album al = a.getAlbumes().get(tema[1]);
                c.setFavTema(al.getTema(tema[0]));
            }
            ArrayList<String[]> listasP = db.getFListasP(c.getNickname());
            for (int i = 0; i < listasP.size(); i++) {
                String[] o = listasP.get(i);
                Cliente c2 = clientes.get((String)o[1]);
                c.setFavLista(c2.getListas().get((String)o[0]));
            }
            ArrayList<String[]> listasPD = db.getFListasPD(c.getNickname());
            for (int i = 0; i < listasPD.size(); i++) {
                String[] o = listasPD.get(i);
                Genero g = generos.get((String)o[1]);
                c.setFavLista(g.getListas().get((String)o[0]));
            }
            ArrayList<String> seg = db.seguidos(c.getNickname());
            for (int i = 0; i < seg.size(); i++) {
                if(clientes.containsKey(seg.get(i)))
                    c.setSiguiendo(clientes.get(seg.get(i)));
                else
                    c.setSiguiendo(artistas.get(seg.get(i)));
            }
            for (Particular p : c.getListas().values()) {
                ArrayList<String[]> temasl = db.getTemasListaP(p.getId());
                for (int i = 0; i < temasl.size(); i++) {
                    String[] o = temasl.get(i);
                    Artista a = artistas.get((String)o[2]);
                    Album al = a.getAlbumes().get((String)o[1]);
                    p.setTema(al.getTema((String) o[0]));
                }
            }
            
        }
        
        Map<Integer, TipoSuscripcion> tiposDeSus = db.cargarTiposDeSuscripcion();
        
        for (TipoSuscripcion ts : tiposDeSus.values()) {
            Cliente.addSuscripcion(ts);
        }
        
        ArrayList<Suscripcion> susc = db.cargarSuscripciones();
        for (Suscripcion suscripcion : susc) {
            TipoSuscripcion tipoS = tiposDeSus.get(suscripcion.getIdTipo());
            suscripcion.setTp(tipoS);
            Cliente c = clientes.get(suscripcion.getNickcliente());
            c.addSuscripcion(suscripcion);
            c.actualizarVigenciaSuscripciones();
        }
        
        Artista.setArtista((HashMap)artistas);
        Artista.setGenero((HashMap)generos);
        Cliente.setClientes((HashMap)clientes);
        
    }
}
