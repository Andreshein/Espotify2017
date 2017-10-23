/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import Persistencia.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ContCliente implements IcontCliente {

    private static ContCliente instancia;

    private Map<String, Cliente> clientes;
    private Map<Integer, TipoSuscripcion> tiposDeSuscripcion;
    private DBUsuario dbUsuario = null;
    private IcontArtista art;
    private Lista lista;
    private Genero genero;
    private Cliente cliente;

    public static ContCliente getInstance() {
        if (instancia == null) {
            instancia = new ContCliente();
        }
        return instancia;
    }

    private ContCliente() {

        this.clientes = new HashMap<>();
        this.dbUsuario = new DBUsuario();
        this.tiposDeSuscripcion = new HashMap();
        //this.art = Fabrica.getArtista()
        this.lista = null;
        this.genero = null;
        this.cliente = null;
    }

    public void addSuscripcion(TipoSuscripcion ts) {
        this.tiposDeSuscripcion.put(ts.getId(), ts);
    }

    public Map<String, Cliente> GetClientes() {
        return this.clientes;
    }

    public void SetContArtista(IcontArtista art) {
        this.art = art;
    }

    @Override
    public ArrayList<String> listarNickClientes() {
        ArrayList<String> listaNicknames = new ArrayList<>();

        for (Cliente cliente : this.clientes.values()) {
            listaNicknames.add(cliente.getNickname());
        }

        return listaNicknames;
    }

    @Override
    public DtCliente verPerfilCliente(String nickname) {
        return this.clientes.get(nickname).getDatos();
    }

    @Override
    public void DejarSeguir(String NickCli, String NickUsu) {
        Cliente cli = (Cliente) this.clientes.get(NickCli);
        cli.dejarSeguir(NickUsu);
        this.dbUsuario.DejarSeguirUsu(NickCli, this.seleccionarUsuario(NickUsu));
    }

    @Override
    public void confirmar() throws Exception {
        if (this.lista instanceof Particular) {
            Particular p = (Particular) this.lista;
            if (!this.cliente.getListas().containsKey(p.getNombre())) {
                p.setUsuario(this.cliente.getNickname());
                this.cliente.AddLista(p);
                p.setId(this.dbUsuario.insertarlista(p));
            } else {
                throw new Exception("El cliente ya tiene una lista con ese nombre");
            }
        } else {
            PorDefecto pd = (PorDefecto) this.lista;
            if (!this.art.ExisteListaPD(lista.getNombre())) {
                pd.setGenero(this.genero);
                this.genero.AddLista(pd);
                pd.setId(this.dbUsuario.insertarlista(pd));
            } else {
                throw new Exception("Ya tiene una lista con ese nombre");
            }
        }
    }

    @Override
    public boolean IngresarCliente(String nickname, String contrasenia, String nombre, String apellido, String correo, Date fechaNac, String Img) {
        if (Fabrica.getArtista().verificarDatos(nickname, correo) == false) { // si ya existe un artista con ese nickname o correo
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
            String rutaDestino = "Imagenes/Clientes/" + nickname + "/" + nickname + "." + extension; // se le agrega el punto(.) porque la hacer el split tambien se borra

            //esa funcion retorna un booleano que indica si la imagen se pudo crear correctamente
            if (copiarArchivo(Img, rutaDestino) == true) {
                Img = rutaDestino; //la ruta que hay que guardar es la del archivo nuevo que fue copiado dentro del servidor
            } else {
                Img = null; // no se pudo copiar la imagen, queda en null
            }
        }

        Cliente c = new Cliente(nickname, contrasenia, nombre, apellido, correo, fechaNac, Img);

        boolean tru = this.dbUsuario.agregarCliente(c);
        if (tru) {

            this.clientes.put(nickname, c);
        }
        return tru;

    }

    @Override
    public boolean IngresarCliente(DtCliente cli, byte[] imagen) {
        if (Fabrica.getArtista().verificarDatos(cli.getNickname(), cli.getCorreo()) == false) { // si ya existe un artista con ese nickname o correo
            return false;
        } else {
            if (this.verificarDatos(cli.getNickname(), cli.getCorreo()) == false) {
                return false;
            }
        }
        try{
        String rutaDestino = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaN = formato.parse(cli.getFechaNac());
        if (imagen!=null){
                Properties p = new Properties();
                InputStream is;
                String rutaP = null;
                try {
                    is = new FileInputStream("Configuraciones/rutaProyecto.properties");
                    p.load(is);
                    rutaP = p.getProperty("ruta");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                    rutaDestino = rutaP + "Imagenes/Clientes/" + cli.getNickname() + "/" + cli.getNickname() + ".jpg";
                //rutaDestino = "D:/"+nombre+".jpg";
                try {
                    File f = new File(rutaDestino);
                    f.getParentFile().mkdirs();
                    org.apache.commons.io.FileUtils.writeByteArrayToFile(f, imagen);
                } catch (Exception e) {
                    e.getMessage();
                }  
            }

        Cliente c = new Cliente(cli.getNickname(), cli.getContrasenia(), cli.getNombre(), cli.getApellido(), cli.getCorreo(), fechaN, rutaDestino );

        boolean tru = this.dbUsuario.agregarClienteWeb(c);
        if (tru) {

            this.clientes.put(cli.getNickname(), c);
        }
        return tru;

        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<DtCliente> BuscarClientes(String palabra) {
        ArrayList<DtCliente> retornar = new ArrayList<>();
        Iterator iterador = this.clientes.values().iterator();
        if (palabra.equals("") == false) {
            while (iterador.hasNext()) {
                Cliente aux = (Cliente) iterador.next();

                // toUpperCase convierte todas las letras del string en mayusculas para buscar mejor
                palabra = palabra.toUpperCase();
                String nick = aux.getNickname().toUpperCase();
                String nombre = aux.getNombre().toUpperCase();
                String apellido = aux.getApellido().toUpperCase();
                String nomAp = aux.getNombre().toUpperCase() + aux.getApellido().toUpperCase();

                if (nick.startsWith(palabra) == true || nombre.startsWith(palabra) == true || apellido.startsWith(palabra) == true || nomAp.startsWith(palabra) == true) {
                    retornar.add(aux.getDatos());
                }
            }
        } else {
            System.out.println("Logica.ContCliente.BuscarClientes() -> palabra vacia");
            for (Cliente cliente : this.clientes.values()) {
                retornar.add(cliente.getDatosResumidos());
            }
        }

        return retornar;
    }

    public ArrayList<DtUsuario> BuscarUsuarios(String palabra) {
        ArrayList<DtUsuario> retornar = this.art.BuscarUsuarios(palabra);
        retornar.addAll(this.BuscarClientes(palabra));
        return retornar;
    }

    public void seguir(String nickCli, String nickUsu) throws Exception {
        Cliente cli = (Cliente) this.clientes.get(nickCli);
        boolean control = cli.setSiguiendo(this.seleccionarUsuario(nickUsu));
        if (control) {
            this.dbUsuario.SeguirUsu(nickCli, this.seleccionarUsuario(nickUsu));
        } else {
            throw new Exception("El cliente ya esta siendo seguido");
        }
    }

    public Usuario seleccionarUsuario(String Nickname) {
        Usuario u = this.art.seleccionarUsuario(Nickname);
        if (u == null) {
            u = this.clientes.get(Nickname);
        }
        return u;
    }

    public ArrayList<DtUsuario> BuscarUsuariosSeg(String Nickname, String palabra) {
        Cliente cli = (Cliente) this.clientes.get(Nickname);
        return cli.buscarEnUsuarios(palabra);
    }

    public void CargadeDatos() {
        this.dbUsuario.CargarDatosdePrueba();
        Fabrica.cargarDatos();
    }

    public ArrayList<DtCliente> getSeguidores(String nickname) {
        ArrayList<DtCliente> seguidores = new ArrayList<>();

        for (Cliente cliente : this.clientes.values()) {
            // Busca si el nickname esta en la lista de usuarios seguidos de cada cliente
            if (cliente.getSiguiendo().containsKey(nickname)) {
                seguidores.add(cliente.getDatosResumidos());
            }
        }

        return seguidores;
    }

    public ArrayList<DtGenero> ListarGeneros(String palabra) {
        ArrayList<DtGenero> ret;
        return null;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setCA(IcontArtista art) {
        this.art = art;
    }

    public ArrayList<DtListaP> ListarListaP() {
        ArrayList<DtListaP> devolver = new ArrayList<DtListaP>();
        Set set = clientes.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Cliente aux = (Cliente) mentry.getValue();
            devolver.addAll(aux.ObtenerLista());

        }
        return devolver;
    }

    public ArrayList<DtListaPD> ListarListaPD() {
        return this.art.ListarListaPD();

    }

    public DtGenero listarGArbol() {
        return this.art.listarGArbol();
    }

    public void crearListaP(String Nickname, String nombre, String Img) {
        this.cliente = this.clientes.get(Nickname);
        this.lista = new Particular(0, "x", nombre, true, Img);
        if (Img != null) {
            Properties p = new Properties();
            InputStream is;
            String rutaP = null;
            try {
                is = new FileInputStream("Configuraciones/rutaProyecto.properties");
                p.load(is);
                rutaP = p.getProperty("ruta");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] aux = Img.split("\\.");
            String extension = aux[1];
            String rutaDestino = rutaP + "Imagenes/Clientes/" + Nickname + "/Listas/" + nombre + "." + extension;
            this.copiarArchivo(Img, rutaDestino);
            this.lista.setImagen(rutaDestino);
        } else {
            this.lista.setImagen(null);
        }
    }

    public void crearListaPD(String Genero, String nombre, String Img) {
        Genero g = null;
        this.genero = this.art.getGenero(Genero);
        this.lista = new PorDefecto(0, g, nombre, null);
        if (Img != null) {
            String[] aux = Img.split("\\.");
            String extension = aux[1];
            String rutaDestino = "Imagenes/ListasPorDef/" + nombre + "." + extension;
            this.copiarArchivo(Img, rutaDestino);
            this.lista.setImagen(rutaDestino);
        }
    }

    @Override
    public void publicarLista(String nickname, String nomLista) {
        dbUsuario.publicarLista(nickname, nomLista);
        this.clientes.get(nickname).publicarLista(nomLista);
    }

    @Override
    public ArrayList<DtTema> listarTemasListaP(String nickname, String listaP) {
        Cliente cli = (Cliente) this.clientes.get(nickname);
        Particular p = cli.getListas().get(listaP);
        return p.getDtTemas();
    }

    @Override
    public ArrayList<DtListaP> listarListasPrivadas(String nickname) {
        return this.clientes.get(nickname).listarListasPrivadas();
    }

    @Override
    public boolean verificarDatos(String nickname, String correo) {
        for (Cliente cli : this.clientes.values()) {
            if (cli.getNickname().equals(nickname)) {
                return false; // nickname ya existe, repetido
            }

            if (cli.getCorreo().equals(correo)) {
                return false; //correo ya existe, repetido
            }
        }

        //Si no retornó false dentro del for, entonces los datos estan bien
        return true;
    }

    /////
    public boolean copiarArchivo(String rutaOrigenArchivo, String rutaDestino) {
        try {
            File archivoOrigen = new File(rutaOrigenArchivo);

            //Archivo de destino auxiliar
            File dest = new File(rutaDestino);

            //Crea las carpetas en donde va a ser guardado el tema si no estaban creadas todavia
            dest.getParentFile().mkdirs();

            //Crea el archivo auxiliar primero para despues sobreescribirlo, sino da error
            dest.createNewFile();

            //Copiar el archivo seleccionado al destino
            Files.copy(archivoOrigen.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            return true; // Se pudo copiar la imagen correctamente
        } catch (IOException ex) {
            Logger.getLogger(ContCliente.class.getName()).log(Level.SEVERE, null, ex);

            return false; // Error, no se pudo copiar la imagen
        }
    }

    @Override
    public List<DtCliente> BuscarClientesFav(String nombre) {
        List<DtCliente> retornar = new ArrayList<DtCliente>();
        Set set = clientes.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Cliente aux = (Cliente) mentry.getValue();
            if (aux.getNickname().contains(nombre)) {
                retornar.add(aux.getDatosResumidos());
            }
        }
        return retornar;
    }

    public ArrayList<DtListaP> listarTodasListasP() {
        ArrayList<DtListaP> lp = new ArrayList();
        Set set = clientes.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Cliente aux = (Cliente) mentry.getValue();
            Set set1 = aux.getListas().entrySet();
            Iterator iterator1 = set1.iterator();
            while (iterator1.hasNext()) {
                Map.Entry m = (Map.Entry) iterator1.next();
                Particular p = (Particular) m.getValue();
                if (!p.isEsPrivado()) {
                    DtListaP dtp = p.getDtListaP();
                    lp.add(dtp);
                }
            }
        }
        return lp;
    }

    @Override
    public boolean InsertarFavorito(String cliente, String[] elementos, int tipo) {
        Cliente c = this.clientes.get(cliente);
        boolean x = false;
        if (tipo == 0) {
            Tema t = this.art.getTema(elementos[2], elementos[1], elementos[0]);
            if (c.getFavTemas().contains(t)) {
                x = false;
            } else {
                c.getFavTemas().add(t);
                dbUsuario.InsertarFavorito(tipo, cliente, t.getId());
                x = true;
            }
        }
        if (tipo == 1) {
            Album a = this.art.getAlbum(elementos[1], elementos[0]);
            if (c.getFavAlbumes().contains(a)) {
                x = false;
            } else {
                c.getFavAlbumes().add(a);
                dbUsuario.InsertarFavorito(tipo, cliente, a.getId());
                x = true;
            }
        }
        if (tipo == 2) {
            Particular p = this.clientes.get(elementos[1]).getListas().get(elementos[0]);
            if (c.getFavListas().contains(p)) {
                x = false;
            } else {
                c.getFavListas().add(p);
                dbUsuario.InsertarFavorito(tipo, cliente, p.getId());
                x = true;
            }
        }
        if (tipo == 3) {
            PorDefecto pd = this.art.getListaPD(elementos[0]);
            if (c.getFavListas().contains(pd)) {
                x = false;
            } else {
                c.getFavListas().add(pd);
                dbUsuario.InsertarFavorito(tipo, cliente, pd.getId());
                x = true;
            }
        }
        return x;
    }

    @Override
    public void EliminarFavorito(String cliente, String[] elementos, int tipo) {
        Cliente c = this.clientes.get(cliente);
        if (tipo == 0) {
            for (int i = 0; i < c.getFavTemas().size(); i++) {
                Tema t = c.getFavTemas().get(i);
                if (t.getNombre().equals(elementos[0])) {
                    if (t.getNombrealbum().equals(elementos[1]) && t.getNombreartista().equals(elementos[2])) {
                        c.getFavTemas().remove(i);
                        dbUsuario.EliminarFavorito(tipo, t.getId(), cliente);
                    }
                }
            }
        }
        if (tipo == 1) {
            for (int i = 0; i < c.getFavAlbumes().size(); i++) {
                Album a = c.getFavAlbumes().get(i);
                if (a.getNombre().equals(elementos[0]) && a.getArtista().equals(elementos[1])) {
                    c.getFavAlbumes().remove(i);
                    dbUsuario.EliminarFavorito(tipo, a.getId(), cliente);
                }
            }
        }
        if (tipo == 2) {
            for (int i = 0; i < c.getFavListas().size(); i++) {
                Lista l = c.getFavListas().get(i);
                if (elementos[1].equals("Particular") && (l instanceof Particular)) {
                    Particular p = (Particular) l;
                    if (p.getUsuario().equals(elementos[2]) && p.getNombre().equals(elementos[0])) {
                        c.getFavListas().remove(i);
                        dbUsuario.EliminarFavorito(2, p.getId(), cliente);
                    }
                }
                if (elementos[1].equals("Por Defecto") && (l instanceof PorDefecto)) {
                    PorDefecto p = (PorDefecto) l;
                    if (p.getGenero().getNombre().equals(elementos[2]) && p.getNombre().equals(elementos[0])) {
                        c.getFavListas().remove(i);
                        dbUsuario.EliminarFavorito(3, p.getId(), cliente);
                    }
                }
            }
        }
    }

    public Cliente BuscarUsuariosC(String nickname) {
        Iterator iterador = this.clientes.values().iterator();
        while (iterador.hasNext()) {
            Cliente aux = (Cliente) iterador.next();
            nickname = nickname.toUpperCase();
            String nick = aux.getNickname().toUpperCase();
            String nombre = aux.getNombre().toUpperCase();
            String apellido = aux.getApellido().toUpperCase();
            String nomAp = aux.getNombre().toUpperCase() + aux.getApellido().toUpperCase();
            if (nick.contains(nickname) == true || nombre.contains(nickname) == true || apellido.contains(nickname) == true || nomAp.contains(nickname) == true) {
                return aux;
            }
        }
        return null;
    }

    public boolean ClientesVacio() {
        return this.clientes.isEmpty();
    }

    @Override
    public DtUsuario verificarLoginCliente(String nickname, String contrasenia) {
        for (Cliente cli : this.clientes.values()) {
            if (((cli.getNickname().equals(nickname)) || (cli.getCorreo().equals(nickname))) && (cli.getContrasenia().equals(contrasenia))) {
                return cli.getDatos(); // nickname o correo incorrecto
            }
        }

        return null;
    }

    public boolean agregarTemaFavorito(String nickname, String artista, String album, String tema) {
        Cliente c = this.clientes.get(nickname);
        Tema t = this.art.getTema(artista, album, tema);
        boolean agregadoOk = false;
        if (c.getFavTemas().contains(t)) {
            agregadoOk = false;
        } else {
            c.getFavTemas().add(t);
            dbUsuario.InsertarFavorito(0, nickname, t.getId());
            agregadoOk = true;
        }
        return agregadoOk;
    }

    public boolean agregarAlbumFavorito(String nickname, String artista, String album) {
        Cliente c = this.clientes.get(nickname);
        Album a = this.art.getAlbum(artista, album);
        boolean agregadoOk = false;
        if (c.getFavAlbumes().contains(a)) {
            agregadoOk = false;
        } else {
            c.getFavAlbumes().add(a);
            dbUsuario.InsertarFavorito(1, nickname, a.getId());
            agregadoOk = true;
        }
        return agregadoOk;
    }

    @Override
    public ArrayList<DtTipoSuscripcion> listarTipoDeSus() {
        ArrayList<DtTipoSuscripcion> listaTS = new ArrayList<>();

        for (TipoSuscripcion tipoS : this.tiposDeSuscripcion.values()) {
            listaTS.add(tipoS.getDatos());
        }

        return listaTS;
    }

    @Override
    public ArrayList<DtSuscripcion> getSuscripCliente(String nickname) {
        return this.clientes.get(nickname).getSuscripCliente();
    }

    @Override
    public boolean SuscripcionVigente(String nickname) {
        return this.clientes.get(nickname).Vigencia();
    }

    @Override
    public boolean contratarSuscripcion(String nickname, int idTipoSus) {
        return this.clientes.get(nickname).contratarSuscripcion(this.tiposDeSuscripcion.get(idTipoSus));
    }

    @Override
    public BufferedImage cargarImagen(String rutaImagen) {
        try {
            File archivo = new File(rutaImagen);
            BufferedImage bi = ImageIO.read(archivo);
            return bi;
        } catch (IOException ex) {
            Logger.getLogger(ContCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void actualizarVigenciaSuscripciones(String nickname) {
        this.clientes.get(nickname).actualizarVigenciaSuscripciones();
    }

    @Override
    public boolean estaCliente(String nickname, String correo) {
        List<DtCliente> cliente = BuscarCliente2(nickname, correo);
        if (cliente.isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<DtCliente> BuscarCliente2(String nickname, String correo) {
        ArrayList<DtCliente> retornar = new ArrayList<>();
        Iterator iterador = this.clientes.values().iterator();
        if (nickname.equals("") == false || correo.equals("") == false) {
            while (iterador.hasNext()) {
                Cliente aux = (Cliente) iterador.next();

                nickname = nickname.toUpperCase();
                correo = correo.toUpperCase();
                String nick = aux.getNickname().toUpperCase();
                String corre = aux.getCorreo().toUpperCase();

                if (nick.equals(nickname) == true || corre.equals(correo) == true) {
                    retornar.add(aux.getDatos());
                }
            }
        } else {
            System.out.println("Logica.ContCliente.BuscarCliente2() -> nickname,correo vacio");
            for (Cliente cliente : this.clientes.values()) {
                retornar.add(cliente.getDatosResumidos());
            }
        }

        return retornar;
    }

    @Override
    public void CambiarEstadoSuscripcion(DtSuscripcion suscripcion) {
        this.clientes.get(suscripcion.getCliente()).cambiarEstadoS(suscripcion);
    }
    
    @Override
    public ArrayList<DtTema> reproducirListaP(String cliente, String lista){
        return this.clientes.get(cliente).reproducirListaP(lista);
    }
    
    public ArrayList<DtTema> resultadosT(String palabra){
        return this.art.resultadosT(palabra);
    }
    
    public ArrayList<DtAlbum> resultadosA(String palabra){
        return this.art.resultadosA(palabra);
    }
    
    public ArrayList<DtLista> resultadosL(String palabra){
        ArrayList<DtLista> listas = new ArrayList<>();
        String cadena = palabra.toUpperCase();
        for(DtListaPD l : this.art.ListarListaPD()){
        if(l.getNombre().toUpperCase().contains(cadena) || l.getGenero().toUpperCase().contains(cadena))
            listas.add(l);
        }
        for(DtListaP l : this.ListarListaP()){
        if(l.getNombre().toUpperCase().contains(cadena) || l.getUsuario().toUpperCase().contains(cadena))
            listas.add(l);
        }
        return listas;
    }

    
    public boolean agregarListaFavorito(String nickname, String cliente, String lista) {
        Cliente cli = (Cliente)this.clientes.get(nickname), cli2=(Cliente)this.clientes.get(cliente);
        if(!cli2.getListas().containsKey(lista))
            return false;
        for(DtListaP l : cli.getFavDtListasP()){
            if(l.getNombre().equals(lista) && l.getUsuario().equals(cliente))
                return false;
        }
        Particular p = cli2.getListas().get(lista);
        cli.setFavLista(p);
        dbUsuario.InsertarFavorito(2, cli.getNickname(), p.getId());
        return true;
    }

    @Override
    public boolean agregarListaFavorito(String nickname, String lista) {
        Cliente cli = (Cliente)this.clientes.get(nickname);
        if(!this.art.ExisteListaPD(lista))
            return false;
        for(DtListaPD l : cli.getFavDtListasPD()){
            if(l.getNombre().equals(lista))
                return false;
        }
        PorDefecto pd = this.art.getListaPD(lista);
        cli.setFavLista(pd);
        dbUsuario.InsertarFavorito(3, cli.getNickname(), pd.getId());
        return true;
    }
    
    public void crearListaPWeb(String nickname, String nombre, byte[] imagen){
        this.cliente = this.clientes.get(nickname);
        this.lista = new Particular(0, "x", nombre, true, null);
        if (imagen != null) {
            try {
                Properties p = new Properties();
                InputStream is;
                String rutaP = null;
                try {
                    is = new FileInputStream("Configuraciones/rutaProyecto.properties");
                    p.load(is);
                    rutaP = p.getProperty("ruta");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                String rutaDestino = rutaP + "Imagenes/Clientes/" + nickname + "/Listas/" + nombre + ".jpg";
                
                File f = new File(rutaDestino);
                f.getParentFile().mkdirs();
                org.apache.commons.io.FileUtils.writeByteArrayToFile(f, imagen);
                
                this.lista.setImagen(rutaDestino);
            } catch (IOException ex) {
                Logger.getLogger(ContCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.lista.setImagen(null);
        }
        
    }
}
