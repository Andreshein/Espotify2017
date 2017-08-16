/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Logica.Artista;
import Logica.Cliente;
import Logica.DtListaP;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
        
}
