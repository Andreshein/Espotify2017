/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author ninoh
 */
public class Fabrica {
    
    //SINGLETON
    private static Fabrica instancia;
    private static IcontArtista Artista;
    private static IcontCliente Cliente;
    public static Fabrica getInstance(){
        if (instancia == null){
            instancia = new Fabrica();
        }
        return instancia;
        
    }

    public static IcontArtista getArtista() {
         IcontArtista ica = ContArtista.getInstance();
         return ica;
    }

     public static IcontCliente getCliente() {
         IcontCliente icc = ContCliente.getInstance();
         return icc;
    }
    
     private Fabrica(){
         
    };
   
    
    
}
