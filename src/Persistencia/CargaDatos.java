/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class CargaDatos {/*

    private Connection c;

    public CargaDatos(Connection c) {
        this.c = c;
    }

    public HashMap<String, Cliente> cargarCliente() throws SQLException {
        HashMap<String, Cliente> cli = new HashMap<>();
        PreparedStatement st = c.prepareStatement("SELECT * FROM cliente");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            HashMap<String, Particular> lp = new HashMap<>();
            PreparedStatement st2 = c.prepareStatement("SELECT * FROM listaparticular where Usuario='" + rs.getString("Nickname")+"'");
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Particular par = new Particular(rs2.getString("Nombre"));
                par.setEsPrivado(rs2.getBoolean("Privada"));
                lp.put(par.getNombre(), par);
            }
            Cliente cl = new Cliente(rs.getString("Nickname"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"), rs.getDate("FechaNac"));
            cl.setListas(lp);
            cli.put(cl.getNombre(), cl);
        }
        rs.close();
        st.close();
        return cli;
    }

    public HashMap<String, Artista> cargarArtista() throws SQLException {        
        HashMap<String, Artista> art = new HashMap<>();
        PreparedStatement st = c.prepareStatement("SELECT * FROM artista");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            
            HashMap<String, Album> alb = new HashMap<>();
            //PreparedStatement st2 = c.prepareStatement("SELECT * FROM album where Artista" + rs.getString("Nickname"));
            PreparedStatement st2 = c.prepareStatement("SELECT * FROM album where Artista='" + rs.getString("Nickname")+"'");
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Album al = new Album(rs.getString("Nombre"), rs2.getString("Nombre"), rs2.getInt("Anio"));
                HashMap<String, Tema> tem = new HashMap<>();
                PreparedStatement st3 = c.prepareStatement("SELECT * FROM tema where IdAlbum=" + rs2.getString("Id"));
                ResultSet rs3 = st3.executeQuery();
                while (rs3.next()) {
                    Tema t = new Tema(rs3.getString("Duracion"), rs3.getString("Nombre"), rs3.getInt("Orden"), rs3.getString("Archivo"), rs3.getString("Dirección"));
                    al.setTema(t);
                }
                rs3.close();
                st3.close();
                Artista ar = new Artista(rs.getString("Nickname"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"), rs.getDate("FechaNac"), rs.getString("Biografia"), rs.getString("Pagweb"));
                ar.setAlbumes(alb);
                art.put(ar.getNombre(), ar);
                alb.put(al.getNombre(), al);
            }
            rs2.close();
            st2.close();
            Artista ar = new Artista(rs.getString("Nickname"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"), rs.getDate("FechaNac"), rs.getString("Biografia"), rs.getString("Pagweb"));
            ar.setAlbumes(alb);
            art.put(ar.getNombre(), ar);
        }
        rs.close();
        st.close();
        return art;
    }

    public HashMap<String, Genero> cargarGenero() throws SQLException {
        HashMap<String, Genero> gen = new HashMap<>();
        PreparedStatement st = c.prepareStatement("SELECT * FROM genero");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            HashMap<String, PorDefecto> lpd = new HashMap<>();
            PreparedStatement st2 = c.prepareStatement("SELECT * FROM genero g, listapordefecto lpd where g.Nombre=" + rs.getString("Nombre") + " "
                    + "and g.Id=lpd.IdGenero");
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                PorDefecto pd = new PorDefecto(rs2.getString("lpd.Nombre"));
                //falta imagen
                lpd.put(pd.getNombre(), pd);
            }
            rs.close();
            st.close();
            Genero g = new Genero(rs.getString("Nombre"));
            g.setListas(lpd);
            gen.put(g.getNombre(), g);
        }
        rs.close();
        st.close();
        return gen;
    }

    public ArrayList<String> Seguidos(String Nickname) throws SQLException  {
        ArrayList<String> claves = new ArrayList<>();
        PreparedStatement st = c.prepareStatement("SELECT * FROM seguidorcli where Seguidor='" + Nickname + "'");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            claves.add(rs.getString("Seguido"));
        }
        
        try {
            st = c.prepareStatement("SELECT * FROM seguidoart where Seguidor='" + Nickname + "'");
            rs = st.executeQuery();
            while (rs.next()) {
                claves.add(rs.getString("Seguido"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rs.close();
        st.close();
        return claves;
    }

    public ArrayList<String> favtemas(String Nickname)  {
        ArrayList<String> claves = new ArrayList<>();
        PreparedStatement st;
        try {
            st = c.prepareStatement("SELECT a.Nombre, a.Artista, t.Nombre FROM favtema as f,tema as t,album as a where Cliente='" + Nickname + "'"
                    + "and f.IdTema=t.Id and t.IdAlbum=a.Id");
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                claves.add(rs.getString("a.Artista") + ":" + rs.getString("a.Nombre") + "-" + rs.getString("t.nombre"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return claves;
    }

    public ArrayList<String> favalbum(String Nickname) {
        ArrayList<String> claves = new ArrayList<>();
        PreparedStatement st;
        try {
            st = c.prepareStatement("SELECT a.Nombre, a.Artista, a.Nombre FROM favalbum as f,album as a where f.Cliente='" + Nickname + "'"
                    + "and f.IdAlbum=a.Id");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                claves.add(rs.getString("a.Artista") + ":" + rs.getString("a.Nombre"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return claves;
    }

    public ArrayList<String> favlistap(String Nickname) throws SQLException {
        ArrayList<String> claves = new ArrayList<>();
        PreparedStatement st = c.prepareStatement("SELECT p.Nombre, p.Usuario FROM favlistap as f, listaparticular as p where f.Cliente='" + Nickname + "'"
                + "and f.IdLista=p.Id");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            claves.add(rs.getString("p.Usuario") + ":" + rs.getString("p.Nombre"));
        }
        rs.close();
        st.close();
        return claves;
    }

    public ArrayList<String> favlistapd(String Nickname) {
        ArrayList<String> claves = new ArrayList<>();
        PreparedStatement st;
        try {
            //st = c.prepareStatement("SELECT pd.Nombre, pd.Usuario FROM favlistap as f, listapordefecto as pd where f.Cliente='" + Nickname + "'"
            //        + "and f.IdLista=pd.Id");
            //No existe Usuarios en listapordefecto
            st = c.prepareStatement("SELECT pd.Nombre, f.Cliente FROM favlistap as f, listapordefecto as pd where f.Cliente='" + Nickname + "'"
                    + "and f.IdLista=pd.Id");
            //Puse f.Clientes de substituto, no se si es correcto
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                claves.add(rs.getString("f.Cliente") + ":" + rs.getString("pd.Nombre"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return claves;
    }

    public ArrayList<String> generoAlbum(String Nombre) throws SQLException {
        ArrayList<String> claves = new ArrayList<>();
        PreparedStatement st = c.prepareStatement("SELECT a.Nombre, a.Artista FROM album a, genero g, generosalbum ga where g.Nombre='" + Nombre + "'"
                + "and g.Id=ga.IdGenero and ga.IdAlbum=a.Id");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            claves.add(rs.getString("pd.Artista") + ":" + rs.getString("pd.Nombre"));
        }
        rs.close();
        st.close();
        return claves;
    }

    public ArrayList<String> temalistapd(String Genero, String Lista) throws SQLException {
        ArrayList<String> claves = new ArrayList<>();
        PreparedStatement st = c.prepareStatement("SELECT a.Nombre, a.Artista, t.Nombtre FROM  genero g, listapordefecto lp, temalistapd as tl,tema as t,album as a where g=" + Genero + ""
                + " g.Id=lp.IdGenero and lp.Nombre=" + Lista + " and lp.IdTema=t.Id and t.IdAlbum=a.Id");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            claves.add(rs.getString("a.Artista") + ":" + rs.getString("a.Nombre") + "-" + rs.getString("t.nombre"));
        }
        rs.close();
        st.close();
        return claves;
    }

    public ArrayList<String> temalistap(String Usuario, String Lista) throws SQLException {
        ArrayList<String> claves = new ArrayList<>();
        PreparedStatement st = c.prepareStatement("SELECT a.Nombre, a.Artista, t.Nombtre FROM  listaparticulae lp, temalistapd as tl,tema as t,album as a where lp.Usuario='" + Usuario + "'"
                + "and lp.Nombre=" + Lista + " and lp.IdTema=t.Id and t.IdAlbum=a.Id");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            claves.add(rs.getString("a.Artista") + ":" + rs.getString("a.Nombre") + "-" + rs.getString("t.nombre"));
        }
        rs.close();
        st.close();
        return claves;
    }

    public String generoPadre(String Genero) throws SQLException {
        String nombre = null;
        PreparedStatement st = c.prepareStatement("SELECT p.Nombre FROM genero g, genero p where g.Nombre=" + Genero + " and g.IdPadre=p.Id ");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            nombre = rs.getString("p.Nombre");
        }
        rs.close();
        st.close();
        return nombre;
    }*/
}
