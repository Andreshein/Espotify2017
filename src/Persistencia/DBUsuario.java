/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Logica.Artista;
import Logica.Cliente;
import Logica.DtArtista;
import Logica.DtListaP;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBUsuario {
    private final Connection conexion = new ConexionDB().getConexion();
    SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
    
    public boolean agregarArtista(Artista a){
        try {
           
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO artista "
                    + "(nickname, nombre, apellido, fechaNac,correo, biografia, pagweb) values(?,?,?,?,?,?,?)");
            statement.setString(1, a.getNickname());
            statement.setString(2, a.getNombre());
            statement.setString(3, a.getApellido());
            statement.setString(4, formato.format(a.getFechaNac()));
            statement.setString(5, a.getCorreo());
            statement.setString(6, a.getBiografia());
            statement.setString(7, a.getPaginaWeb());
            statement.executeUpdate();
            statement.close();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }  
    }
        
    public boolean agregarCliente(Cliente c){
        try {  
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO cliente "
                    + "(nickname, nombre, apellido, fechaNac, correo) values(?,?,?,?,?)");
            statement.setString(1, c.getNickname());
            statement.setString(2, c.getNombre());
            statement.setString(3, c.getApellido());
            statement.setString(4, formato.format(c.getFechaNac()));
            statement.setString(5, c.getCorreo());
            statement.executeUpdate();
            statement.close();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }     
    }
    
    public boolean agregarTema(DtListaP l){
        try {  
            PreparedStatement statement = conexion.prepareStatement("SELECT usuario, nombre FROM  listaparticular ");
            statement.setString(1, l.getUsuario());
            statement.setString(1, l.getNombre());
            statement.executeUpdate();
            statement.close();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Artista> listarArtistas(){
	try{
            ArrayList<Artista> listaArtista = new ArrayList<Artista>();
            Artista art;
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM artista");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                art=new Artista();
                art.setNickname(rs.getString("Nickname"));
                art.setNombre(rs.getString("Nombre"));
                art.setApellido(rs.getString("Apellido"));
                art.setCorreo(rs.getString("Correo"));
                art.setFechaNac(rs.getDate("FechaNac"));
                art.setBiografia(rs.getString("Biografia"));
                art.setPaginaWeb(rs.getString("PagWeb"));                
                listaArtista.add(art);
            }

            return listaArtista; // Devolver Lista Artista

	}catch(SQLException ex){
            ex.printStackTrace();
            return null;
	}
    }

    public Artista obtenerInfoArtista(String clave){
	try{
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM artista "+ "WHERE Nickname = '"+clave+"'");
            ResultSet rs = st.executeQuery();
                 
            Artista art = new Artista();
            String nickname = rs.getString("Nickname");

            if(nickname.equals(clave)){
                art.setNickname(rs.getString("Nickname"));
                art.setNombre(rs.getString("Nombre"));
                art.setApellido(rs.getString("Apellido"));
                art.setCorreo(rs.getString("Correo"));
                art.setFechaNac(rs.getDate("FechaNac"));
                art.setBiografia(rs.getString("Biografia"));
                art.setPaginaWeb(rs.getString("PagWeb"));
                return art;
            }  
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;	
        }   
        
        return null;
    }    
}
