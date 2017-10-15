/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ninoh
 */
public class ConexionDB {
    /*private final String host="localhost";
    private final String port="3306";
    private final String db="espotify";
    private final String user="root";
    private final String pass="root";*/
    
    //Para hacer ConexionDB singleton descomentar
    private static Connection conexion=null;
    //private Connection conexion=null;
    //Para hacer ConexionDB singleton descomentar
    ConexionDB(){};
    //public ConexionDB(){};
    //Para hacer ConexionDB singleton descomentar
    public static Connection getConexion() {
    //public Connection getConexion() {
        if (conexion == null) {
            try {
                Properties p = new Properties();
                InputStream is = new FileInputStream("configuraciones.properties");
                p.load(is);
                
                String host = p.getProperty("host");
                String port = p.getProperty("port");
                String db = p.getProperty("db");
                String user = p.getProperty("user");
                String pass = p.getProperty("pass");
                
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
                conexion = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, pass);
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
    public void cerrar(){
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
}

