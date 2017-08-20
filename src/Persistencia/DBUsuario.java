
/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Logica.Album;
import Logica.Artista;
import Logica.Cliente;
import Logica.DtAlbum;
import Logica.DtArtista;
import Logica.DtListaP;
import Logica.Genero;
import Logica.Particular;
import Logica.PorDefecto;
import Logica.Tema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBUsuario {
    private final Connection conexion = new ConexionDB().getConexion();
    SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
    
    public boolean agregarArtista(Artista a){
        try {
            java.sql.Date fechaN = new java.sql.Date(a.getFechaNac().getTime());
            
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO artista "
                    + "(nickname, nombre, apellido, fechaNac,correo, biografia, pagweb) values(?,?,?,?,?,?,?)");
            statement.setString(1, a.getNickname());
            statement.setString(2, a.getNombre());
            statement.setString(3, a.getApellido());
            statement.setDate(4, fechaN);
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
            java.sql.Date fechaN = new java.sql.Date(c.getFechaNac().getTime());

            PreparedStatement statement = conexion.prepareStatement("INSERT INTO cliente "
                    + "(nickname, nombre, apellido, fechaNac, correo) values(?,?,?,?,?)");
            statement.setString(1, c.getNickname());
            statement.setString(2, c.getNombre());
            statement.setString(3, c.getApellido());
            statement.setDate(4, fechaN);
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
    /**¡¡¡¡¡¡¡ no va !!!!!!!!**/
    /**
    public ArrayList<DtArtista> listarArtistas() {
	try{
            ArrayList<DtArtista> listaArtista = new ArrayList<DtArtista>();
            DtArtista dtart;
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM artista");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                dtart=new DtArtista(rs.getString("Nickname"),rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Correo"),rs.getDate("FechaNac"),null,rs.getString("Biografia"),rs.getString("PagWeb"),0,null,null);               
                listaArtista.add(dtart);
            }

            
            return listaArtista; 

	}catch(SQLException ex){
            ex.printStackTrace();
            return null;
	}
    }
    public DtArtista obtenerInfoArtista(String clave){
	try{
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM artista WHERE Nickname = '"+clave+"'");
	    ResultSet rs = st.executeQuery();
	    DtArtista art;
            while(rs.next()){
            art=new DtArtista(rs.getString("Nickname"),rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Correo"),rs.getDate("FechaNac"),null,rs.getString("Biografia"),rs.getString("PagWeb"),0,null,null);
            return art;
            }
        
            return null;    
       
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;	
        }   
    }    
    
    public ArrayList<DtAlbum> listarAlbumes() {
	try{
            ArrayList<DtAlbum> listaAlbum = new ArrayList<DtAlbum>();
            DtAlbum dtalb;
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM album,artista WHERE album.Artista=artista.Nickname");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                dtalb=new DtAlbum(rs.getString("Nombre"),rs.getString("Artista"),rs.getInt("Anio"),null);               
                listaAlbum.add(dtalb);
            }

            
            return listaAlbum; 

	}catch(SQLException ex){
            ex.printStackTrace();
            return null;
	}
    }
    **/
//    public Map<String, Artista> cargarArtistas(){
//        try {
//            Map<String, Artista> lista=new HashMap<String, Artista>();
//            PreparedStatement st = conexion.prepareStatement("SELECT * FROM artista");          
//            ResultSet rs=st.executeQuery();
//            while (rs.next()){
//                String nickname=rs.getString("nickname");
//                Artista a=new Artista(nickname,rs.getString("nombre"),rs.getString("apellido"),rs.getString("correo"),rs.getDate("fechanac"),rs.getString("biografia"),rs.getString("paginaweb"));
//                lista.put(nickname, a);
//            }
//            rs.close();
//            st.close();
//            return lista;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }        
//    }
//    
//    public Map<String, Cliente> cargarClientes(){
//        try {
//            Map<String, Cliente> lista=new HashMap<String, Cliente>();
//            PreparedStatement st = conexion.prepareStatement("SELECT * FROM cliente");          
//            ResultSet rs=st.executeQuery();
//            while (rs.next()){
//                String nickname=rs.getString("nickname");
//                Cliente c=new Cliente(nickname,rs.getString("nombre"),rs.getString("apellido"),rs.getString("correo"),rs.getDate("fechanac"));
//                lista.put(nickname,c);
//            }
//            rs.close();
//            st.close();
//            return lista;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }        
//    }
//    
//     public Map<Integer, Album> cargarAlbumes(){
//        try {
//            Map<Integer, Album> lista=new HashMap<Integer, Album>();
//            PreparedStatement st = conexion.prepareStatement("SELECT * FROM album");          
//            ResultSet rs=st.executeQuery();
//            while (rs.next()){
//                int id=rs.getInt("id");
//                Album a=new Album(id,rs.getString("artista"),rs.getString("nombre"),rs.getInt("anio"));
//                lista.put(id,a);
//            }
//            rs.close();
//            st.close();
//            return lista;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }        
//        
//        public Map<Integer, Genero> cargarGenero(){
//        try {
//            Map<Integer, Genero> lista=new HashMap<Integer, Genero>();
//            PreparedStatement st = conexion.prepareStatement("SELECT * FROM genero");          
//            ResultSet rs=st.executeQuery();
//            while (rs.next()){
//                int id=rs.getInt("id");
//                Genero g=new Genero(id,rs.getString("nombre"),rs.getInt("idpadre"));
//                lista.put(id,g);
//            }
//            rs.close();
//            st.close();
//            return lista;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        } 
//    }
//        
//         public Map<Integer, PorDefecto> cargarListaPD(){
//        try {
//            Map<Integer, PorDefecto> lista=new HashMap<Integer, PorDefecto>();
//            PreparedStatement st = conexion.prepareStatement("SELECT * FROM listapordefecto");          
//            ResultSet rs=st.executeQuery();
//            while (rs.next()){
//                int id=rs.getInt("id");
//                PorDefecto pd=new PorDefecto(id,rs.getInt("idpadre"),rs.getString("nombre"));
//                lista.put(id,pd);
//            }
//            rs.close();
//            st.close();
//            return lista;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//        
//        public Map<Integer, Particular> cargarListaP(){
//        try {
//            Map<Integer, Particular> lista=new HashMap<Integer, Particular>();
//            PreparedStatement st = conexion.prepareStatement("SELECT * FROM listaparticular");          
//            ResultSet rs=st.executeQuery();
//            while (rs.next()){
//                int id=rs.getInt("id");
//                Particular pd=new Particular(rs.getString("nombre"),rs.getBoolean("privada"));
//                lista.put(id,pd);
//            }
//            rs.close();
//            st.close();
//            return lista;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }  
//                
//    }
//        
//        public Map<Integer, Tema> cargarTema(){
//        try {
//            Map<Integer, Tema> lista=new HashMap<Integer, Tema>();
//            PreparedStatement st = conexion.prepareStatement("SELECT * FROM tema");          
//            ResultSet rs=st.executeQuery();
//            while (rs.next()){
//                int id=rs.getInt("id");
//                Tema pd=new Tema(id,rs.getString("duracion"),rs.getString("nombre"),rs.getInt("orden"),rs.getString("archivo"),rs.getString("direccion"));
//                lista.put(id,pd);
//            }
//            rs.close();
//            st.close();
//            return lista;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }  
//                
//    }
//    
//    
//        
//        
//    
}
