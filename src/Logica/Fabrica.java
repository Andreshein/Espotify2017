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
         Artista = ContArtista.getInstance();
         return Artista;
    }

     public static IcontCliente getCliente() {
         Cliente = ContCliente.getInstance();
         return Cliente;
    }
    public static void SetControladores(){
       Cliente.SetContArtista(Artista);
       Artista.SetContCliente(Cliente);
    }
    
     private Fabrica(){
         
    };
   
    
    
}
