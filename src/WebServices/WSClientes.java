/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServices;
import Encapsuladores.DataAlbumes;
import Encapsuladores.DataListas;
import Encapsuladores.DataTemas;
import Encapsuladores.DataTiposDeSus;
import Encapsuladores.DataUsuarios;
import Logica.DtAlbum;
import Logica.DtCliente;
import Logica.DtLista;
import Logica.DtListaP;
import Logica.DtListaPD;
import Logica.DtTema;
import Logica.DtTipoSuscripcion;
import Logica.DtUsuario;
import Logica.Fabrica;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WSClientes {

    private Endpoint endpoint = null;
    Properties propiedades = new Properties();
    
    //Constructor
    public WSClientes(Properties prop){
        propiedades = prop;
    }

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
//        endpoint = Endpoint.publish("http://localhost:9129/webservices", this);
        endpoint = Endpoint.publish("http://"+propiedades.getProperty("ip")+":"+propiedades.getProperty("puertoWSCli")+"/"+propiedades.getProperty("nombreWSCli"), this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public boolean agregarTemaFavorito(String nickname, String artista, String album, String tema){
        return Fabrica.getCliente().agregarTemaFavorito(nickname, artista, album, tema);
    }
    @WebMethod
    public boolean agregarAlbumFavorito(String nickname, String artista, String album){
        return Fabrica.getCliente().agregarAlbumFavorito(nickname, artista, album);
    }
    
    @WebMethod
    public boolean agregarListaPDFavorito(String nickname, String lista){
        return Fabrica.getCliente().agregarListaFavorito(nickname, lista);
    }
    
    @WebMethod
    public boolean agregarListaPFavorito(String nickname, String creador, String lista){
        return Fabrica.getCliente().agregarListaFavorito(nickname, creador, lista);
    }
    
    @WebMethod
    public DtCliente verPerfilCliente(String nickname){
        return Fabrica.getCliente().verPerfilCliente(nickname);
    }
    
    @WebMethod
    public void DejarSeguir(String cliente, String nickUsr){
        Fabrica.getCliente().DejarSeguir(cliente, nickUsr);
    }    
    
    @WebMethod
    public void seguir(String cliente, String nickUsr){
        try {
            Fabrica.getCliente().seguir(cliente, nickUsr);
        } catch (Exception ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public boolean confirmar(){
        try {
            Fabrica.getCliente().confirmar();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @WebMethod
    public void publicarLista(String nickname, String nomLista){
        Fabrica.getCliente().publicarLista(nickname, nomLista);
    }
    
    @WebMethod
    public DataListas ListarListaPD(){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtLista> listas =  new ArrayList<>();
        listas.addAll(Fabrica.getCliente().ListarListaPD());
        return new DataListas(listas);
    }
    
    @WebMethod
    public DataListas ListarListaP(){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtLista> listas =  new ArrayList<>();
        listas.addAll(Fabrica.getCliente().ListarListaP());
        return new DataListas(listas);
    }
    
    @WebMethod
    public void crearListaP(String nickname, String nombre, byte[] imagen){
        //Daba error al enviar null por parametro desde el servidor web, se implemento tal que byte[0] = null
        if(imagen!= null && imagen.length == 0){
            System.out.println("imagen.length == 0");
            imagen = null;
        }
        Fabrica.getCliente().crearListaPWeb(nickname, nombre, imagen);
    }
    
    @WebMethod
    public DataTiposDeSus listarTipoDeSus(){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtTipoSuscripcion> tiposDeSus =  Fabrica.getCliente().listarTipoDeSus();
        return new DataTiposDeSus(tiposDeSus);
    }
    
    @WebMethod
    public boolean contratarSuscripcion(String nickname, int idTipoS){
        return Fabrica.getCliente().contratarSuscripcion(nickname, idTipoS);
    }    
    
    @WebMethod
    public void actualizarVigenciaSuscripciones(String nickname){
        Fabrica.getCliente().actualizarVigenciaSuscripciones(nickname);
    }
    
    @WebMethod
    public boolean verificarDatosCli(String nick, String correo){ //distinguir cliente artista
        return Fabrica.getCliente().verificarDatos(nick, correo);
    }
    
    @WebMethod
    public DataUsuarios getSeguidores(String nickanme){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtUsuario> clientes =  new ArrayList<>();
        clientes.addAll(Fabrica.getCliente().getSeguidores(nickanme));
        return new DataUsuarios(clientes);
    }
    
    @WebMethod
    public boolean SuscripcionVigente (String nickanme){
        return Fabrica.getCliente().SuscripcionVigente(nickanme);
    }
    
    @WebMethod
    public DataUsuarios BuscarUsuarios(String palabra){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtUsuario> usuarios = Fabrica.getCliente().BuscarUsuarios(palabra);
        return new DataUsuarios(usuarios);
    }
    
    @WebMethod
    public DataTemas resultadosT(String palabra){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtTema> temas =  Fabrica.getCliente().resultadosT(palabra);
        return new DataTemas(temas);
    }
    
    @WebMethod
    public DataListas resultadosL(String palabra){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtLista> listas =  new ArrayList<>();
        listas.addAll(Fabrica.getCliente().resultadosL(palabra));
        return new DataListas(listas);
    }
    
    @WebMethod
    public DataAlbumes resultadosA(String palabra){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtAlbum> albumes =  Fabrica.getCliente().resultadosA(palabra);
        return new DataAlbumes(albumes);
    }  
    
    @WebMethod
    public boolean IngresarCliente(DtCliente cli, byte[] imagen){
        //Daba error al enviar null por parametro desde el servidor web, se implemento tal que byte[0] = null
        if(imagen!= null && imagen.length == 0){
            System.out.println("imagen.length == 0");
            imagen = null;
        }
        
        return Fabrica.getCliente().IngresarCliente(cli,imagen);
//        return false;
    }
    
    @WebMethod
    public DtListaP ListaP(String nick, String nombre){
        return Fabrica.getCliente().listarLista(nick, nombre);
    }
    
    @WebMethod
    public DtListaPD ListaPD( String nombre){
        return Fabrica.getCliente().listarLista(nombre);
    }
    
}

