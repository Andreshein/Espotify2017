/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Encapsuladores.DataBytes;
import Encapsuladores.DataTemas;
import Logica.DtTema;
import Logica.Fabrica;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Kevin
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class WSArchivos {
    private Endpoint endpoint = null;
    Properties propiedades = new Properties();
    
    //Constructor
    public WSArchivos(Properties prop){
        propiedades = prop;
    }

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
        System.out.println("http://"+propiedades.getProperty("ip")+":"+propiedades.getProperty("puertoWSArch")+"/"+propiedades.getProperty("nombreWSArch"));
        endpoint = Endpoint.publish("http://"+propiedades.getProperty("ip")+":"+propiedades.getProperty("puertoWSArch")+"/"+propiedades.getProperty("nombreWSArch"), this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public void cargarDatosBD(){
        Fabrica.getInstance(); // levantar datos de la sBD
    }
    
    @WebMethod
    public void CargadeDatos(){ // datos de prueba
        Fabrica.getCliente().CargadeDatos();
    }
    
    @WebMethod
    public DataBytes cargarArchivo(@WebParam(name = "rutaArchivo") String rutaArchivo) throws IOException {
        byte[] byteArray = null;
        
        try {
                File f = new File(rutaArchivo);
                FileInputStream streamer = new FileInputStream(f);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
                streamer.close();
        } catch (IOException e) {
                throw e;
        }
        
        return new DataBytes(byteArray);
    }
    
    @WebMethod
    public DataTemas reproducirAlbum(String artista, String album){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtTema> temas =  Fabrica.getArtista().reproducirAlbum(artista, album);
        DataTemas dat = new DataTemas();
        dat.setTemas(temas);
        return dat;
    }
    
    @WebMethod
    public DataTemas reproducirListaP(String creador, String lista){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtTema> temas = Fabrica.getCliente().reproducirListaP(creador, lista);
        return new DataTemas(temas);
    }
    
    @WebMethod
    public DataTemas reproducirListaPD(String genero, String lista){
        //Retornar las listas dentro de otra clase auxiliar, es necesario para que funcionen los webservices
        ArrayList<DtTema> temas = Fabrica.getArtista().reproducirListaPD(genero, lista);
        return new DataTemas(temas);
    }
    
    @WebMethod
    public DataBytes getImagenAlbum(String artista, String album){
        return new DataBytes(Fabrica.getArtista().getImagenAlbum(artista, album));
    }
}
