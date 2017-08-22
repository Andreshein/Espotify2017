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
    public Genero buscar(Genero nombre) {
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
            if (aux.getNickname().contains(palabra) == true || aux.getNombre().contains(palabra) == true || aux.getApellido().contains(palabra) == true) {
                retornar.add(aux.getDatos());
            }
        }
        return retornar;
    }

    public Usuario seleccionarUsuario(String Nickname) {
        return (Usuario) this.artistas.get(Nickname);
    }
    public void CargarDatos(){
        this.artistas = dbUsuario.cargarArtistas();// cargar colección de artistas
        Map<Integer, Album> albumes=new HashMap();
        //Map<String, Genero> generos0=new HashMap();
        Map<Integer, Tema> temas=new HashMap();
        Map<Integer, PorDefecto> ListaPD=new HashMap();
        //this.setGenero((HashMap)generos0);
        albumes = dbUsuario.cargarAlbumes();
        this.generos = dbUsuario.cargarGenero();
        temas = dbUsuario.cargarTema();
        ListaPD = dbUsuario.cargarListaPD();
        Artista vp = artistas.get("vpeople");
        Artista dm = artistas.get("dmode");
        Artista cl = artistas.get("clauper");
        Artista bs = artistas.get("bruceTheBoss");
        Artista tn = artistas.get("tripleNelson");
        Artista ll = artistas.get("la_ley");
        Artista tj = artistas.get("tigerOfWales");
        Artista pt = artistas.get("chaiko");
        Artista nn = artistas.get("nicoleneu");
        Artista pi = artistas.get("lospimpi");
        Artista dy = artistas.get("dyangounchained");
        Artista al = artistas.get("alcides");
        Album album1 = albumes.get(1);
        Album album2 = albumes.get(2);
        Album album3 = albumes.get(3);
        Album album4 = albumes.get(4);
        Album album5 = albumes.get(5);
        Album album6 = albumes.get(6);
        Album album7 = albumes.get(7);
        Album album8 = albumes.get(8);
        Album album9 = albumes.get(9);
        Album album10 = albumes.get(10);
        Album album11 = albumes.get(11);
        Album album12 = albumes.get(12);
        Album album13 = albumes.get(13);
        vp.getAlbumes().put(album1.getNombre(), album1); //cargar albumes en artistas determinados
        dm.getAlbumes().put(album2.getNombre(), album2);
        cl.getAlbumes().put(album3.getNombre(), album3);
        bs.getAlbumes().put(album4.getNombre(), album4);
        tj.getAlbumes().put(album5.getNombre(), album5);
        tn.getAlbumes().put(album6.getNombre(), album6);
        ll.getAlbumes().put(album7.getNombre(), album7);
        pt.getAlbumes().put(album8.getNombre(), album8);
        pt.getAlbumes().put(album9.getNombre(), album9);
        nn.getAlbumes().put(album10.getNombre(), album10);
        pi.getAlbumes().put(album11.getNombre(), album11);
        dy.getAlbumes().put(album12.getNombre(), album12);
        al.getAlbumes().put(album13.getNombre(), album13);
        Genero rok = generos.get("Rock");
        Genero rcl = generos.get("Rock Clásico");
        Genero rkl = generos.get("Rock Latino");
        Genero rar = generos.get("Rock & Roll");
        Genero cla = generos.get("Clásica");
        Genero dis = generos.get("Disco");
        Genero pop = generos.get("Pop");
        Genero epo = generos.get("Electropop");
        Genero dpo = generos.get("Dance-pop");
        Genero pcl = generos.get("Pop Clásico");
        Genero gen = generos.get("Género");
        Genero bal = generos.get("Balada");
        Genero cum = generos.get("Cumbia");
        rok.setPadre(gen); //darle a los generos su padre
        pop.setPadre(gen);
        cla.setPadre(gen);
        dis.setPadre(gen);
        bal.setPadre(gen);
        cum.setPadre(gen);
        rcl.setPadre(rok);
        rkl.setPadre(rok);
        rar.setPadre(rok);
        epo.setPadre(pop);
        dpo.setPadre(pop);
        pcl.setPadre(pop);
        rkl.AddAlbum(album6);  //agregar albumes a sus generos determinados
        rkl.AddAlbum(album7);
        rcl.AddAlbum(album4);
        rcl.AddAlbum(album5);
        rar.AddAlbum(album4);
        pcl.AddAlbum(album1);
        pcl.AddAlbum(album3);
        pcl.AddAlbum(album4);
        pcl.AddAlbum(album5);
        pcl.AddAlbum(album7);
        pcl.AddAlbum(album11);
        pcl.AddAlbum(album12);
        epo.AddAlbum(album2);
        epo.AddAlbum(album10);
        dis.AddAlbum(album1);
        dpo.AddAlbum(album1);
        dpo.AddAlbum(album3);
        cum.AddAlbum(album13);
        cla.AddAlbum(album8);
        cla.AddAlbum(album9);
        bal.AddAlbum(album11);
        bal.AddAlbum(album12);
        album1.AddGenero(dis); //agregar generos a sus albumes determinados
        album1.AddGenero(dpo);
        album1.AddGenero(pcl);
        album2.AddGenero(epo);
        album3.AddGenero(pcl);
        album3.AddGenero(dpo);
        album4.AddGenero(rcl);
        album4.AddGenero(rar);
        album4.AddGenero(pcl);
        album5.AddGenero(pcl);
        album5.AddGenero(rcl);
        album6.AddGenero(rkl);
        album7.AddGenero(rkl);
        album7.AddGenero(pcl);
        album8.AddGenero(cla);
        album9.AddGenero(cla);
        album10.AddGenero(epo);
        album11.AddGenero(pcl);
        album11.AddGenero(bal);
        album12.AddGenero(pcl);
        album13.AddGenero(bal);
        album13.AddGenero(cum);
        Tema t1 = temas.get(1);
        Tema t2 = temas.get(2);
        Tema t3 = temas.get(3);
        Tema t4 = temas.get(4);
        Tema t5 = temas.get(5);
        Tema t6 = temas.get(6);
        Tema t7 = temas.get(7);
        Tema t8 = temas.get(8);
        Tema t9 = temas.get(9);
        Tema t10 = temas.get(10);
        Tema t11 = temas.get(11);
        Tema t12 = temas.get(12);
        Tema t13 = temas.get(13);
        Tema t14 = temas.get(14);
        Tema t15 = temas.get(15);
        Tema t16 = temas.get(16);
        Tema t17 = temas.get(17);
        Tema t18 = temas.get(18);
        Tema t19 = temas.get(19);
        Tema t20 = temas.get(20);
        album1.AddTema(t1);  //agregar temas a los albumes
        album1.AddTema(t2);
        album1.AddTema(t3);
        album2.AddTema(t4);
        album2.AddTema(t5);
        album3.AddTema(t6);
        album3.AddTema(t7);
        album4.AddTema(t8);
        album4.AddTema(t9);
        album4.AddTema(t10);
        album5.AddTema(t11);
        album6.AddTema(t12);
        album7.AddTema(t13);
        album7.AddTema(t14);
        album8.AddTema(t15);
        album9.AddTema(t16);
        album10.AddTema(t17);
        album11.AddTema(t18);
        album12.AddTema(t19);
        album13.AddTema(t20);
        PorDefecto lpd1 = ListaPD.get(1);
        PorDefecto lpd2 = ListaPD.get(2);
        PorDefecto lpd3 = ListaPD.get(3);
        this.ListasPorDef.put(lpd1.getNombre(),lpd1);
        this.ListasPorDef.put(lpd2.getNombre(),lpd2);
        this.ListasPorDef.put(lpd3.getNombre(),lpd3);
        lpd1.setGenero(pcl); //Agregar genero a listas por defecto
        lpd2.setGenero(rkl);
        lpd3.setGenero(cla);
        lpd1.AddTema(t1); //Agregar temas a las listas por defecto
        lpd1.AddTema(t2);
        lpd1.AddTema(t3);
        lpd1.AddTema(t6);
        lpd1.AddTema(t7);
        lpd1.AddTema(t8);
        lpd1.AddTema(t9);
        lpd1.AddTema(t10);
        lpd1.AddTema(t11);
        lpd2.AddTema(t12);
        lpd2.AddTema(t13);
        lpd2.AddTema(t14);
        lpd3.AddTema(t15);
        lpd3.AddTema(t16);
        pcl.AddLista(lpd1); //Agregar lista por defecto a los generos
        rkl.AddLista(lpd2);
        cla.AddLista(lpd3);
    }
    
    private ArrayList<DtGenero> buscaHijos(String nombre){
        ArrayList<DtGenero> a = new ArrayList<>();
        Iterator it = this.generos.values().iterator();
        while(it.hasNext()){
            Genero g = (Genero)it.next();
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
    
}
