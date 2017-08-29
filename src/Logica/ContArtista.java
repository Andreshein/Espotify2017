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

    private Map<String, Artista> artistas;
    private Map<String, Genero> generos;
    private Map<String, PorDefecto> ListasPorDef;
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
            if(aux.getNombre().contains(palabra)){
//            if(aux.getNombre().indexOf(palabra)!=-1)
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
            String nombrecompleto = aux.getNombre() + " " + aux.getApellido();
            if(aux.getNickname().contains(palabra) || aux.getNombre().contains(palabra) || aux.getApellido().contains(palabra) || nombrecompleto.contains(palabra)){
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
    public boolean IngresarArtista(String nickname, String nombre, String apellido,String correo, Date fechaNac, String biografia, String paginaWeb, String img){
        if (this.artistas.get(nickname)!=null){
            return false;
        }else{
            Artista a=new Artista(nickname, nombre, apellido, correo, fechaNac, biografia, paginaWeb, img);
            boolean tru =this.dbUsuario.agregarArtista(a);
            if (tru){
            
                this.artistas.put(nickname, a);
            }
            return tru;
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
        List<DtArtista> retornar=new ArrayList<DtArtista>();
        Set set = artistas.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            Artista aux=(Artista) mentry.getValue();     
            if (aux.getNickname().contains(nombre)){
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
    public ArrayList<DtGenero> listarGeneros(String nombreG){
        ArrayList<DtGenero> resultado= new ArrayList<>();
        for(Genero g:this.generos.values()){
            if(g.getNombre().contains(nombreG))
                resultado.add(g.getDatos(resultado));
        }
        
        return resultado;
    }
}
