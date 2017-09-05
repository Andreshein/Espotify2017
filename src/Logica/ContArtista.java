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
    private DBUsuario dbUsuario = null;
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

    public Map<String, Genero> GetGeneros() {
        return this.generos;
    }

    public void SetContCliente(IcontCliente cli) {
        this.Cli = cli;
    }

    public Map<String, Artista> GetArtistas() {
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
    public ArrayList<DtAlbum> listarAlbumesArtista(String nick) {
        Artista art = (Artista) this.artistas.get(nick);
        return art.getDtAlbumes();
    }

    @Override
    public ArrayList<DtCliente> listarSeguidores(String nick) {
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

    public ArrayList<DtAlbum> listarAlbumGenero(String genero){
        ArrayList<DtAlbum> albumes = new ArrayList<>();
        
        Genero generoPadre = this.generos.get(genero);
        albumes.addAll(generoPadre.getDtAlbumes());
        
        ArrayList<DtGenero> generosHijos = generoPadre.getDatos(this.buscaHijos(generoPadre.getNombre())).getHijos();
        
        for (DtGenero generoHijo : generosHijos) {
            albumes.addAll(generoHijo.getAlbumes());
        }        
        
        //Eliminar albumes repetidos
        for(int i= 0; i < albumes.size(); i++){
            DtAlbum album = albumes.get(i);
            if( albumRepetido(album.getNombre(), albumes) == true ){
                albumes.remove(album);
                i--; // resta uno al indice porque se acaba de eliminar un album, sino se saltea el siguiente
            }
        }
        
        
        return albumes;
//        return albumesAux;
   }
    
    public boolean albumRepetido(String nomAlbum, ArrayList<DtAlbum> albumes){
        int ocurrencias = 0;
        for(DtAlbum album: albumes){
            if(album.getNombre().equals(nomAlbum)){
                ocurrencias++;
            }
        }

        if(ocurrencias > 1){
            return true;
        }else{
            return false;
        }        
    }
    
    public ArrayList<String> BuscarGenero(String palabra){
        ArrayList<String> retornar=new ArrayList<>();

       Iterator iterator = this.generos.values().iterator();
        while (iterator.hasNext()) {
            Genero aux = (Genero) iterator.next();

            //Pasa los strings a mayusculas para comparar mejor
            String genero = aux.getNombre().toUpperCase();
            palabra = palabra.toUpperCase();
            
            if(genero.startsWith(palabra)){
                retornar.add(aux.getNombre());

            }
        }
        return retornar;

   }
   
    public ArrayList <DtArtista> BuscarArtista(String palabra) {
        ArrayList<DtArtista> retornar=new ArrayList<>();
        Iterator iterator = this.artistas.values().iterator();
        while (iterator.hasNext()) {
            Artista aux = (Artista) iterator.next();

            //Pasa los strings a mayusculas para comparar mejor
            palabra = palabra.toUpperCase();
            String nickname = aux.getNickname().toUpperCase();
            String nombre = aux.getNombre().toUpperCase();
            String apellido = aux.getApellido().toUpperCase();
            String nombrecompleto = aux.getNombre() + " " + aux.getApellido();
            nombrecompleto = nombrecompleto.toUpperCase();
            
            if(nickname.startsWith(palabra) || nombre.startsWith(palabra) || apellido.contains(palabra) || nombrecompleto.startsWith(palabra)){
                retornar.add(aux.getDatosResumidos());   
            }
        }
        return retornar;
    }

   public ArrayList<DtAlbum> listarAlbumArtista(String nickname){
        return this.artistas.get(nickname).getDtAlbumes();
   }
    
    public ArrayList <DtTema> obtenerTema (String artista, String album){
       Artista art = this.artistas.get(artista);
       return art.getAlbumes().get(album).getDtTemas();
    }
    
    public boolean descargarArchivo(String rutaArchivo, String carpetaDestino, String nickArtista, String nombreTema){
        Artista artista = this.artistas.get(nickArtista);
        
        //El archivo descargado quedaria con el nombre "NombreArt ApellidoArt - nombreTema.mp3"
        String rutaDestino = carpetaDestino+"/"+artista.getNombre()+" "+artista.getApellido()+" - "+nombreTema+".mp3";
        
        return Fabrica.getCliente().copiarArchivo(rutaArchivo, rutaDestino);
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
    public void corregir(String nickname, String nombre, String apellido, String correo, Date fechaNac, ImageIcon imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean IngresarArtista(String nickname, String nombre, String apellido, String correo, Date fechaNac, String biografia, String paginaWeb, String Img) {
        if (Fabrica.getCliente().verificarDatos(nickname, correo) == false) { // si ya existe un cliente con ese nickname o correo
            return false;
        } else {
            if (this.verificarDatos(nickname, correo) == false) {
                return false;
            }
        }

        //Si no retorno false antes, entonces los datos están bien
        if (Img != null) {
            //Divide el string por el punto, tambien elimina el punto
            String[] aux = Img.split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial

            //toma la segunda parte porque es la extension
            //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
            String extension = aux[1];

            //Ruta donde se va a copiar el archivo de imagen
            String rutaDestino = "Imagenes/Artistas/" + nickname + "/" + nickname + "." + extension; // se le agrega el punto(.) porque la hacer el split tambien se borra

            //esa funcion retorna un booleano que indica si la imagen se pudo crear correctamente
            //la funcion ya esta definida en el controlador de cliente porque ahi se usa, entocnces no hay que declararla otra vez en este controlador
            if(Fabrica.getCliente().copiarArchivo(Img, rutaDestino) == true){
                Img = rutaDestino; //la ruta que hay que guardar es la del archivo nuevo que fue copiado dentro del servidor
            } else {
                Img = null; // no se pudo copiar la imagen, queda en null
            }
        }

        Artista a = new Artista(nickname, nombre, apellido, correo, fechaNac, biografia, paginaWeb, Img);
        boolean ok = this.dbUsuario.agregarArtista(a);
        if (ok) {
            this.artistas.put(nickname, a);
        }

        return ok;
    }

    public void IngresarAlbum(String nomartista, String anio, String nombre, String imagen, HashMap<String, Tema> temas, HashMap<String, Genero> generos) {
        int anio2 = Integer.parseInt(anio);
        ArrayList<Genero> l = new ArrayList();
        Set set2 = generos.entrySet();
        Iterator iter = set2.iterator();
        while (iter.hasNext()) {
            Map.Entry x = (Map.Entry) iter.next();
            Genero gen = (Genero) x.getValue();
            l.add(gen);
        }
        Album a = new Album(nomartista, nombre, anio2, imagen, temas, l);
        int idalbum = this.dbUsuario.InsertarAlbum(a);
        for (int i = 0; i < l.size(); i++) {
            l.get(i).AddAlbum(a);
        }
        Artista ar = artistas.get(nomartista);
        ar.getAlbumes().put(a.getNombre(), a);
        for (int i = 0; i < a.getGeneros().size(); i++) {
            int idg = a.getGeneros().get(i).getid();
            this.dbUsuario.InsertarGenero_Album(idalbum, idg);
        }
        Set set = a.getTemas().entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
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
            String nomAp = aux.getNombre().toUpperCase() + aux.getApellido().toUpperCase();
            if (nick.contains(palabra) == true || nombre.contains(palabra) == true || apellido.contains(palabra) == true || nomAp.contains(palabra) == true) {
                retornar.add(aux.getDatos());
            }
        }
        return retornar;
    }

    public void AgregarTemaListaG(String nickname, String Album, String Tema, String Genero, String Lista) throws Exception {
        Artista a = this.artistas.get(nickname);
        Album al = a.getAlbumes().get(Album);
        Tema t = al.getTema(Tema);
        Genero g = this.generos.get(Genero);
        PorDefecto pd = g.getListas().get(Lista);
        if (pd.getTemas().contains(t)) {
            throw new Exception("El tema ya esta en la lista");
        }
        pd.AddTema(t);
        this.dbUsuario.agregarTemaListaPD(pd.getId(), t.getNombre(), al.getNombre(), al.getArtista());
    }

    public void AgregarTemaListaC(String nickname, String Album, String Tema, String Cliente, String Lista) throws Exception {
        Artista a = this.artistas.get(nickname);
        Album al = a.getAlbumes().get(Album);
        Tema t = al.getTema(Tema);
        Cliente c = this.Cli.BuscarUsuariosC(Cliente);
        Particular p = c.getListas().get(Lista);
        if (p.getTemas().contains(t)) {
            throw new Exception("El tema ya esta en la lista");
        }
        p.AddTema(t);
        this.dbUsuario.agregarTemaListaP(p.getId(), t.getNombre(), al.getNombre(), al.getArtista());
    }

    public void BorrarTemaListaG(String nickname, String Album, String Tema, String Genero, String Lista) throws Exception {
        Artista a = this.artistas.get(nickname);
        Album al = a.getAlbumes().get(Album);
        Tema t = al.getTema(Tema);
        Genero g = this.generos.get(Genero);
        PorDefecto pd = g.getListas().get(Lista);
        if (!pd.getTemas().contains(t)) {
            throw new Exception("El tema no esta en la lista");
        }
        pd.getTemas().remove(t);
        this.dbUsuario.BorrarTemaListaPD(pd.getId(), t.getNombre(), al.getNombre(), al.getArtista());
    }

    public void BorrarTemaListaC(String nickname, String Album, String Tema, String Cliente, String Lista) throws Exception {
        Artista a = this.artistas.get(nickname);
        Album al = a.getAlbumes().get(Album);
        Tema t = al.getTema(Tema);
        Cliente c = this.Cli.BuscarUsuariosC(Cliente);
        Particular p = c.getListas().get(Lista);
        if (!p.getTemas().contains(t)) {
            throw new Exception("El tema no esta en la lista");
        }
        p.getTemas().remove(t);
        this.dbUsuario.BorrarTemaListaP(p.getId(), t.getNombre(), al.getNombre(), al.getArtista());
    }

    public Usuario seleccionarUsuario(String Nickname) {
        return (Usuario) this.artistas.get(Nickname);
    }

    public DtGenero listarGArbol() {
        Genero g = this.generos.get("Género");
        return g.getDatos(this.buscaHijos(g.getNombre()));
    }

    private ArrayList<DtGenero> buscaHijos(String nombre) {
        ArrayList<DtGenero> a = new ArrayList<>();
        Iterator it = this.generos.values().iterator();
        while (it.hasNext()) {
            Genero g = (Genero) it.next();
            if (g.getPadre() != null) {
                if (g.getPadre().getNombre().equals(nombre)) {
                    DtGenero dtg = g.getDatos(this.buscaHijos(g.getNombre()));
                    a.add(dtg);
                }
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
        List<DtArtista> retornar = new ArrayList<>();
        Set set = artistas.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Artista aux = (Artista) mentry.getValue();
            if (aux.getNickname().toUpperCase().startsWith(nombre.toUpperCase())) {
                retornar.add(aux.GetDtArtista());
            }
        }
        return retornar;
    }

    @Override
    public ArrayList<DtListaPD> ListarListaPD() {
        ArrayList<DtListaPD> retorno = new ArrayList<DtListaPD>();
        for (Genero g : this.generos.values()) {
            retorno.addAll(g.getDtListas());
        }
        return retorno;
    }

    @Override
    public ArrayList<DtAlbum> ListarAlbum() {
        ArrayList<DtAlbum> al = new ArrayList<DtAlbum>();
        for (Artista a : this.artistas.values()) {
            al.addAll(a.getDtAlbumes());
        }
        return al;
    }

    public Genero getGenero(String nombre) {
        return this.generos.get(nombre);
    }

    @Override
    public ArrayList<DtTema> listarTemasListaPD(String listaPD, String nombreG) {
        Genero g = (Genero) this.generos.get(nombreG);
        PorDefecto pd = g.getListas().get(listaPD);
        return pd.getDtTemas();
    }

    @Override
    public ArrayList<DtTema> listarTemasListaA(String nickname, String nombre) {
        Artista a = (Artista) this.artistas.get(nickname);
        Album al = (Album) a.getAlbumes().get(nombre);
        return al.getDtTemas();
    }

    @Override
    public ArrayList<DtGenero> listarGeneros(String nombreG) {
        ArrayList<DtGenero> resultado = new ArrayList<>();
        for (Genero g : this.generos.values()) {
            if (g.getNombre().contains(nombreG)) {
                resultado.add(g.getDatos(resultado));
            }
        }

        return resultado;
    }

    @Override
    public boolean verificarDatos(String nickname, String correo) {
        for (Artista art : this.artistas.values()) {
            if (art.getNickname().equals(nickname)) {
                return false; // nickname ya existe, repetido
            }

            if (art.getCorreo().equals(correo)) {
                return false; //correo ya existe, repetido
            }
        }

        //Si no retornó false dentro del for, entonces los datos estan bien
        return true;
    }

    @Override
    public void CrearGenero(String nombre, String padre) throws Exception {
        if (!this.generos.containsKey(nombre)) {
            Genero gpadre = this.generos.get(padre);
            Genero g = new Genero(0, nombre, gpadre.getid());
            g.setPadre(gpadre);
            this.generos.put(nombre, g);
            this.dbUsuario.insertarGenero(g);
        } else {
            throw new Exception("Ya existe el genero");
        }
    }

}
