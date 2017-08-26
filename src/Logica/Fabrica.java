/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ConexionDB;
import Persistencia.DBUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        this.Cliente.setCA(Artista);
    }

    public static void cargarDatos() {
        DBUsuario db = new DBUsuario();
        Map<String, Cliente> clientes = db.cargarClientes();
        Map<String, Genero> generos = db.cargarGenero();
        Map<String, Artista> artistas = db.cargarArtistas();

        for (Genero g : generos.values()) {
            g.setPadre(generos.get(g.getidpadre()));
            for (PorDefecto pd : g.getListas().values()) {
                ArrayList<Object[]> temas = db.getTemasListaPD(pd.getId());
                for (int i = 0; i > temas.size(); i++) {
                    Object[] o = temas.get(i);
                    Artista a = artistas.get(o[2]);
                    Album al = a.getAlbumes().get(o[1]);
                    pd.setTema(al.getTema((String) o[0]));
                }
            }
            ArrayList<Object[]> albumes = db.getGeneroAlbum(g.getid());
            for (int i = 0; i > albumes.size(); i++) {
                Object[] o = albumes.get(i);
                Artista a = artistas.get(o[1]);
                Album al = a.getAlbumes().get(o[0]);
                g.AddAlbum(al);
                al.AddGenero(g);
            }
        }

        for (Cliente c : clientes.values()) {
            ArrayList<Object[]> albumes = db.getFAlbum(c.getNickname());
            for (int i = 0; i > albumes.size(); i++) {
                Object[] o = albumes.get(i);
                Artista a = artistas.get(o[1]);
                Album al = a.getAlbumes().get(o[0]);
                c.setFavAlbum(al);
            }
            ArrayList<Object[]> temas = db.getFTemas(c.getNickname());
            for (int i = 0; i > temas.size(); i++) {
                Object[] o = temas.get(i);
                Artista a = artistas.get(o[2]);
                Album al = a.getAlbumes().get(o[1]);
                c.setFavTema(al.getTema((String) o[0]));
            }
            ArrayList<Object[]> listasP = db.getFListasP(c.getNickname());
            for (int i = 0; i > listasP.size(); i++) {
                Object[] o = listasP.get(i);
                Cliente c2 = clientes.get(o[1]);
                c.setFavLista(c2.getListas().get(o[0]));
            }
            ArrayList<Object[]> listasPD = db.getFListasPD(c.getNickname());
            for (int i = 0; i > listasPD.size(); i++) {
                Object[] o = listasPD.get(i);
                Genero g = generos.get(o[1]);
                c.setFavLista(g.getListas().get(o[0]));
            }
            ArrayList<String> seg = db.seguidos(c.getNickname());
            for (int i = 0; i > seg.size(); i++) {
                if(clientes.containsKey(seg.get(i)))
                    c.setSiguiendo(clientes.get(seg.get(i)));
                else
                    c.setSiguiendo(artistas.get(seg.get(i)));
            }
            for (Particular p : c.getListas().values()) {
                ArrayList<Object[]> temasl = db.getTemasListaP(p.getId());
                for (int i = 0; i > temasl.size(); i++) {
                    Object[] o = temasl.get(i);
                    Artista a = artistas.get(o[2]);
                    Album al = a.getAlbumes().get(o[1]);
                    p.setTema(al.getTema((String) o[0]));
                }
            }
            
        }
        Artista.setArtista((HashMap)artistas);
        Artista.setGenero((HashMap)generos);
        Cliente.setClientes((HashMap)clientes);
    }
}
