/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Map;
import Persistencia.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;

public class ContArtista implements IcontArtista {

    private static ContArtista instancia;

    private Map<String, Artista> artistas = null;
    private Map<String, Genero> generos = null;
    private Map<String, PorDefecto> ListasPorDef = null;
    private DBUsuario dbUsuario=null;
    private IcontCliente Cli;

    public static ContArtista getInstance() {
        if (instancia == null) {
            instancia = new ContArtista();
        }
        return instancia;
    }

    private ContArtista() {

        this.artistas = new HashMap<>();
        this.dbUsuario = new DBUsuario();
        this.ListasPorDef = new HashMap<>();
    }
    
    public Map<String, Genero> GetGeneros(){
        return this.generos;
    }

    public void SetContCliente(IcontCliente cli){
        this.Cli = cli;
    }
    public Map<String, Artista> GetArtistas(){
        return this.artistas;
    }
    @Override
    public boolean SelectArtista(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CrearAlbum(String nombre, int anio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ElegirGenero(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ConfirmarAlbum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtArtista ElegirArtista(String nomArtista) {
        Artista a = (Artista) this.artistas.get(nomArtista);
        return a.getDatos();
    }

    @Override
    public ArrayList<DtArtista> ListarArtistas() {
        ArrayList<DtArtista> a = new ArrayList<>();
        Iterator iterador = this.artistas.values().iterator();
        while (iterador.hasNext()) {
            Artista aux = (Artista) iterador.next();
            a.add(aux.getDatos());
        }
        return a;

    }
    
    @Override
    public ArrayList<DtAlbum> listarAlbumesArtista(String nick){
	Artista art=(Artista) this.artistas.get(nick);
	return art.getDtAlbumes();
    }

    @Override
    public ArrayList<DtCliente> listarSeguidores(String nick){
	return this.Cli.getSeguidores(nick);
    }


//    @Override
//    public ArrayList <DtGenero> obtenerGenero() {
////        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////        ArrayList<DtGenero> retornar=new ArrayList<DtGenero>();
////        Iterator iterator = this.generos.values().iterator();
////            while(iterator.hasNext()) {
////                Genero aux = (Genero)iterator.next();
////               retornar.add(aux.getDtGenero());}       
////        return retornar;
//        
//    }

//    @Override
//    public ArrayList <DtArtista> obtenerArtista() {
////        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////        ArrayList<DtArtista> retornar=new ArrayList<DtArtista>();
////        Iterator iterator = this.artistas.values().iterator();
////        while(iterator.hasNext()) {
////            Artista aux = (Artista)iterator.next();
////            retornar.add(aux.getDtArtista());}       
////        return retornar;
//    }
    
    public ArrayList<DtAlbum> BuscarGenero(String palabra){
        ArrayList<DtAlbum> retornar=new ArrayList<>();
        Iterator iterator = this.generos.values().iterator();
        while(iterator.hasNext()) {
            Genero aux = (Genero)iterator.next();
            
            //Pasa los strings a mayusculas para comparar mejor
            String genero = aux.getNombre().toUpperCase();
            palabra = palabra.toUpperCase();
            
            if(genero.startsWith(palabra)){
                retornar.addAll(aux.getAlbumesGenero());
            }
        }       
        return retornar;
   }
   
    public ArrayList <DtAlbum> BuscarArtista(String palabra) {
        ArrayList<DtAlbum> retornar=new ArrayList<>();
        Iterator iterator = this.artistas.values().iterator();
        while(iterator.hasNext()) {
            Artista aux = (Artista)iterator.next();
            
            //Pasa los strings a mayusculas para comparar mejor
            palabra = palabra.toUpperCase();
            String nickname = aux.getNickname().toUpperCase();
            String nombre = aux.getNombre().toUpperCase();
            String apellido = aux.getApellido().toUpperCase();
            String nombrecompleto = aux.getNombre() + " " + aux.getApellido();
            nombrecompleto = nombrecompleto.toUpperCase();
            
            if(nickname.startsWith(palabra) || nombre.startsWith(palabra) || apellido.contains(palabra) || nombrecompleto.startsWith(palabra)){
                retornar.addAll(aux.ListarAlbumes());   
            }
        }
        return retornar;
    }

    public ArrayList <DtTema> obtenerTema (String artista, String album){
       Artista art = this.artistas.get(artista);
       return art.getAlbumes().get(album).getDtTemas();
    }
    
    @Override
    public void seleccionarAlbum(String nick, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtAlbum mostrarAlbum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LiberarMemoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
     public void corregir(String nickname,String nombre,String apellido,String correo,Date fechaNac,ImageIcon imagen){
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
     @Override
    public boolean IngresarArtista(String nickname, String nombre, String apellido,String correo, Date fechaNac, String biografia, String paginaWeb, String Img){
        if(Fabrica.getCliente().verificarDatos(nickname, correo) == false){ // si ya existe un cliente con ese nickname o correo
            return false;
        }else{
            if(this.verificarDatos(nickname, correo) == false){
                return false;
            }
        }
        
        //Si no retorno false antes, entonces los datos están bien
        
        if(Img != null){
            //Divide el string por el punto, tambien elimina el punto
            String[] aux = Img.split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial

            //toma la segunda parte porque es la extension
            //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
            String extension = aux[1];

            //Ruta donde se va a copiar el archivo de imagen
            String rutaDestino = "Imagenes/Artistas/"+nickname+"."+extension; // se le agrega el punto(.) porque la hacer el split tambien se borra

            //esa funcion retorna un booleano que indica si la imagen se pudo crear correctamente
            //la funcion ya esta definida en el controlador de cliente porque ahi se usa, entocnces no hay que declararla otra vez en este controlador
            if(Fabrica.getCliente().copiarImagenAlServidor(Img, rutaDestino) == true){
                Img = rutaDestino; //la ruta que hay que guardar es la del archivo nuevo que fue copiado dentro del servidor
            }else{
                Img = null; // no se pudo copiar la imagen, queda en null
            }
        }

        Artista a=new Artista(nickname, nombre, apellido, correo, fechaNac, biografia, paginaWeb, Img);
        boolean ok =this.dbUsuario.agregarArtista(a);
        if (ok){
            this.artistas.put(nickname, a);
        }
        
        return ok;
    }
    
    public void IngresarAlbum(String nomartista, String anio, String nombre, String imagen, HashMap<String, Tema> temas, HashMap<String,Genero> generos){
        int anio2 = Integer.parseInt(anio);
        ArrayList<Genero> l = new ArrayList();
        Set set2 = generos.entrySet();
        Iterator iter = set2.iterator();
        while (iter.hasNext()){
            Map.Entry x = (Map.Entry) iter.next();
            Genero gen = (Genero)x.getValue();
            l.add(gen);
        }
        Album a = new Album(nomartista, nombre, anio2, imagen, temas, l);
        int idalbum = this.dbUsuario.InsertarAlbum(a);
        for (int i=0;i<l.size();i++)
            l.get(i).AddAlbum(a);
        Artista ar = artistas.get(nomartista);
        ar.getAlbumes().put(a.getNombre(), a);
        for (int i=0;i<a.getGeneros().size();i++){
            int idg = a.getGeneros().get(i).getid();
            this.dbUsuario.InsertarGenero_Album(idalbum,idg);
            }
        Set set = a.getTemas().entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            Map.Entry x = (Map.Entry) it.next();
            Tema t = (Tema) x.getValue();
            this.dbUsuario.InsertarTema(idalbum, t);
        }        
    }

    @Override
    public void AgregarTema(String nombre, String duracion, int ubicacion, String url_mp3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Artista buscarArtista(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    public ArrayList<DtUsuario> BuscarUsuarios(String palabra) {
        ArrayList<DtUsuario> retornar = new ArrayList<>();
        Iterator iterador = this.artistas.values().iterator();
        while (iterador.hasNext()) {
            Artista aux = (Artista) iterador.next();
            palabra = palabra.toUpperCase();
                String nick = aux.getNickname().toUpperCase();
                String nombre = aux.getNombre().toUpperCase();
                String apellido = aux.getApellido().toUpperCase();
                String nomAp = aux.getNombre().toUpperCase()+aux.getApellido().toUpperCase();
            if (nick.contains(palabra) == true || nombre.contains(palabra) == true || apellido.contains(palabra) == true || nomAp.contains(palabra) == true) {
                retornar.add(aux.getDatos());
            }
        }
        return retornar;
    }

    public Usuario seleccionarUsuario(String Nickname) {
        return (Usuario) this.artistas.get(Nickname);
    }
    
    public DtGenero listarGArbol(){
        Genero g = this.generos.get("Género");
        return g.getDatos(this.buscaHijos(g.getNombre()));
    }
    
    private ArrayList<DtGenero> buscaHijos(String nombre){
        ArrayList<DtGenero> a = new ArrayList<>();
        Iterator it = this.generos.values().iterator();
        while(it.hasNext()){
            Genero g = (Genero)it.next();
            if(g.getPadre()!= null)
            if(g.getPadre().getNombre().equals(nombre)){
                DtGenero dtg = g.getDatos(this.buscaHijos(g.getNombre()));
                a.add(dtg);
            }
        }
        return a;
    }

    public void setArtista(HashMap<String, Artista> artistas) {
        this.artistas = artistas;
    }

    public void setGenero(HashMap<String, Genero> generos) {
        this.generos = generos;
    }
    
    @Override
    public List<DtArtista> BuscarArtistas(String nombre) {
        List<DtArtista> retornar=new ArrayList<>();
        Set set = artistas.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            Artista aux=(Artista) mentry.getValue();     
            if (aux.getNickname().toUpperCase().startsWith(nombre.toUpperCase())){
                retornar.add(aux.GetDtArtista());
            }
        }       
        return retornar;
    }

    @Override
    public ArrayList<DtListaPD> ListarListaPD() {
        ArrayList<DtListaPD> retorno = new ArrayList<DtListaPD>();
        for(Genero g : this.generos.values()){
            retorno.addAll(g.getDtListas());
        }
        return retorno;
    }
    @Override
    public ArrayList<DtAlbum> ListarAlbum() {
        ArrayList<DtAlbum> al = new ArrayList<DtAlbum>();
        for(Artista a:this.artistas.values()){
          al.addAll(a.getDtAlbumes());
        }
        return al;
    }
   
    
    public Genero getGenero(String nombre){
        return this.generos.get(nombre);
    }
    
    @Override
    public ArrayList<DtTema> listarTemasListaPD(String listaPD,String nombreG){
	Genero g=(Genero) this.generos.get(nombreG);
        PorDefecto pd= g.getListas().get(listaPD);
        return pd.getDtTemas();
    }
    @Override
    public ArrayList<DtTema> listarTemasListaA(String nickname,String nombre){
	Artista a=(Artista) this.artistas.get(nickname);
        Album al= (Album) a.getAlbumes().get(nombre);
        return al.getDtTemas();
    }
    
    @Override
    public ArrayList<DtGenero> listarGeneros(String nombreG){
        ArrayList<DtGenero> resultado= new ArrayList<>();
        for(Genero g:this.generos.values()){
            if(g.getNombre().contains(nombreG))
                resultado.add(g.getDatos(resultado));
        }
        
        return resultado;
    }
    
    @Override
    public boolean verificarDatos(String nickname, String correo){
        for (Artista art : this.artistas.values()) {
            if(art.getNickname().equals(nickname)){
                return false; // nickname ya existe, repetido
            }
            
            if(art.getCorreo().equals(correo)){
                return false; //correo ya existe, repetido
            }
        }
        
        //Si no retornó false dentro del for, entonces los datos estan bien
        return true;
    }

 
}
