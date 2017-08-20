/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.CargaDatos;
import Persistencia.ConexionDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ninoh
 */
public class Fabrica {

    //SINGLETON
    private static Fabrica instancia;
    private IcontCliente Cliente;
    private IcontArtista Artista;

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;

    }

    public IcontArtista getArtista() {
        return this.Artista;
    }

    public IcontCliente getCliente() {
        return this.Cliente;
    }

    private Fabrica() {
        this.Artista = ContArtista.getInstance();
        this.Cliente = ContCliente.getInstance();
    }

    public void cargarDatos() {
        ConexionDB bd = new ConexionDB();
        CargaDatos c = new CargaDatos(bd.getConexion());

        try {
            HashMap<String, Artista> artistas = c.cargarArtista();
            HashMap<String, Cliente> clientes = c.cargarCliente();
            HashMap<String, Genero> generos = c.cargarGenero();

            Iterator aux = (Iterator) clientes.values().iterator();
            while (aux.hasNext()) {
                Cliente cli = (Cliente) aux.next();
                ArrayList<String> claves = c.Seguidos(cli.getNickname());
                for (int i = 0; i < claves.size(); i++) {
                    if (clientes.containsKey((String) claves.get(i))) {
                        cli.setSiguiendo(clientes.get((String) claves.get(i)));
                    } else {
                        cli.setSiguiendo(artistas.get((String) claves.get(i)));
                    }
                }
                Iterator it = (Iterator) cli.getListas().values().iterator();
                while (it.hasNext()) {
                    Particular l = (Particular) it.next();
                    claves = c.temalistap(cli.getNickname(), l.getNombre());
                    for (int i = 0; i < claves.size(); i++) {
                        String nick, alb, t, clave = (String) claves.get(i);
                        nick = clave.substring(0, clave.indexOf(":"));
                        alb = clave.substring(clave.indexOf(":"), clave.indexOf("-"));
                        t = clave.substring(clave.indexOf("-") + 1);
                        Artista art = (Artista) artistas.get(nick);
                        Album al = (Album) art.getAlbumes().get(alb);
                        l.setTema(al.getTema(t));
                    }
                }
                claves = c.favtemas(cli.getNickname());
                for (int i = 0; i < claves.size(); i++) {
                    String nick, alb, t, clave = (String) claves.get(i);
                    nick = clave.substring(0, clave.indexOf(":"));
                    alb = clave.substring(clave.indexOf(":"), clave.indexOf("-"));
                    t = clave.substring(clave.indexOf("-") + 1);
                    Artista art = (Artista) artistas.get(nick);
                    Album al = (Album) art.getAlbumes().get(alb);
                    cli.setFavTema(al.getTema(t));
                }
                claves = c.favalbum(cli.getNickname());
                for (int i = 0; i < claves.size(); i++) {
                    String nick, alb, t, clave = (String) claves.get(i);
                    nick = clave.substring(0, clave.indexOf(":"));
                    alb = clave.substring(clave.indexOf(":")+1);
                    Artista art = (Artista) artistas.get(nick);
                    Album al = (Album) art.getAlbumes().get(alb);
                   cli.setFavAlbum(al);
                }
                claves = c.favlistap(cli.getNickname());
                for (int i = 0; i < claves.size(); i++) {
                    String nick, l, clave = (String) claves.get(i);
                    nick = clave.substring(0, clave.indexOf(":"));
                    l = clave.substring(clave.indexOf(":")+1);
                    Cliente cl = clientes.get(nick);
                    cli.setFavLista(cl.getListas().get(l));
                }
                claves = c.favlistapd(cli.getNickname());
                for (int i = 0; i < claves.size(); i++) {
                    String gen, l, clave = (String) claves.get(i);
                    gen = clave.substring(0, clave.indexOf(":"));
                    l = clave.substring(clave.indexOf(":")+1);
                    Genero g = (Genero)generos.get(gen);
                    cli.setFavLista(g.getListas().get(l));
                }
                
            }
            aux = (Iterator)generos.values().iterator();
            while(aux.hasNext()){
                Genero g =(Genero)aux.next();
                g.setPadre((Genero)generos.get(c.generoPadre(g.getNombre())));
                Iterator it = (Iterator)g.getListas().values().iterator();
                ArrayList<String> claves;
                while (it.hasNext()) {
                    PorDefecto l = (PorDefecto) it.next();
                    claves = c.temalistapd(g.getNombre(), l.getNombre());
                    for (int i = 0; i < claves.size(); i++) {
                        String nick, alb, t, clave = (String) claves.get(i);
                        nick = clave.substring(0, clave.indexOf(":"));
                        alb = clave.substring(clave.indexOf(":"), clave.indexOf("-"));
                        t = clave.substring(clave.indexOf("-") + 1);
                        Artista art = (Artista) artistas.get(nick);
                        Album al = (Album) art.getAlbumes().get(alb);
                        l.setTema(al.getTema(t));
                    }
                }
                claves = c.generoAlbum(g.getNombre());
                for (int i = 0; i < claves.size(); i++) {
                    String nick, alb, clave = (String) claves.get(i);
                    nick = clave.substring(0, clave.indexOf(":"));
                    alb = clave.substring(clave.indexOf(":")+1);
                    Artista art = (Artista) artistas.get(nick);
                    Album al = (Album) art.getAlbumes().get(alb);
                    g.setAlbum(al);
                }
                
            }

        } catch (SQLException ex) {
            
        }
    }
}
