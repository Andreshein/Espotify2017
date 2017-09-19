
/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUsuario {

    private final Connection conexion = new ConexionDB().getConexion();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public boolean agregarArtista(Artista a) {
        try {
            java.sql.Date fechaN = new java.sql.Date(a.getFechaNac().getTime());
            
            String passEncriptada = "";
                try {
                    passEncriptada = sha1(a.getContrasenia());
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO artista "
                    + "(Nickname, Contrasenia, Nombre, Apellido, FechaNac,Correo, Biografia, Pagweb, Imagen) values(?,?,?,?,?,?,?,?,?)");
            statement.setString(1, a.getNickname());
            statement.setString(2, passEncriptada);
            statement.setString(3, a.getNombre());
            statement.setString(4, a.getApellido());
            statement.setDate(5, fechaN);
            statement.setString(6, a.getCorreo());
            statement.setString(7, a.getBiografia());
            statement.setString(8, a.getPaginaWeb());
            statement.setString(9, a.getImagen());
            statement.executeUpdate();
            statement.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean agregarCliente(Cliente c) {
        try {
            java.sql.Date fechaN = new java.sql.Date(c.getFechaNac().getTime());

            PreparedStatement statement = conexion.prepareStatement("INSERT INTO cliente "
                    + "(Nickname, Contrasenia,Nombre, Apellido, FechaNac, Correo, Imagen) values(?,?,?,?,?,?,?)");
            statement.setString(1, c.getNickname());
            statement.setString(2, c.getContrasenia());
            statement.setString(3, c.getNombre());
            statement.setString(4, c.getApellido());
            statement.setDate(5, fechaN);
            statement.setString(6, c.getCorreo());
            statement.setString(7, c.getImage());
            statement.executeUpdate();
            statement.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean agregarTema(DtListaP l) {
        try {
            PreparedStatement statement = conexion.prepareStatement("SELECT usuario, nombre FROM  listaparticular ");
            statement.setString(1, l.getUsuario());
            statement.setString(1, l.getNombre());
            statement.executeUpdate();
            statement.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int InsertarAlbum(Album a) {
        int idalbum = -1;
        try {
            PreparedStatement st = conexion.prepareStatement("INSERT INTO album (Artista,Nombre,Anio,Imagen) values(?,?,?,?)");
            st.setString(1, a.getArtista());
            st.setString(2, a.getNombre());
            st.setInt(3, a.getAño());
            st.setString(4, a.getImagen());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            PreparedStatement st = conexion.prepareStatement("SELECT max(Id) as id FROM espotify.album ;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                idalbum = rs.getInt("id");
            }
            rs.close();
            st.close();
            return idalbum;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return idalbum;
        }
    }

    public void InsertarGenero_Album(int idalbum, int idgenero) {
        try {
            PreparedStatement st = conexion.prepareStatement("INSERT INTO generosalbum (idAlbum, idGenero) values(?,?)");
            st.setInt(1, idalbum);
            st.setInt(2, idgenero);
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void InsertarTema(int idalbum, Tema t) {
        int idtema = -1;
        try {
            PreparedStatement st = conexion.prepareStatement("INSERT INTO tema (IdAlbum, Duracion, Nombre, Orden, Archivo, Dirección) values(?,?,?,?,?,?)");
            st.setInt(1, idalbum);
            st.setString(2, t.getDuracion());
            st.setString(3, t.getNombre());
            st.setInt(4, t.getOrden());
            st.setString(5, t.getArchivo());
            st.setString(6, t.getDireccion());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            PreparedStatement st = conexion.prepareStatement("SELECT max(Id) as id FROM espotify.tema ;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                idtema = rs.getInt("id");
            }
            rs.close();
            st.close();
            t.setId(idtema);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<String, Artista> cargarArtistas() {
        try {
            Map<String, Artista> lista = new HashMap<String, Artista>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM artista");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nickname = rs.getString("Nickname");
                Artista a = new Artista(nickname, rs.getString("Contrasenia"),rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"), rs.getDate("FechaNac"), rs.getString("Biografia"), rs.getString("Pagweb"), rs.getString("Imagen"));
                lista.put(nickname, a);
                PreparedStatement st2 = conexion.prepareStatement("SELECT * FROM album WHERE Artista='" + nickname + "'");
                ResultSet rs2 = st2.executeQuery();
                while (rs2.next()) {
                    //Album al = new Album(nickname, rs2.getString("Nombre"), rs2.getInt("anio"));
                    Album al = new Album(rs2.getInt("Id"),nickname, rs2.getString("Nombre"), rs2.getInt("anio"), rs2.getString("Imagen"));
                    a.AddAlbum(al);
                    PreparedStatement st3 = conexion.prepareStatement("SELECT * FROM tema WHERE IdAlbum='" + String.valueOf(rs2.getInt(1)) + "'");
                    ResultSet rs3 = st3.executeQuery();
                    while (rs3.next()) {
                        Tema t = new Tema(rs3.getInt("Id"), rs3.getString("Duracion"), rs3.getString("Nombre"), rs3.getInt("Orden"), rs3.getString("Archivo"), rs3.getString("Dirección"), nickname, rs2.getString("Nombre"));
                        al.AddTema(t);
                    }
                    rs3.close();
                    st3.close();
                }
                rs2.close();
                st2.close();
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Map<String, Cliente> cargarClientes() {
        try {
            Map<String, Cliente> lista = new HashMap<String, Cliente>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nickname = rs.getString("Nickname");
                java.util.Date fechaN = new java.util.Date(rs.getDate("FechaNac").getTime()); // convertir el Date de sql al Date utilizado en java
                Cliente c = new Cliente(nickname, rs.getString("Contrasenia"),rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"), fechaN, rs.getString("Imagen"));
                lista.put(nickname, c);
                PreparedStatement st2 = conexion.prepareStatement("SELECT * FROM listaparticular WHERE Usuario='" + nickname + "'");
                ResultSet rs2 = st2.executeQuery();
                while (rs2.next()) {
                    boolean privada;
                    if (rs2.getInt("Privada") == 1) {
                        privada = true;
                    } else {
                        privada = false;
                    }
                    Particular p = new Particular(rs2.getInt("Id"), nickname, rs2.getString("Nombre"), privada,rs2.getString("Imagen"));
                    c.AddLista(p);
                }
                rs2.close();
                st2.close();
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Suscripcion> cargarSuscripciones(){
        try{
            ArrayList<Suscripcion> lista = new ArrayList();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM suscripciones as s, tiposuscripcion as t " +
                "where s.IdTipo = t.Id;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                java.util.Date Fecha = new java.util.Date(rs.getDate("Fecha").getTime());
                Suscripcion s = new Suscripcion(Fecha,rs.getString("Estado"),rs.getInt("IdTipo"),rs.getString("Cliente"));
                lista.add(s);
            }
            return lista;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Map<String, Genero> cargarGenero() {
        try {
            Map<String, Genero> lista = new HashMap<String, Genero>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM genero");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                Genero g = new Genero(rs.getInt("Id"), rs.getString("Nombre"), rs.getInt("idPadre"));
                lista.put(nombre, g);
                PreparedStatement st2 = conexion.prepareStatement("SELECT l.* FROM listapordefecto l, genero g where g.Id=l.Genero and g.Nombre='" + nombre + "'");
                ResultSet rs2 = st2.executeQuery();
                while (rs2.next()) {
                    PorDefecto pd = new PorDefecto(rs2.getInt("l.Id"), g, rs2.getString("l.Nombre"), rs2.getString("l.Imagen"));
                    g.AddLista(pd);
                }
                rs2.close();
                st2.close();
            }
            rs.close();
            st.close();
            for (Genero g : lista.values()) {
                String nombre = this.getNombreGenero(g.getidpadre());
                if (nombre != null) {
                    g.setPadre(lista.get(nombre));
                }
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void CargarDatosdePrueba() {
        try {
            PreparedStatement st = conexion.prepareStatement("Delete FROM album");
            st.executeUpdate();
            st.close();
            PreparedStatement st1 = conexion.prepareStatement("Delete FROM artista");
            st1.executeUpdate();
            st1.close();
            PreparedStatement st2 = conexion.prepareStatement("Delete FROM cliente");
            st2.executeUpdate();
            st2.close();
            PreparedStatement st3 = conexion.prepareStatement("Delete FROM favalbum");
            st3.executeUpdate();
            st3.close();
            PreparedStatement st4 = conexion.prepareStatement("Delete FROM favlistap");
            st4.executeUpdate();
            st4.close();
            PreparedStatement st5 = conexion.prepareStatement("Delete FROM favlistapd");
            st5.executeUpdate();
            st5.close();
            PreparedStatement st6 = conexion.prepareStatement("Delete FROM favtema");
            st6.executeUpdate();
            st6.close();
            PreparedStatement st7 = conexion.prepareStatement("Delete FROM genero");
            st7.executeUpdate();
            st7.close();
            PreparedStatement st8 = conexion.prepareStatement("Delete FROM generosalbum");
            st8.executeUpdate();
            st8.close();
            PreparedStatement st9 = conexion.prepareStatement("Delete FROM listaparticular");
            st9.executeUpdate();
            st9.close();
            PreparedStatement st10 = conexion.prepareStatement("Delete FROM listapordefecto");
            st10.executeUpdate();
            st10.close();
            PreparedStatement st11 = conexion.prepareStatement("Delete FROM seguidoart");
            st11.executeUpdate();
            st11.close();
            PreparedStatement st12 = conexion.prepareStatement("Delete FROM seguidorcli");
            st12.executeUpdate();
            st12.close();
            PreparedStatement st13 = conexion.prepareStatement("Delete FROM tema");
            st13.executeUpdate();
            st13.close();
            PreparedStatement st14 = conexion.prepareStatement("Delete FROM temalistap");
            st14.executeUpdate();
            st14.close();
            PreparedStatement st15 = conexion.prepareStatement("Delete FROM temalistapd");
            st15.executeUpdate();
            st15.close();
            PreparedStatement st16 = conexion.prepareStatement("Delete FROM suscripciones");
            st16.executeUpdate();
            st16.close();
            PreparedStatement st17 = conexion.prepareStatement("Delete FROM tiposuscripcion");
            st17.executeUpdate();
            st17.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] NickArtistas0 = {"vpeople", "dmode", "clauper", "bruceTheBoss", "tripleNelson", "la_ley", "tigerOfWales", "chaiko", "nicoleneu", "lospimpi", "dyangounchained", "alcides"};
        String[] NombreArtistas = {"Village", "Depeche", "Cyndi", "Bruce", "La Triple", "La", "Tom", "Piotr", "Nicole", "Pimpinela", "Dyango", "Alcides"};
        String[] ApellidoArtistas = {"People", "Mode", "Lauper", "Springsteen", "Nelson", "Ley", "Jones", "Tchaikovsky", "Neumann", " ", " ", " "};
        String[] CorreoArtistas = {"vpeople@tuta.io", "dmode@tuta.io", "clauper@hotmail.com", "bruceTheBoss@gmail.com", "tripleNelson@tuta.io", "la_ley@tuta.io", "tigerOfWales@tuta.io", "chaiko@tuta.io", "nicoleneu@hotmail.com", "lospimpi@gmail.com", "dyangounchained@gmail.com", "alcides@tuta.io"};
        String[] NacimientoArtistas = {"1977-01-01", "1980-06-14", "1953-06-22", "1949-09-23", "1998-01-01", "1987-02-14", "1940-06-07", "1840-4-25", "1980-10-31", "1981-08-13", "1940-03-05", "1952-07-17"};
        String[] ImagenArtistas = {"DatosDePrueba/Imagenes/VillagePeople.jpg", "DatosDePrueba/Imagenes/DepecheMode.jpg", "DatosDePrueba/Imagenes/CyndiLauper.png", "DatosDePrueba/Imagenes/BruceSpringsteen.jpg", "DatosDePrueba/Imagenes/TripleNelson.jpg", null, null, null, "DatosDePrueba/Imagenes/NicoleNeumann.jpg", "DatosDePrueba/Imagenes/LosPimpinela.jpg", null, null};
        String[] BiografiaArtistas = {"Village People es una innovadora formación musical de estilo disco de finales de los años 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.", null, "Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Después de participar en el grupo musical, Blue Angel, en 1983 firmó con Portrait Records (filial de Epic Records) y lanzó su exitoso álbum debut She's So Unusual a finales de ese mismo año. Siguió lanzando una serie de álbumes en los que encontró una inmensa popularidad, superando los límites de contenido de las letras de sus canciones.", null, "La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998 e integrado inicialmente por Christian Cary (guitarra y voz), Fernando \"Paco\" Pintos (bajo y coros) y Rubén Otonello (actualmente su nuevo baterista es Rafael Ugo).", null, "Sir Thomas John, conocido por su nombre artístico de Tom Jones, es un cantante británico. Ha vendido más de 100 millones de discos en todo el mundo.", "Piotr Ilich Chaikovski fue un compositor ruso del período del Romanticismo", null, null, "José Gómez Romero, conocido artísticamente como Dyango es un cantante español de música romántica.", "Su carrera comienza en 1976 cuando forma la banda Los Playeros junto a su hermano Víctor. Al poco tiempo se mudan a San Luis donde comienzan a hacerse conocidos en la escena musical. Su éxito a nivel nacional llega a comienzos de los años 1990 cuando desembarca en Buenos Aires y graba el éxito \"Violeta\", originalmente compuesta e interpretada en 1985 por el músico brasileño Luiz Caldas bajo el título «Fricote»."};
        String[] Pagina = {"www.officialvillagepeople.com", "www.depechemode.com", "cyndilauper.com", "brucespringsteen.net", null, null, "www.tomjones.com", null, null, "www.pimpinela.net", null, null};
        String[] PasswordArtistas = {"vpeople", "dmode", "clauper", "bruceTheBoss", "tripleNelson", "la_ley", "tiger", "chaiko", "nicoleneu", "lospimpi", "dyango", "alcides"};
        
        try {
            for (int i = 0; i < 12; i++) {
                //Hay que copiar la imagen a la carpeta de imagenes servidor, donde estan la de los otros usuarios creados

                //En pricipio esta en null, pero si el artista tiene una imagen se copia y se le setea la ruta de la copia de imagen 
                String rutaImagen = null;

                if (ImagenArtistas[i] != null) {
                    //Divide el string por el punto, tambien elimina el punto
                    String[] aux = ImagenArtistas[i].split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial

                    //toma la segunda parte porque es la extension
                    //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
                    String extension = aux[1];

                    //Ruta del archvio de origen(en la capeta DatosDePrueba)
                    String rutaOrigen = ImagenArtistas[i];

                    //Ruta donde se va a copiar el archivo de imagen
                    String rutaDestino = "Imagenes/Artistas/" + NickArtistas0[i] + "/" + NickArtistas0[i] + "." + extension; // se le agrega el punto(.) porque la hacer el split tambien se borra

                    if (copiarArchivoAlServidor(rutaOrigen, rutaDestino) == false) {
                        rutaImagen = null; // no se pudo copiar la imagen, queda en null
                    } else {
                        rutaImagen = rutaDestino;
                    }

                }
                
                String passEncriptada = "";
                try {
                    passEncriptada = sha1(PasswordArtistas[i]);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }

                PreparedStatement statement = conexion.prepareStatement("INSERT INTO artista "

                        + "(Nickname, Contrasenia, Nombre, Apellido, Correo, FechaNac, Biografia, Pagweb, Imagen) values(?,?,?,?,?,?,?,?,?)");
                statement.setString(1, NickArtistas0[i]);
                statement.setString(2, passEncriptada);
                statement.setString(3, NombreArtistas[i]);
                statement.setString(4, ApellidoArtistas[i]);
                statement.setString(5, CorreoArtistas[i]);
                statement.setString(6, NacimientoArtistas[i]);
                statement.setString(7, BiografiaArtistas[i]);
                statement.setString(8, Pagina[i]);
                statement.setString(9, rutaImagen);
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] NickClientes = {"el_padrino", "scarlettO", "ppArgento", "Heisenberg", "benKenobi", "lachiqui", "cbochinche", "Eleven11"};
        String[] CorreoClientes = {"el_padrino@tuta.io", "scarlettO@tuta.io", "ppArgento@hotmail.com", "Heisenberg@tuta.io", "benKenobi@gmail.com", "lachiqui@hotmail.com.ar", "cbochinche@vera.com.uy", "Eleven11@gmail.com"};
        String[] NombreClientes = {"Vito", "Scarlett", "Pepe", "Walter", "Obi-Wan", "Mirtha", "Cacho", "Eleven"};
        String[] ApellidoClientes = {"Corleone", "O’Hara", "Argento", "White", "Kenobi", "Legrand", "Bochinche", " "};
        String[] NacimientoClientes = {"1972-03-08", "1984-11-27", "1955-02-14", "1956-03-07", "1914-04-02", "1927-02-23", "1937-05-08", "1971-12-31"};
        String[] ImagenClientes = {"DatosDePrueba/Imagenes/VitoCorleone.jpg", "DatosDePrueba/Imagenes/ScarlettO’Hara.jpg", "DatosDePrueba/Imagenes/PepeArgento.png", "DatosDePrueba/Imagenes/Heisenberg.jpg", "DatosDePrueba/Imagenes/BenKenobi.png", "DatosDePrueba/Imagenes/MirthaLegrand.jpg", "DatosDePrueba/Imagenes/CachoBochinche.jpg", "DatosDePrueba/Imagenes/Eleven.jpg"};
        String[] PasswordClientes = {"elpadrino", "scarletto", "ppargento", "heisenberg", "benkenobi", "lachiqui", "cbochinche", "eleven11"};
                
        try {
            for (int i = 0; i < 8; i++) {
                //Hay que copiar la imagen a la carpeta de imagenes servidor, donde estan la de los otros usuarios creados

                //Divide el string por el punto, tambien elimina el punto
                String[] aux = ImagenClientes[i].split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial

                //toma la segunda parte porque es la extension
                //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
                String extension = aux[1];

                String rutaOrigen = (ImagenClientes[i]);

                //Ruta donde se va a copiar el archivo de imagen
                String rutaDestino = "Imagenes/Clientes/" + NickClientes[i] + "/" + NickClientes[i] + "." + extension; // se le agrega el punto(.) porque la hacer el split tambien se borra

                if (copiarArchivoAlServidor(rutaOrigen, rutaDestino) == false) {
                    rutaDestino = null; // no se pudo copiar la imagen, queda en null
                }
                
                String passEncriptada = "";
                try {
                    passEncriptada = sha1(PasswordClientes[i]);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }

                PreparedStatement statement = conexion.prepareStatement("INSERT INTO cliente "
                        + "(Nickname, Contrasenia, Nombre, Apellido, Correo, FechaNac, Imagen) values(?,?,?,?,?,?,?)");
                statement.setString(1, NickClientes[i]);                
                statement.setString(2, passEncriptada);
                statement.setString(3, NombreClientes[i]);
                statement.setString(4, ApellidoClientes[i]);
                statement.setString(5, CorreoClientes[i]);
                statement.setString(6, NacimientoClientes[i]);
                statement.setString(7, rutaDestino);
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] NickArtistas = {"vpeople", "dmode", "clauper", "bruceTheBoss", "tigerOfWales", "tripleNelson", "la_ley", "chaiko", "nicoleneu", "lospimpi", "dyangounchained", "alcides"};
        try {
            for (int i = 0; i < 3; i++) {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguidoart "
                        + "(Seguidor, Seguido) values(?,?)");
                statement.setString(1, NickClientes[0]);
                statement.setString(2, NickArtistas[i]);
                statement.executeUpdate();
                statement.close();
            }
            for (int i = 4; i < 8; i++) {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguidorcli "
                        + "(Seguidor, Seguido) values(?,?)");
                statement.setString(1, NickClientes[0]);
                statement.setString(2, NickClientes[i]);
                statement.executeUpdate();
                statement.close();
            }
            for (int i = 3; i < 6; i++) {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguidoart "
                        + "(Seguidor, Seguido) values(?,?)");
                statement.setString(1, NickClientes[1]);
                statement.setString(2, NickArtistas[i]);
                statement.executeUpdate();
                statement.close();
            }
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement.setString(1, NickClientes[1]);
            statement.setString(2, NickArtistas[1]);
            statement.executeUpdate();
            statement.close();
            for (int i = 3; i < 6; i++) {
                PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO seguidorcli "
                        + "(Seguidor, Seguido) values(?,?)");
                statement1.setString(1, NickClientes[1]);
                statement1.setString(2, NickClientes[i]);
                statement1.executeUpdate();
                statement1.close();
            }
            PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement2.setString(1, NickClientes[2]);
            statement2.setString(2, NickArtistas[1]);
            statement2.executeUpdate();
            statement2.close();
            PreparedStatement statement3 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement3.setString(1, NickClientes[2]);
            statement3.setString(2, NickArtistas[3]);
            statement3.executeUpdate();
            statement3.close();
            PreparedStatement statement4 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement4.setString(1, NickClientes[2]);
            statement4.setString(2, NickArtistas[5]);
            statement4.executeUpdate();
            statement4.close();
            for (int i = 4; i < 8; i++) {
                PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO seguidorcli "
                        + "(Seguidor, Seguido) values(?,?)");
                statement1.setString(1, NickClientes[2]);
                statement1.setString(2, NickClientes[i]);
                statement1.executeUpdate();
                statement1.close();
            }
            for (int i = 3; i < 6; i++) {
                PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO seguidoart "
                        + "(Seguidor, Seguido) values(?,?)");
                statement1.setString(1, NickClientes[3]);
                statement1.setString(2, NickArtistas[i]);
                statement1.executeUpdate();
                statement1.close();
            }
            for (int i = 9; i < 12; i++) {
                PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO seguidoart "
                        + "(Seguidor, Seguido) values(?,?)");
                statement1.setString(1, NickClientes[3]);
                statement1.setString(2, NickArtistas[i]);
                statement1.executeUpdate();
                statement1.close();
            }
            PreparedStatement statement5 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement5.setString(1, NickClientes[3]);
            statement5.setString(2, NickArtistas[1]);
            statement5.executeUpdate();
            statement5.close();
            for (int i = 0; i < 3; i++) {
                PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO seguidorcli "
                        + "(Seguidor, Seguido) values(?,?)");
                statement1.setString(1, NickClientes[3]);
                statement1.setString(2, NickClientes[i]);
                statement1.executeUpdate();
                statement1.close();
            }
            PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO seguidorcli "
                    + "(Seguidor, Seguido) values(?,?)");
            statement1.setString(1, NickClientes[3]);
            statement1.setString(2, NickClientes[4]);
            statement1.executeUpdate();
            statement1.close();
            PreparedStatement statement6 = conexion.prepareStatement("INSERT INTO seguidorcli "
                    + "(Seguidor, Seguido) values(?,?)");
            statement6.setString(1, NickClientes[3]);
            statement6.setString(2, NickClientes[5]);
            statement6.executeUpdate();
            statement6.close();
            PreparedStatement statement7 = conexion.prepareStatement("INSERT INTO seguidorcli "
                    + "(Seguidor, Seguido) values(?,?)");
            statement7.setString(1, NickClientes[3]);
            statement7.setString(2, NickClientes[7]);
            statement7.executeUpdate();
            statement7.close();
            for (int i = 6; i < 10; i++) {
                PreparedStatement statement8 = conexion.prepareStatement("INSERT INTO seguidoart "
                        + "(Seguidor, Seguido) values(?,?)");
                statement8.setString(1, NickClientes[4]);
                statement8.setString(2, NickArtistas[i]);
                statement8.executeUpdate();
                statement8.close();
            }
            PreparedStatement statement9 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement9.setString(1, NickClientes[4]);
            statement9.setString(2, NickArtistas[11]);
            statement9.executeUpdate();
            statement9.close();
            PreparedStatement statement10 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement10.setString(1, NickClientes[4]);
            statement10.setString(2, NickArtistas[1]);
            statement10.executeUpdate();
            statement10.close();
            PreparedStatement statement11 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement11.setString(1, NickClientes[4]);
            statement11.setString(2, NickArtistas[3]);
            statement11.executeUpdate();
            statement11.close();
            PreparedStatement statement12 = conexion.prepareStatement("INSERT INTO seguidorcli "
                    + "(Seguidor, Seguido) values(?,?)");
            statement12.setString(1, NickClientes[4]);
            statement12.setString(2, NickClientes[0]);
            statement12.executeUpdate();
            statement12.close();
            PreparedStatement statement13 = conexion.prepareStatement("INSERT INTO seguidorcli "
                    + "(Seguidor, Seguido) values(?,?)");
            statement13.setString(1, NickClientes[4]);
            statement13.setString(2, NickClientes[2]);
            statement13.executeUpdate();
            statement13.close();
            for (int i = 5; i < 8; i++) {
                PreparedStatement statement14 = conexion.prepareStatement("INSERT INTO seguidorcli "
                        + "(Seguidor, Seguido) values(?,?)");
                statement14.setString(1, NickClientes[4]);
                statement14.setString(2, NickClientes[i]);
                statement14.executeUpdate();
                statement14.close();
            }
            PreparedStatement statement15 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement15.setString(1, NickClientes[5]);
            statement15.setString(2, NickArtistas[3]);
            statement15.executeUpdate();
            statement15.close();
            PreparedStatement statement0 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement0.setString(1, NickClientes[5]);
            statement0.setString(2, NickArtistas[6]);
            statement0.executeUpdate();
            statement0.close();
            PreparedStatement statement16 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement16.setString(1, NickClientes[5]);
            statement16.setString(2, NickArtistas[9]);
            statement16.executeUpdate();
            statement16.close();
            PreparedStatement statement17 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement17.setString(1, NickClientes[5]);
            statement17.setString(2, NickArtistas[11]);
            statement17.executeUpdate();
            statement17.close();
            for (int i = 0; i < 3; i++) {
                PreparedStatement statement14 = conexion.prepareStatement("INSERT INTO seguidorcli "
                        + "(Seguidor, Seguido) values(?,?)");
                statement14.setString(1, NickClientes[5]);
                statement14.setString(2, NickClientes[i]);
                statement14.executeUpdate();
                statement14.close();
            }
            PreparedStatement statement18 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement18.setString(1, NickClientes[6]);
            statement18.setString(2, NickArtistas[6]);
            statement18.executeUpdate();
            statement18.close();
            for (int i = 9; i < 12; i++) {
                PreparedStatement statement19 = conexion.prepareStatement("INSERT INTO seguidoart "
                        + "(Seguidor, Seguido) values(?,?)");
                statement19.setString(1, NickClientes[6]);
                statement19.setString(2, NickArtistas[i]);
                statement19.executeUpdate();
                statement19.close();
            }
            PreparedStatement statement14 = conexion.prepareStatement("INSERT INTO seguidorcli "
                    + "(Seguidor, Seguido) values(?,?)");
            statement14.setString(1, NickClientes[6]);
            statement14.setString(2, NickClientes[2]);
            statement14.executeUpdate();
            statement14.close();
            PreparedStatement statement19 = conexion.prepareStatement("INSERT INTO seguidoart "
                    + "(Seguidor, Seguido) values(?,?)");
            statement19.setString(1, NickClientes[7]);
            statement19.setString(2, NickArtistas[6]);
            statement19.executeUpdate();
            statement19.close();
            for (int i = 0; i < 3; i++) {
                PreparedStatement statement20 = conexion.prepareStatement("INSERT INTO seguidorcli "
                        + "(Seguidor, Seguido) values(?,?)");
                statement20.setString(1, NickClientes[7]);
                statement20.setString(2, NickClientes[i]);
                statement20.executeUpdate();
                statement20.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] generos = {"", "Género", "Rock", "Pop", "Rock Clásico", "Rock Latino", "Rock & Roll", "Electropop", "Dance-pop", "Pop Clásico", "Clásica", "Disco", "Balada", "Cumbia"};
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO genero "
                    + "(Id, Nombre, idPadre) values(?,?,?)");
            statement.setInt(1, 1);
            statement.setString(2, generos[1]);
            statement.setInt(3, 0);
            statement.executeUpdate();
            statement.close();
            PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO genero "
                    + "(Id, Nombre, idPadre) values(?,?,?)");
            statement1.setInt(1, 2);
            statement1.setString(2, generos[2]);
            statement1.setInt(3, 1);
            statement1.executeUpdate();
            statement1.close();
            PreparedStatement statement0 = conexion.prepareStatement("INSERT INTO genero "
                    + "(Id, Nombre, idPadre) values(?,?,?)");
            statement0.setInt(1, 3);
            statement0.setString(2, generos[3]);
            statement0.setInt(3, 1);
            statement0.executeUpdate();
            statement0.close();
            for (int i = 4; i < 7; i++) {
                PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO genero "
                        + "(Id, Nombre, idPadre) values(?,?,?)");
                statement2.setInt(1, i);
                statement2.setString(2, generos[i]);
                statement2.setInt(3, 2);
                statement2.executeUpdate();
                statement2.close();
            }
            for (int i = 7; i < 10; i++) {
                PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO genero "
                        + "(Id, Nombre, idPadre) values(?,?,?)");
                statement2.setInt(1, i);
                statement2.setString(2, generos[i]);
                statement2.setInt(3, 3);
                statement2.executeUpdate();
                statement2.close();
            }
            for (int i = 10; i < 14; i++) {
                PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO genero "
                        + "(Id, Nombre, idPadre) values(?,?,?)");
                statement2.setInt(1, i);
                statement2.setString(2, generos[i]);
                statement2.setInt(3, 1);
                statement2.executeUpdate();
                statement2.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int rcl = 0, rkl = 0, rar = 0, cla = 0, dis = 0, epo = 0, dpo = 0, pcl = 0, bal = 0, cum = 0;
        try {
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM genero");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getString("Nombre").equals("Rock Clásico")) {
                    rcl = rs.getInt("Id");
                }
                if (rs.getString("Nombre").equals("Rock Latino")) {
                    rkl = rs.getInt("Id");
                }
                if (rs.getString("Nombre").equals("Rock & Roll")) {
                    rar = rs.getInt("Id");
                }
                if (rs.getString("Nombre").equals("Clásica")) {
                    cla = rs.getInt("Id");
                }
                if (rs.getString("Nombre").equals("Disco")) {
                    dis = rs.getInt("Id");
                }
                if (rs.getString("Nombre").equals("Electropop")) {
                    epo = rs.getInt("Id");
                }
                if (rs.getString("Nombre").equals("Dance-pop")) {
                    dpo = rs.getInt("Id");
                }
                if (rs.getString("Nombre").equals("Pop Clásico")) {
                    pcl = rs.getInt("Id");
                }
                if (rs.getString("Nombre").equals("Balada")) {
                    bal = rs.getInt("Id");
                }
                if (rs.getString("Nombre").equals("Cumbia")) {
                    cum = rs.getInt("Id");
                }
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] NombreAlbum = {"Village People Live and Sleazy", "Violator", "She’s So Unusual", "Born In The U.S.A.", "It’s Not Unusual", "Agua Y Sal", "MTV Unplugged", "El Lago De Los Cisnes", "Concierto Para Piano No. 1 En Si Menor, Opus 23", "Primer Amor", "Hay Amores Que Matan", "Un Loco Como Yo", "20 Grandes Éxitos"};
        int[] anioalbum = {1980, 1990, 1983, 1984, 1965, 2012, 2001, 1875, 1875, 1994, 1993, 1993, 1989};
        String[] ImagenAlbum = {null, null, "DatosDePrueba/Imagenes/ShesSoUnusual.PNG", null, "DatosDePrueba/Imagenes/itsNotUnusual.jpg", null, "DatosDePrueba/Imagenes/MTVunplugged.jpg", null, null, null, null, "DatosDePrueba/Imagenes/UnLocoComoYo.jpg", "DatosDePrueba/Imagenes/alcides20grandes.jpg"};

        try {
            int x = 1;
            int j = 0;
            for (int i = 0; i < 13; i++) {
                //Hay que copiar la imagen a la carpeta de imagenes servidor, donde estan la de los otros usuarios creados

                //En pricipio esta en null, pero si el album tiene una imagen se copia y se le setea la ruta de la copia de imagen 
                String rutaImagen = null;

                if (ImagenAlbum[i] != null) {
                    //Divide el string por el punto, tambien elimina el punto
                    String[] aux = ImagenAlbum[i].split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial

                    //toma la segunda parte porque es la extension
                    //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
                    String extension = aux[1];

                    //Ruta del archvio de origen(en la capeta DatosDePrueba)
                    String rutaOrigen = ImagenAlbum[i];

                    //Ruta donde se va a copiar el archivo de imagen
                    String rutaDestino = "Imagenes/Artistas/" + NickArtistas0[j] + "/Albumes/" + NombreAlbum[i] + "." + extension; // se le agrega el punto(.) porque la hacer el split se borra

                    if (copiarArchivoAlServidor(rutaOrigen, rutaDestino) == false) {
                        rutaImagen = null; // no se pudo copiar la imagen, queda en null
                    } else {
                        rutaImagen = rutaDestino;
                    }

                }

                PreparedStatement statement = conexion.prepareStatement("INSERT INTO album "
                        + "(Id, Artista, Nombre, Anio, Imagen) values(?,?,?,?,?)");
                statement.setInt(1, x);
                statement.setString(2, NickArtistas[j]);
                statement.setString(3, NombreAlbum[i]);
                statement.setInt(4, anioalbum[i]);
                statement.setString(5, rutaImagen);
                statement.executeUpdate();
                statement.close();
                ++x;
                ++j;
                if (NombreAlbum[i].equals("El Lago De Los Cisnes")) {
                    j--;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement.setInt(1, 1);
            statement.setInt(2, dis);
            statement.executeUpdate();
            statement.close();
            PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement1.setInt(1, 1);
            statement1.setInt(2, dpo);
            statement1.executeUpdate();
            statement1.close();
            PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement2.setInt(1, 1);
            statement2.setInt(2, pcl);
            statement2.executeUpdate();
            statement2.close();
            PreparedStatement statement3 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement3.setInt(1, 2);
            statement3.setInt(2, epo);
            statement3.executeUpdate();
            statement3.close();
            PreparedStatement statement4 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement4.setInt(1, 3);
            statement4.setInt(2, pcl);
            statement4.executeUpdate();
            statement4.close();
            PreparedStatement statement5 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement5.setInt(1, 3);
            statement5.setInt(2, dpo);
            statement5.executeUpdate();
            statement5.close();
            PreparedStatement statement6 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement6.setInt(1, 4);
            statement6.setInt(2, rcl);
            statement6.executeUpdate();
            statement6.close();
            PreparedStatement statement7 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement7.setInt(1, 4);
            statement7.setInt(2, rar);
            statement7.executeUpdate();
            statement7.close();
            PreparedStatement statement8 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement8.setInt(1, 4);
            statement8.setInt(2, pcl);
            statement8.executeUpdate();
            statement8.close();
            PreparedStatement statement9 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement9.setInt(1, 5);
            statement9.setInt(2, rcl);
            statement9.executeUpdate();
            statement9.close();
            PreparedStatement statement10 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement10.setInt(1, 5);
            statement10.setInt(2, pcl);
            statement10.executeUpdate();
            statement10.close();
            PreparedStatement statement11 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement11.setInt(1, 6);
            statement11.setInt(2, rkl);
            statement11.executeUpdate();
            statement11.close();
            PreparedStatement statement12 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement12.setInt(1, 7);
            statement12.setInt(2, rkl);
            statement12.executeUpdate();
            statement12.close();
            PreparedStatement statement13 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement13.setInt(1, 7);
            statement13.setInt(2, pcl);
            statement13.executeUpdate();
            statement13.close();
            PreparedStatement statement14 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement14.setInt(1, 8);
            statement14.setInt(2, cla);
            statement14.executeUpdate();
            statement14.close();
            PreparedStatement statement15 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement15.setInt(1, 9);
            statement15.setInt(2, cla);
            statement15.executeUpdate();
            statement15.close();
            PreparedStatement statement16 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement16.setInt(1, 10);
            statement16.setInt(2, epo);
            statement16.executeUpdate();
            statement16.close();
            PreparedStatement statement17 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement17.setInt(1, 11);
            statement17.setInt(2, pcl);
            statement17.executeUpdate();
            statement17.close();
            PreparedStatement statement18 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement18.setInt(1, 11);
            statement18.setInt(2, bal);
            statement18.executeUpdate();
            statement18.close();
            PreparedStatement statement19 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement19.setInt(1, 12);
            statement19.setInt(2, pcl);
            statement19.executeUpdate();
            statement19.close();
            PreparedStatement statement20 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement20.setInt(1, 12);
            statement20.setInt(2, bal);
            statement20.executeUpdate();
            statement20.close();
            PreparedStatement statement21 = conexion.prepareStatement("INSERT INTO generosalbum "
                    + "(idAlbum, idGenero) values(?,?)");
            statement21.setInt(1, 13);
            statement21.setInt(2, cum);
            statement21.executeUpdate();
            statement21.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] Nombretema = {"YMCA", "Macho Man", "In the Navy", "Personal Jesus", "Enjoy The Silence", "Girls Just Want To Have Fun", "Time After Time", "Born In The U.S.A.", "Glory Days", "Dancing In The Park", "It’s Not Unusual", "Adagio De Mi País", "El Duelo", "Mentira", "Acto 2, Número 10, Escena (Moderato)", "Primer Movimiento (Allegro non troppo e molto maestoso – Allegro con spirito)", "No Quiero Estudiar", "Por Ese Hombre", "Por Ese Hombre", "Violeta"};
        String[] Duraciontema = {"4:28", "3:28", "3:13", "4:56", "4:21", "3:15", "5:12", "4:58", "5:23", "3:58", "2:00", "4:50", "5:23", "4:48", "2:40", "21:58", "2:12", "4:45", "5:13", "1:56"};
        int[] Ordentema = {1, 2, 3, 1, 2, 1, 2, 1, 2, 3, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1};
        String[] Archivotema = {null, "Temas/vpeople/Village People Live and Sleazy/Macho Man.mp3", null, "Temas/dmode/Violator/Personal Jesus.mp3", "Temas/dmode/Violator/Enjoy The Silence.mp3", null, "Temas/clauper/She’s So Unusual/Time After Time.mp3", null, null, "Temas/bruceTheBoss/Born In The U.S.A/Dancing In The Park.mp3", "Temas/tigerOfWales/It’s Not Unusual/It’s Not Unusual.mp3", null, "Temas/la_ley/MTV Unplugged/El Duelo.mp3", "Temas/la_ley/MTV Unplugged/Mentira.mp3", null, null, "Temas/nicoleneu/Primer Amor/No Quiero Estudiar.mp3", "Temas/lospimpi/Hay Amores Que Matan/Por Ese Hombre.mp3", null, null};
        String[] URLtema = {"bit.ly/SCvpymca", null, "bit.ly/SCvpinthenavy", null, null, "bit.ly/SCclgirlsjustwant", null, "bit.ly/SCbsborninusa", "bit.ly/SCbsglorydays", null, null, "bit.ly/SCtnadagiopais", null, null, "bit.ly/SCptswanlake", "bit.ly/SCptpiano", null, null, "bit.ly/SCdyporesehombre", "bit.ly/SCvioleta"};
        try {
            int j = 1;
            int x = 1;
            for (int i = 0; i < 20; i++) {
                if (x == 4) {
                    j++;
                }
                if (x == 6) {
                    j++;
                }
                if (x == 8) {
                    j++;
                }
                if (x == 11) {
                    j++;
                }
                if (x == 12) {
                    j++;
                }
                if (x == 13) {
                    j++;
                }
                if (x == 15) {
                    j++;
                }
                if (x == 16) {
                    j++;
                }
                if (x == 17) {
                    j++;
                }
                if (x == 18) {
                    j++;
                }
                if (x == 19) {
                    j++;
                }
                if (x == 20) {
                    j++;
                }

                String rutaArchivo = null;

                //Si el tema tiene archivo
                if (Archivotema[i] != null) {
                    String rutaOrigen = "DatosDePrueba/" + Archivotema[i];
                    String rutaDestino = Archivotema[i];

                    //Si se pudo copiar la imagen correctamente
                    if (copiarArchivoAlServidor(rutaOrigen, rutaDestino) == true) {
                        rutaArchivo = rutaDestino;
                    }

                }

                PreparedStatement statement = conexion.prepareStatement("INSERT INTO tema "
                        + "(Id, IdAlbum, Duracion, Nombre, Orden, Archivo, Dirección) values(?,?,?,?,?,?,?)");
                statement.setInt(1, x);
                statement.setInt(2, j);
                statement.setString(3, Duraciontema[i]);
                statement.setString(4, Nombretema[i]);
                statement.setInt(5, Ordentema[i]);
                statement.setString(6, rutaArchivo);
                statement.setString(7, URLtema[i]);
                statement.executeUpdate();
                statement.close();
                x++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            ///// Listas Por Defecto /////

            String rutaArchivo = null;

            String rutaOrigen = "DatosDePrueba/Imagenes/laNocheNostalgia.jpg";
            String rutaDestino = "Imagenes/ListasPorDef/laNocheNostalgia.jpg";

            //Si se pudo copiar la imagen correctamente
            if (copiarArchivoAlServidor(rutaOrigen, rutaDestino) == true) {
                rutaArchivo = rutaDestino;
            }

            PreparedStatement statement = conexion.prepareStatement("INSERT INTO listapordefecto "
                    + "(Id, Genero, Nombre, Imagen) values(?,?,?,?)");
            statement.setInt(1, 1);
            statement.setInt(2, pcl);
            statement.setString(3, "Noche De La Nostalgia");
            statement.setString(4, rutaArchivo);
            statement.executeUpdate();
            statement.close();

            /////
            PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO listapordefecto "
                    + "(Id, Genero, Nombre, Imagen) values(?,?,?,?)");
            statement1.setInt(1, 2);
            statement1.setInt(2, rkl);
            statement1.setString(3, "Rock En Español");
            statement1.setString(4, null);
            statement1.executeUpdate();
            statement1.close();

            /////
            rutaArchivo = null;

            rutaOrigen = "DatosDePrueba/Imagenes/musicaClasica.jpg";
            rutaDestino = "Imagenes/ListasPorDef/musicaClasica.jpg";

            //Si se pudo copiar la imagen correctamente
            if (copiarArchivoAlServidor(rutaOrigen, rutaDestino) == true) {
                rutaArchivo = rutaDestino;
            }

            PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO listapordefecto "
                    + "(Id, Genero, Nombre, Imagen) values(?,?,?,?)");
            statement2.setInt(1, 3);
            statement2.setInt(2, cla);
            statement2.setString(3, "Música Clásica");
            statement2.setString(4, rutaArchivo);
            statement2.executeUpdate();
            statement2.close();

            ///// Listas Particulares /////
            rutaArchivo = null;

            rutaOrigen = "DatosDePrueba/Imagenes/musicInspiradora.jpg";
            rutaDestino = "Imagenes/Clientes/el_padrino/Listas/Música Inspiradora.jpg";

            //Si se pudo copiar la imagen correctamente
            if (copiarArchivoAlServidor(rutaOrigen, rutaDestino) == true) {
                rutaArchivo = rutaDestino;
            }

            PreparedStatement statement3 = conexion.prepareStatement("INSERT INTO listaparticular "
                    + "(Id, Usuario, Nombre, Privada, Imagen) values(?,?,?,?,?)");
            statement3.setInt(1, 1);
            statement3.setString(2, "el_padrino");
            statement3.setString(3, "Música Inspiradora");
            statement3.setBoolean(4, false);
            statement3.setString(5, rutaArchivo);
            statement3.executeUpdate();
            statement3.close();

            /////
            PreparedStatement statement4 = conexion.prepareStatement("INSERT INTO listaparticular "
                    + "(Id, Usuario, Nombre, Privada, Imagen) values(?,?,?,?,?)");
            statement4.setInt(1, 2);
            statement4.setString(2, "scarlettO");
            statement4.setString(3, "De Todo Un Poco");
            statement4.setBoolean(4, false);
            statement4.setString(5, null);
            statement4.executeUpdate();
            statement4.close();

            /////
            rutaArchivo = null;

            rutaOrigen = "DatosDePrueba/Imagenes/ParaCocinar.jpg";
            rutaDestino = "Imagenes/Clientes/Heisenberg/Listas/Para Cocinar.jpg";

            //Si se pudo copiar la imagen correctamente
            if (copiarArchivoAlServidor(rutaOrigen, rutaDestino) == true) {
                rutaArchivo = rutaDestino;
            }

            PreparedStatement statement5 = conexion.prepareStatement("INSERT INTO listaparticular "
                    + "(Id, Usuario, Nombre, Privada, Imagen) values(?,?,?,?,?)");
            statement5.setInt(1, 3);
            statement5.setString(2, "Heisenberg");
            statement5.setString(3, "Para Cocinar");
            statement5.setBoolean(4, true);
            statement5.setString(5, rutaArchivo);
            statement5.executeUpdate();
            statement5.close();

            /////
            PreparedStatement statement6 = conexion.prepareStatement("INSERT INTO listaparticular "
                    + "(Id, Usuario, Nombre, Privada, Imagen) values(?,?,?,?,?)");
            statement6.setInt(1, 4);
            statement6.setString(2, "lachiqui");
            statement6.setString(3, "Para Las Chicas");
            statement6.setBoolean(4, false);
            statement6.setString(5, null);
            statement6.executeUpdate();
            statement6.close();

            /////
            rutaArchivo = null;

            rutaOrigen = "DatosDePrueba/Imagenes/Fiesteras.jpg";
            rutaDestino = "Imagenes/Clientes/cbochinche/Listas/Fiesteras.jpg";

            //Si se pudo copiar la imagen correctamente
            if (copiarArchivoAlServidor(rutaOrigen, rutaDestino) == true) {
                rutaArchivo = rutaDestino;
            }

            PreparedStatement statement7 = conexion.prepareStatement("INSERT INTO listaparticular "
                    + "(Id, Usuario, Nombre, Privada, Imagen) values(?,?,?,?,?)");
            statement7.setInt(1, 5);
            statement7.setString(2, "cbochinche");
            statement7.setString(3, "Fiesteras");
            statement7.setBoolean(4, false);
            statement7.setString(5, rutaArchivo);
            statement7.executeUpdate();
            statement7.close();

            /////
            PreparedStatement statement8 = conexion.prepareStatement("INSERT INTO listaparticular "
                    + "(Id, Usuario, Nombre, Privada, Imagen) values(?,?,?,?,?)");
            statement8.setInt(1, 6);
            statement8.setString(2, "cbochinche");
            statement8.setString(3, "Mis Favoritas");
            statement8.setBoolean(4, true);
            statement8.setString(5, null);
            statement8.executeUpdate();
            statement8.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            int[] arreglotemas = {1, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
            int[] arreglotemas2 = {15, 16, 4, 6, 7, 11, 15, 4, 5, 8, 9, 6, 11, 16, 17, 19, 1, 2, 3, 9, 20, 12, 6, 18};
            int j = 0;
            int k = 1;
            for (int i = 0; i < 14; i++) {
                if (j == 9) {
                    k++;
                }
                if (j == 12) {
                    k++;
                }
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO temalistapd "
                        + "(IdLista, IdTema) values(?,?)");
                statement.setInt(1, k);
                statement.setInt(2, arreglotemas[j]);
                statement.executeUpdate();
                statement.close();
                j++;
            }
            j = 0;
            k = 1;
            for (int i = 0; i < 24; i++) {
                if (j == 3) {
                    k++;
                }
                if (j == 7) {
                    k++;
                }
                if (j == 11) {
                    k++;
                }
                if (j == 16) {
                    k++;
                }
                if (j == 21) {
                    k++;
                }
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO temalistap "
                        + "(IdLista, IdTema) values(?,?)");
                statement.setInt(1, k);
                statement.setInt(2, arreglotemas2[j]);
                statement.executeUpdate();
                statement.close();
                j++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int[] favalbum = {2, 8, 9, 8, 9, 11};
        int[] favtema = {13, 12, 16, 17};

        try {
            int x = 0;
            for (int i = 0; i < 4; i++) {
                if (i == 1) {
                    x = 2;
                }
                if (i == 2) {
                    x = 6;
                }
                if (i == 3) {
                    x = 7;
                }
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO favtema "
                        + "(Cliente, IdTema) values(?,?)");
                statement.setString(1, NickClientes[x]);
                statement.setInt(2, favtema[i]);
                statement.executeUpdate();
                statement.close();
            }
            x = 0;
            for (int i = 0; i < 6; i++) {
                if (i == 3) {
                    x = 4;
                }
                if (i == 5) {
                    x = 6;
                }
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO favalbum "
                        + "(Cliente, IdAlbum) values(?,?)");
                statement.setString(1, NickClientes[x]);
                statement.setInt(2, favalbum[i]);
                statement.executeUpdate();
                statement.close();
            }
            for (int i = 1; i < 4; i = i + 2) {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO favlistapd "
                        + "(Cliente, IdLista) values(?,?)");
                statement.setString(1, NickClientes[0]);
                statement.setInt(2, i);
                statement.executeUpdate();
                statement.close();
            }
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO favlistapd "
                    + "(Cliente, IdLista) values(?,?)");
            statement.setString(1, NickClientes[1]);
            statement.setInt(2, 3);
            statement.executeUpdate();
            statement.close();
            for (int i = 1; i < 3; i++) {
                PreparedStatement statement1 = conexion.prepareStatement("INSERT INTO favlistapd "
                        + "(Cliente, IdLista) values(?,?)");
                statement1.setString(1, NickClientes[2]);
                statement1.setInt(2, i);
                statement1.executeUpdate();
                statement1.close();
            }
            PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO favlistap "
                    + "(Cliente, IdLista) values(?,?)");
            statement2.setString(1, NickClientes[3]);
            statement2.setInt(2, 1);
            statement2.executeUpdate();
            statement2.close();
            for (int i = 1; i < 3; i++) {
                PreparedStatement statement3 = conexion.prepareStatement("INSERT INTO favlistapd "
                        + "(Cliente, IdLista) values(?,?)");
                statement3.setString(1, NickClientes[6]);
                statement3.setInt(2, i);
                statement3.executeUpdate();
                statement3.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] cuotas = {"","Semanal","Mensual","Anual"};
        int[] montos = {0,2,7,65};
        try{
            for (int i=1;i<4;i++){
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO tiposuscripcion "
                            + "(Id, Cuota, Monto) values(?,?,?)");
                statement.setInt(1, i);
                statement.setString(2, cuotas[i]);
                statement.setInt(3, montos[i]);
                statement.executeUpdate();
                statement.close();
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "el_padrino");
                statement.setInt(2, 1);
                statement.setString(3, "Vencida");
                statement.setString(4, "2016-09-02");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "el_padrino");
                statement.setInt(2, 3);
                statement.setString(3, "Vigente");
                statement.setString(4, "2016-09-03");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "scarlettO");
                statement.setInt(2, 2);
                statement.setString(3, "Pendiente");
                statement.setString(4, "2016-10-01");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "ppArgento");
                statement.setInt(2, 3);
                statement.setString(3, "Vencida");
                statement.setString(4, "2016-03-01");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "ppArgento");
                statement.setInt(2, 2);
                statement.setString(3, "Cancelada");
                statement.setString(4, "2016-05-03");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "ppArgento");
                statement.setInt(2, 1);
                statement.setString(3, "Vigente");
                statement.setString(4, "2016-10-16");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "Heisenberg");
                statement.setInt(2, 3);
                statement.setString(3, "Vencida");
                statement.setString(4, "2015-06-10");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "benKenobi");
                statement.setInt(2, 2);
                statement.setString(3, "Pendiente");
                statement.setString(4, "2015-10-15");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "lachiqui");
                statement.setInt(2, 3);
                statement.setString(3, "Cancelada");
                statement.setString(4, "2016-09-02");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "lachiqui");
                statement.setInt(2, 2);
                statement.setString(3, "Vigente");
                statement.setString(4, "2016-09-25");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "cbochinche");
                statement.setInt(2, 1);
                statement.setString(3, "Vencida");
                statement.setString(4, "2016-05-01");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "cbochinche");
                statement.setInt(2, 3);
                statement.setString(3, "Cancelada");
                statement.setString(4, "2016-10-02");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        try{
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO suscripciones "
                            + "(Cliente, IdTipo, Estado, Fecha) values(?,?,?,?)");
                statement.setString(1, "Eleven11");
                statement.setInt(2, 3);
                statement.setString(3, "Pendiente");
                statement.setString(4, "2016-10-15");
                statement.executeUpdate();
                statement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace(); 
        }
    }

    public void SeguirUsu(String cli, Usuario u) {
        PreparedStatement st;
        if (u instanceof Artista) {
            try {
                st = conexion.prepareStatement("INSERT INTO seguidoart VALUES ('" + cli + "','" + u.getNickname() + "')");
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("error seguidor bd");
            }
        } else {
            try {
                st = conexion.prepareStatement("INSERT INTO seguidorcli VALUES ('" + cli + "','" + u.getNickname() + "')");
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("error seguidor bd");
            }
        }
    }

    public void DejarSeguirUsu(String cli, Usuario u) {
        PreparedStatement st;
        if (u instanceof Artista) {
            try {
                st = conexion.prepareStatement("DELETE FROM seguidoart WHERE seguidor='" + cli + "' and seguido='" + u.getNickname() + "'");
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("error seguidor bd");
            }
        } else {
            try {
                st = conexion.prepareStatement("DELETE FROM seguidorcli WHERE seguidor='" + cli + "' and seguido='" + u.getNickname() + "'");
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("error seguidor bd");
            }
        }
    }

    public String getNombreGenero(int id) {
        try {
            String nombre = "";
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM genero WHERE Id='" + String.valueOf(id) + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nombre = rs.getString("Nombre");
            }
            rs.close();
            st.close();
            return nombre;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private String[] getAlbumArtista(int id) {
        try {
            String[] s = {"", ""};
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM album WHERE Id='" + String.valueOf(id) + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                s[0] = rs.getString("Nombre");
                s[1] = rs.getString("Artista");
            }
            rs.close();
            st.close();
            return s;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> getGeneroAlbum(int id) {
        try {
            ArrayList<String[]> list = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM generosalbum WHERE idGenero='" + String.valueOf(id) + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(this.getAlbumArtista(rs.getInt("idAlbum")));
            }
            rs.close();
            st.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private String[] getTema(int id) {
        try {
            String[] o = {"", "", ""}; //se le setean nombreTema, nombreAlbum, nicknameArtista
            String[] o2;
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM tema WHERE Id='" + String.valueOf(id) + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                o2 = this.getAlbumArtista(rs.getInt("IdAlbum")); //trae el nombreAlbum y nicknameArtista del album con ese id
                o[0] = rs.getString("Nombre"); //nombre del tema
                o[1] = o2[0]; //nombre del album
                o[2] = o2[1]; //nickname del artista
            }
            rs.close();
            st.close();
            return o;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> getTemasListaP(int id) {
        try {
            ArrayList<String[]> list = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM temalistap WHERE IdLista='" + String.valueOf(id) + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(this.getTema(rs.getInt("IdTema")));
            }
            rs.close();
            st.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> getTemasListaPD(int id) {
        try {
            ArrayList<String[]> temasDeLista = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM temalistapd WHERE IdLista='" + String.valueOf(id) + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                temasDeLista.add(this.getTema(rs.getInt("IdTema"))); //this.getTema() trae los datos del tema, porque el "rs" solo tiene el id
            }
            rs.close();
            st.close();
            return temasDeLista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> seguidos(String Cliente) {
        try {
            ArrayList<String> nombres = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM seguidoart WHERE Seguidor='" + Cliente + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nombres.add(rs.getString("Seguido"));
            }
            rs.close();
            st.close();
            st = conexion.prepareStatement("SELECT * FROM seguidorcli WHERE Seguidor='" + Cliente + "'");
            rs = st.executeQuery();
            while (rs.next()) {
                nombres.add(rs.getString("Seguido"));
            }
            rs.close();
            st.close();
            return nombres;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> getFTemas(String Nick) {
        try {
            ArrayList<String[]> temasFav = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM favtema WHERE Cliente='" + Nick + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                temasFav.add(this.getTema(rs.getInt("IdTema"))); //this.getTema() trae los datos del tema, porque el "rs" solo tiene el id
            }
            rs.close();
            st.close();
            return temasFav;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> getFAlbum(String Nick) {
        try {
            ArrayList<String[]> list = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM favalbum WHERE Cliente='" + Nick + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(this.getAlbumArtista(rs.getInt("idAlbum")));
            }
            rs.close();
            st.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private String[] getListasP(int id) {
        try {
            String[] o = {"", ""};
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM listaparticular WHERE id='" + String.valueOf(id) + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                o[0] = rs.getString("Nombre");
                o[1] = rs.getString("Usuario");
            }
            rs.close();
            st.close();
            return o;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private String[] getListasPD(int id) {
        try {
            String[] o = {"", ""};
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM listapordefecto WHERE id='" + String.valueOf(id) + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                o[0] = rs.getString("Nombre");
                o[1] = this.getNombreGenero(rs.getInt("Genero"));
            }
            rs.close();
            st.close();
            return o;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> getFListasP(String Nick) {
        try {
            ArrayList<String[]> list = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM favlistap WHERE Cliente='" + Nick + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(this.getListasP(rs.getInt("IdLista")));
            }
            rs.close();
            st.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String[]> getFListasPD(String Nick) {
        try {
            ArrayList<String[]> list = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM favlistapd WHERE Cliente='" + Nick + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(this.getListasPD(rs.getInt("IdLista")));
            }
            rs.close();
            st.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int insertarlista(Particular p) {
        try {
            int id = 0;
            PreparedStatement st;
            st = conexion.prepareStatement("INSERT INTO listaparticular (Usuario,Nombre,Privada) VALUES ('" + p.getUsuario() + "','" + p.getNombre() + "', 1)");
            st.executeUpdate();
            st.close();
            st = conexion.prepareStatement("SELECT max(id) as id from listaparticular");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            if(p.getImagen()!=null){
                st = conexion.prepareStatement("UPDATE listaparticular SET Imagen='"+p.getImagen()+"' WHERE Id="+id);
                st.executeUpdate();
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int insertarlista(PorDefecto pd) {
        try {
            int id = 0;
            PreparedStatement st;
            st = conexion.prepareStatement("INSERT INTO listapordefecto (Genero,Nombre) VALUES ('" + String.valueOf(pd.getGenero().getid()) + "','" + pd.getNombre() + "')");
            st.executeUpdate();
            st.close();
            st = conexion.prepareStatement("SELECT max(id) as id from listapordefecto");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            rs.close();
            if(pd.getImagen()!=null){
                st = conexion.prepareStatement("UPDATE listapordefecto SET Imagen='"+pd.getImagen()+"' WHERE Id="+id);
                st.executeUpdate();
            }
            st.close();
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    public void EliminarFavorito(int tipo, int id, String cliente){
        if (tipo==0){
            try{
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM favtema WHERE Cliente='" + cliente + "' AND IdTema='" + id + "'");
            statement.executeUpdate();
            statement.close();
            }
            catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
        if (tipo==1){
            try{
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM favalbum WHERE Cliente='" + cliente + "' AND IdAlbum='" + id + "'");
            statement.executeUpdate();
            statement.close();
            }
            catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
        if (tipo==2){
            try{
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM favlistap WHERE Cliente='" + cliente + "' AND IdLista='" + id + "'");
            statement.executeUpdate();
            statement.close();
            }
            catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
        if (tipo==3){
            try{
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM favlistapd WHERE Cliente='" + cliente + "' AND IdLista='" + id + "'");
            statement.executeUpdate();
            statement.close();
            }
            catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
    }
    
    public void InsertarFavorito(int tipo, String nick, int id){
        if (tipo==0){
            try{
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO favtema "
                    + "(Cliente, IdTema) values(?,?)");
            statement.setString(1, nick);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
            }
            catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
        if (tipo==1){
            try{
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO favalbum "
                    + "(Cliente, IdAlbum) values(?,?)");
            statement.setString(1, nick);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
            }
            catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
        if (tipo==2){
            try{
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO favlistap "
                    + "(Cliente, IdLista) values(?,?)");
            statement.setString(1, nick);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
            }
            catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
        if (tipo==3){
            try{
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO favlistapd "
                    + "(Cliente, IdLista) values(?,?)");
            statement.setString(1, nick);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
            }
            catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
    }

    public void publicarLista(String nickname, String nombreLista) {
        try {
//            PreparedStatement sentencia = conexion.prepareStatement("UPDATE listaparticular " + "SET privada = ?" + "WHERE Usuario = '" + nickname + "'");
            PreparedStatement sentencia = conexion.prepareStatement("UPDATE listaparticular " + "SET Privada = ? WHERE Usuario = ? AND Nombre = ?");
            sentencia.setBoolean(1, false); // el 1 indica el numero de "?" en la sentencia
            sentencia.setString(2, nickname);
            sentencia.setString(3, nombreLista);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean copiarArchivoAlServidor(String rutaOrigenArchivo, String rutaDestino) {
        try {
            File archivoOrigen = new File(rutaOrigenArchivo);

            //Archivo de destino
            File dest = new File(rutaDestino);

            //Crea las carpetas en donde va a ser guardado el archivo si no estaban creadas todavia
            dest.getParentFile().mkdirs();

            //Crea el archivo auxiliar primero para despues sobreescribirlo, sino da error
            dest.createNewFile();

            //Copiar el archivo seleccionado al destino
            Files.copy(archivoOrigen.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            return true; // Se pudo copiar el archivo correctamente
        } catch (IOException ex) {
            Logger.getLogger(ContCliente.class.getName()).log(Level.SEVERE, null, ex);

            return false; // Error, no se pudo copiar el archivo
        }
    }

    public void agregarTemaListaP(int lista, String tema, String album, String nickname) {
        try {
            PreparedStatement st = conexion.prepareStatement("INSERT INTO temalistap VALUES (" + lista + "," + this.getIdTema(tema, album, nickname) + ")");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error tema lista bd");
        }
    }

    public void agregarTemaListaPD(int lista, String tema, String album, String nickname) {
        try {
            PreparedStatement st = conexion.prepareStatement("INSERT INTO temalistapd VALUES (" + lista + "," + this.getIdTema(tema, album, nickname) + ")");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error tema lista bd");
        }
    }

    public void BorrarTemaListaP(int lista, String tema, String album, String nickname) {
        try {
            PreparedStatement st = conexion.prepareStatement("DELETE FROM temalistap WHERE IdLista=" + lista + " and IdTema=" + this.getIdTema(tema, album, nickname));
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error tema lista bd");
        }
    }

    public void BorrarTemaListaPD(int lista, String tema, String album, String nickname) {
        try {
            PreparedStatement st = conexion.prepareStatement("DELETE FROM temalistapd WHERE IdLista=" + lista + " and IdTema=" + this.getIdTema(tema, album, nickname));
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error tema lista bd");
        }
    }


    private int getIdTema(String nombre, String album, String nickname) {
        try {
            int id = 0;
            PreparedStatement st;
            st = conexion.prepareStatement("SELECT Id from tema where Nombre='"+ nombre +"' and IdAlbum="+ this.getIdAlbum(album, nickname));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("Id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
    private int getIdAlbum(String nombre, String nickname) {
        try {
            int id = 0;
            PreparedStatement st;
            st = conexion.prepareStatement("SELECT Id from album where Nombre='"+ nombre +"' and Artista = '"+nickname+"'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("Id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
    public void insertarGenero(Genero g) {
        try {
            PreparedStatement st;
            st = conexion.prepareStatement("INSERT INTO genero (Nombre, idPadre) VALUES ('" + g.getNombre() + "'," + g.getidpadre() + ")");
            st.executeUpdate();
            st.close();
            st = conexion.prepareStatement("SELECT max(id) as id from genero");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                g.setId(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //Encriptar contraseñas
    String sha1(String pass) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(pass.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }

}
