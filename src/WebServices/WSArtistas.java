/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Encapsuladores.DataAlbumes;
import Encapsuladores.DataGeneros;
import Encapsuladores.DataListas;
import Encapsuladores.DataTemas;
import Encapsuladores.DataUsuarios;
import Logica.DtAlbum;
import Logica.Fabrica;
import Logica.DtArtista;
import Logica.DtGenero;
import Logica.DtLista;
import Logica.DtTema;
import Logica.DtUsuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Kevin
 */

@WebService
@SOAPBinding(style = Style.RPC)
public class WSArtistas {
    private Endpoint endpoint = null;
//    Properties propiedades = new Properties();
     
    @WebMethod(exclude = true)
    public void publicar(Properties propiedades){
        System.out.println("http://"+propiedades.getProperty("ip")+":"+propiedades.getProperty("puertoWSArt")+"/"+propiedades.getProperty("nombreWSArt"));
        endpoint = Endpoint.publish("http://"+propiedades.getProperty("ip")+":"+propiedades.getProperty("puertoWSArt")+"/"+propiedades.getProperty("nombreWSArt"), this);
    }
    
//    @WebMethod(exclude = true)
//    public Endpoint getEndpoint() {
//        return endpoint;
//    }
    
    @WebMethod
    public boolean AgregarTemaListaWeb(String nomtema, String nomalbum, String nomartista, String listaelegida, String cliente){
        return Fabrica.getArtista().AgregarTemaListaWeb(nomtema, nomalbum, nomartista, listaelegida, cliente);
    }
    
    @WebMethod
    public boolean IngresarArtista(DtArtista art, byte[] imagen){
        return Fabrica.getArtista().IngresarArtista(art,imagen);
    }
    
    @WebMethod
    public DataUsuarios verificarLoginArtista(String nickname, String contrasenia){
        ArrayList<DtUsuario> aux = new ArrayList<>();
        DtUsuario dt = Fabrica.getArtista().verificarLoginArtista(nickname, contrasenia);
        aux.add(dt);
        return new DataUsuarios(aux);
    }
    
    @WebMethod
    public void IngresarAlbumWeb(String nicknameArt, String anioAlbum, String nomAlbum, byte[] imagen, ArrayList<DtTema> temasAlbum, ArrayList<DtGenero> generosAlbum){
        HashMap<String, DtTema> temasA = new HashMap<>();
        HashMap<String, DtGenero> generosA = new HashMap<>();
        
        for (DtTema tema : temasAlbum) {
            temasA.put(tema.getNombre(), tema);
        }
        
        for (DtGenero genero : generosAlbum) {
            generosA.put(genero.getNombre(), genero);
        }
        
        Fabrica.getArtista().IngresarAlbumWeb(nicknameArt,anioAlbum,nomAlbum,imagen,temasA,generosA);
    }
    
    @WebMethod
    public DataGeneros BuscarGenero(String buscar){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtGenero> generos = new ArrayList<>();
        
        //Usar DataGeneros para retornar la lista de generos
        for (String string : Fabrica.getArtista().BuscarGenero(buscar)) {
            generos.add(new DtGenero(string, null, null, null)); //solo contiene el nombre, es para listarlos
        }
        
        return new DataGeneros(generos);
    }
    
    @WebMethod
    public DataTemas listarTodosTemas(){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtTema> temas =  Fabrica.getArtista().listarTodosTemas();
        return new DataTemas(temas);
    }
    
    @WebMethod
    public DataUsuarios ListarArtistas(){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtUsuario> artistas =  new ArrayList<>();
        artistas.addAll(Fabrica.getArtista().ListarArtistas());
        return new DataUsuarios(artistas);
    }
    
    @WebMethod
    public boolean estaAlbum(String nicknameArt,String nom){
        return Fabrica.getArtista().estaAlbum(nicknameArt,nom);
    }
    
    @WebMethod
    public DataGeneros GetDataGeneros(){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtGenero> generos = new ArrayList<>();        
        for (DtGenero g : Fabrica.getArtista().GetDataGeneros().values()) {
            generos.add(g);
        }
        
        return new DataGeneros(generos);
    }
    
    @WebMethod
    public DtArtista ElegirArtista(String nickname){
        return Fabrica.getArtista().ElegirArtista(nickname);
    }
    
    @WebMethod
    public DataAlbumes listarAlbumGenero(String nombre){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtAlbum> albumes =  Fabrica.getArtista().listarAlbumGenero(nombre);
        return new DataAlbumes(albumes);
    }
    
    @WebMethod
    public DataListas getListasGenero(String nombre){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtLista> listas =  new ArrayList<>();
        listas.addAll(Fabrica.getArtista().getListasGenero(nombre));
        return new DataListas(listas);
    }
    
    @WebMethod
    public DtAlbum ElegirAlbum(String nombreArt, String nombreAlb){
        return Fabrica.getArtista().ElegirAlbum(nombreArt, nombreAlb);
    }
    
    @WebMethod
    public boolean verificarDatosArt(String nick, String correo){
        return Fabrica.getArtista().verificarDatos(nick, correo);
    }
    
    @WebMethod
    public DataAlbumes listarTodosAlbumes(){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtAlbum> albumes =  Fabrica.getArtista().listarTodosAlbumes();
        return new DataAlbumes(albumes);
    }
    
    @WebMethod
    public DataListas ListarListaPD(){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtLista> listas =  new ArrayList<>();
        listas.addAll(Fabrica.getArtista().ListarListaPD());
        return new DataListas(listas);
    }
    
    @WebMethod
    public DataUsuarios listarSeguidores(String nickname){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtUsuario> clientes =  new ArrayList<>();
        clientes.addAll(Fabrica.getArtista().listarSeguidores(nickname));
        return new DataUsuarios(clientes);
    }
}
