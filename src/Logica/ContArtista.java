/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ //helloupapaguenos
package Logica;

import java.util.HashMap;
import java.util.Map;
import Persistencia.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class ContArtista implements IcontArtista {

    private static ContArtista instancia;

    private Map<String, Artista> artistas;
    private Map<String, Genero> generos;
    private DBUsuario dbUsuario;
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
    }

    public Map<String, DtGenero> GetDataGeneros(){
        Map<String, DtGenero> datageneros = new HashMap();
        Set set = this.generos.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            Map.Entry m = (Map.Entry) it.next();
            Genero g = (Genero) m.getValue();
            DtGenero dt = new DtGenero(g.getNombre(),g.getidpadre(),g.getid(),g.getPadre());
            datageneros.put(dt.getNombre(), dt);
        }
        return datageneros;
    }
    
    @Override
    public void SetContCliente(IcontCliente cli) {
        this.Cli = cli;
    }
    
    @Override
    public DtArtista ElegirArtista(String nomArtista) {
        Artista a = (Artista) this.artistas.get(nomArtista);
        return a.getDatos();
    }
    
    public DtAlbum ElegirAlbum(String nomArtista, String nomAlb) {
        Artista art = this.artistas.get(nomArtista);
        return art.getAlbumes().get(nomAlb).getDatos();
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
    public ArrayList<DtAlbum> listarTodosAlbumes() {
        ArrayList<DtAlbum> albumes = new ArrayList();
        Set set = this.artistas.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            Artista aux = (Artista) m.getValue();
            Iterator it2 = aux.getDtAlbumes().iterator();
            while (it2.hasNext()) {
                DtAlbum dt = (DtAlbum) it2.next();
                albumes.add(dt);
            }
        }
        return albumes;
    }

    @Override
    public ArrayList<DtTema> listarTodosTemas() {
        ArrayList<DtTema> temas = new ArrayList();
        Set set = this.artistas.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            Artista aux = (Artista) m.getValue();
            Iterator it2 = aux.getDtAlbumes().iterator();
            while (it2.hasNext()) {
                DtAlbum dt = (DtAlbum) it2.next();
                ArrayList<DtTema> temas1 = dt.getTemas();
                for (int i = 0; i < temas1.size(); i++) {
                    DtTema dtt = temas1.get(i);
                    temas.add(dtt);
                }
            }
        }
        return temas;
    }

    @Override
    public ArrayList<DtCliente> listarSeguidores(String nick) {
        return this.Cli.getSeguidores(nick);
    }

    public ArrayList<DtAlbum> listarAlbumGenero(String genero) {
        ArrayList<DtAlbum> albumes = new ArrayList<>();

        Genero generoPadre = this.generos.get(genero);
        albumes.addAll(generoPadre.getDtAlbumes());

        ArrayList<DtGenero> generosHijos = generoPadre.getDatos(this.buscaHijos(generoPadre.getNombre())).getHijos();

        for (DtGenero generoHijo : generosHijos) {
            albumes.addAll(generoHijo.getAlbumes());
        }

        //Eliminar albumes repetidos
        for (int i = 0; i < albumes.size(); i++) {
            DtAlbum album = albumes.get(i);
            if (albumRepetido(album.getNombre(), albumes) == true) {
                albumes.remove(album);
                i--; // resta uno al indice porque se acaba de eliminar un album, sino se saltea el siguiente
            }
        }

        return albumes;
//        return albumesAux;
    }

    public boolean albumRepetido(String nomAlbum, ArrayList<DtAlbum> albumes) {
        int ocurrencias = 0;
        for (DtAlbum album : albumes) {
            if (album.getNombre().equals(nomAlbum)) {
                ocurrencias++;
            }
        }

        if (ocurrencias > 1) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> BuscarGenero(String palabra) {
        ArrayList<String> retornar = new ArrayList<>();
        Iterator iterator = this.generos.values().iterator();
        while (iterator.hasNext()) {
            Genero aux = (Genero) iterator.next();

            //Pasa los strings a mayusculas para comparar mejor
            String genero = aux.getNombre().toUpperCase();
            palabra = palabra.toUpperCase();

            if (genero.startsWith(palabra)) {
                if (!genero.equals("GÉNERO"))
                    retornar.add(aux.getNombre());
            }
        }
        return retornar;

    }

    public ArrayList<DtArtista> BuscarArtista(String palabra) {
        ArrayList<DtArtista> retornar = new ArrayList<>();
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

            if (nickname.startsWith(palabra) || nombre.startsWith(palabra) || apellido.contains(palabra) || nombrecompleto.startsWith(palabra)) {
                retornar.add(aux.getDatosResumidos());
            }
        }
        return retornar;
    }

    public ArrayList<DtAlbum> listarAlbumArtista(String nickname) {
        return this.artistas.get(nickname).getDtAlbumes();
    }

    public ArrayList<DtTema> obtenerTema(String artista, String album) {
        Artista art = this.artistas.get(artista);
        return art.getAlbumes().get(album).getDtTemas();
    }

    public boolean descargarArchivo(String rutaArchivo, String carpetaDestino, String nickArtista, String nombreTema) {
        Artista artista = this.artistas.get(nickArtista);

        //El archivo descargado quedaria con el nombre "NombreArt ApellidoArt - nombreTema.mp3"
        String rutaDestino = carpetaDestino + "/" + artista.getNombre() + " " + artista.getApellido() + " - " + nombreTema + ".mp3";

        return Fabrica.getCliente().copiarArchivo(rutaArchivo, rutaDestino);
    }
    
    @Override
    public boolean IngresarArtista(String nickname,String contrasenia, String nombre, String apellido, String correo, Date fechaNac, String biografia, String paginaWeb, String Img) {
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
            if (Fabrica.getCliente().copiarArchivo(Img, rutaDestino) == true) {
                Img = rutaDestino; //la ruta que hay que guardar es la del archivo nuevo que fue copiado dentro del servidor
            } else {
                Img = null; // no se pudo copiar la imagen, queda en null
            }
        }

        Artista a = new Artista(nickname, contrasenia, nombre, apellido, correo, fechaNac, biografia, paginaWeb, Img);
        boolean ok = this.dbUsuario.agregarArtista(a);
        if (ok) {
            this.artistas.put(nickname, a);
        }

        return ok;
    }
    @Override
    public boolean IngresarArtista(DtArtista art) {
        if (Fabrica.getCliente().verificarDatos(art.getNickname(), art.getCorreo()) == false) { // si ya existe un cliente con ese nickname o correo
            return false;
        } else {
            if (this.verificarDatos(art.getNickname(), art.getCorreo()) == false) {
                return false;
            }
        }
        try{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaN = formato.parse(art.getFechaNac());
        
          Artista a = new Artista(art.getNickname(),art.getContrasenia(),art.getNombre(),art.getApellido(),art.getCorreo(),fechaN,art.getBiografia(),art.getPagWeb(),null);
          boolean tru = this.dbUsuario.agregarArtistaWeb(a);
        if (tru) {

            this.artistas.put(art.getNickname(), a);
        }
        return tru;
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public void IngresarAlbum(String nicknameArt, String anio, String nombre, String imagen, HashMap<String, DtTema> temas, HashMap<String, DtGenero> generos) {
        int anio2 = Integer.parseInt(anio);
        HashMap<String, Tema> temasfinal = new HashMap();
        Set set3 = temas.entrySet();
        Iterator it0 = set3.iterator();
        while (it0.hasNext()) {
            Map.Entry x = (Map.Entry) it0.next();
            DtTema dtte = (DtTema) x.getValue();
            
            String rutaDestino = null; //ruta de destino del archivo
            
            //Si el tema tiene un archivo
            if(dtte.getArchivo() != null){
                //ruta del archivo seleccionado para el tema
                String rutaOrigen = dtte.getArchivo(); 

                //Se crea la ruta del archivo del tema dentro del servidor -> "Temas/nickArtista/nomAlbum/tema.mp3"
                rutaDestino = "Temas/"+nicknameArt+"/"+nombre+"/"+dtte.getNombre()+".mp3";

                //Si NO pudo copiar el archivo correctamente deja a ruta en null
                if(Fabrica.getCliente().copiarArchivo(rutaOrigen, rutaDestino) == false){
                    rutaDestino = null; 
                }
            }
            
            Tema t = new Tema(dtte.getDuracion(), dtte.getNombre(), dtte.getOrden(), rutaDestino, dtte.getDireccion(), nombre, nicknameArt);
            temasfinal.put(t.getNombre(), t);
        }
        ArrayList<Genero> l = new ArrayList();
        Set set2 = generos.entrySet();
        Iterator iter = set2.iterator();
        while (iter.hasNext()) {
            Map.Entry x = (Map.Entry) iter.next();
            DtGenero dtgen = (DtGenero) x.getValue();
            Genero g = this.generos.get(dtgen.getNombre());
            l.add(g);
        }
        
        String rutaDestino = null; //ruta de destino del archivo
            
        //Si el album tiene una imagen
        if(imagen != null){
            //ruta del archivo seleccionado para el tema
            String rutaOrigen = imagen; 
            
            //Divide el string por el punto, tambien elimina el punto
            String[] aux = imagen.split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial
            
            //toma la segunda parte porque es la extension
            //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
            String extension = aux[1];

            //Se crea la ruta del archivo del tema dentro del servidor -> "Imagenes/nickArtista/nomAlbum/tema.mp3"
            rutaDestino = "Imagenes/"+nicknameArt+"/Albumes/"+nombre+"." +extension;

            //Si NO pudo copiar el archivo correctamente deja a ruta en null
            if(Fabrica.getCliente().copiarArchivo(rutaOrigen, rutaDestino) == false){
                rutaDestino = null; 
            }
        }
        
        Album a = new Album(nicknameArt, nombre, anio2, rutaDestino, temasfinal, l);
        int idalbum = this.dbUsuario.InsertarAlbum(a);
        a.setId(idalbum);
        for (int i = 0; i < l.size(); i++) {
            l.get(i).AddAlbum(a);
        }
        Artista ar = artistas.get(nicknameArt);
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
            if (nick.startsWith(palabra) == true || nombre.startsWith(palabra) == true || apellido.startsWith(palabra) == true || nomAp.startsWith(palabra) == true) {
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
    public List<DtArtista> BuscarArtista2(String nickname,String correo) {
        List<DtArtista> retornar = new ArrayList<>();
        Set set = artistas.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Artista aux = (Artista) mentry.getValue();
            if (aux.getCorreo().toUpperCase().equals(correo.toUpperCase()) || aux.getNickname().toUpperCase().equals(nickname.toUpperCase())) {
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
    public boolean ControlDeAlbum(String cadenaart, String cadenanom){
    if (this.artistas.get(cadenaart).getAlbumes().get(cadenanom)!=null)
        return false;
    else
        return true;
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
        nombre = nombre.toLowerCase();
        String[] palabras = nombre.split("\\s+");
        nombre = "";
        for (int i=0;i<palabras.length;i++){
            palabras[i].toLowerCase();
            palabras[i] = palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1);
            if (i==0)
                nombre = nombre + palabras[i];           
            else
                nombre = nombre + " " + palabras[i];
        }
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

    @Override
    public boolean ExisteListaPD(String lista) {
        for (Genero g : this.generos.values()) {
            if (g.getListas().containsKey(lista)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Album getAlbum(String Artista, String Album) {
        Artista a = this.artistas.get(Artista);
        return a.getAlbumes().get(Album);
    }

    @Override
    public Tema getTema(String Artista, String Album, String Tema) {
        Artista a = this.artistas.get(Artista);
        return a.getAlbumes().get(Album).getTema(Tema);
    }

    @Override
    public PorDefecto getListaPD(String Nombre) {
        for (Genero g : this.generos.values()) {
            if (g.getListas().containsKey(Nombre)) {
                return g.getListas().get(Nombre);
            }
        }
        return null;
    }

    @Override
    public boolean ArtistasVacio() {
        return this.artistas.isEmpty();
    }

    public boolean GenerosVacio() {
        return this.generos.isEmpty();
    }
    
    @Override
    public boolean estaAlbum(String Nickname, String Album) {
        return artistas.get(Nickname).getAlbumes().containsKey(Album);
    }
    
    
    @Override
    public boolean estaArtista(String nickname, String correo) {
        List<DtArtista> artista = BuscarArtista2(nickname,correo);
        if(artista.isEmpty())
            return false;
        
        return true;
    }
    
    @Override
    public boolean Pagweb(String pagweb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public DtUsuario verificarLoginArtista(String nickname, String contrasenia) {
        for (Artista art : this.artistas.values()) {
            if(((art.getNickname().equals(nickname))||(art.getCorreo().equals(nickname)))&&(art.getContrasenia().equals(contrasenia))){
                return art.getDatosResumidos(); // nickname o correo incorrecto
            }
        }
        return this.Cli.verificarLoginCliente(nickname, contrasenia);
    }
    
    @Override
    public BufferedInputStream cargarTema(String rutaTema){
        try {
            File archivo = new File(rutaTema);
            FileInputStream input = new FileInputStream(archivo);
            BufferedInputStream buf = new BufferedInputStream(input);            
            return buf;
        } catch (IOException ex) {
            Logger.getLogger(ContCliente.class.getName()).log(Level.SEVERE, null, ex);            
            return null;
        }
    }
}
