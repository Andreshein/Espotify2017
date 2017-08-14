/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Logica.Artista;
import Logica.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUsuario {
    private final Connection conexion = new ConexionDB().getConexion();
    
    
    public boolean agregarArtista(Artista a){
        try {
           
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO artista "
                    + "(nickname, nombre, apellido, fechaNac,correo, biografia, paginaWeb) values(?,?,?,?,?,?,?)");
            statement.setString(1, a.getNickname());
            statement.setString(2, a.getNombre());
            statement.setString(3, a.getApellido());
            statement.setString(4, a.getFechaNac().toString());
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
            Date dt = new Date(1998,1,17);
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO cliente "
                    + "(nickname, nombre, apellido, fechaNac, correo) values(?,?,?,?,?)");
            statement.setString(1, c.getNickname());
            statement.setString(2, c.getNombre());
            statement.setString(3, c.getApellido());
            statement.setDate(4, dt/*c.getFechaNac().toString()*/); //cambiar por setString para guardar la fecha como String
            statement.setString(5, c.getCorreo());
            statement.executeUpdate();
            statement.close();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }     
    }
    
}
