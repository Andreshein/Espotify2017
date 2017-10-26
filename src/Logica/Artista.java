/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author ninoh
 */
public class Artista extends Usuario {
    private String biografia;
    private String paginaWeb;
    private HashMap<String, Album> albumes;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public Artista(String nickname,String contrasenia, String nombre, String apellido,String correo, Date fechaNac, String biografia, String paginaWeb, String Imag) {
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.biografia = biografia;
        this.paginaWeb = paginaWeb;
        this.albumes= new HashMap<>();
        this.Imagen= Imag;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public HashMap<String, Album> getAlbumes() {
        return albumes;
    }
    
    public ArrayList<DtAlbum> ListarAlbumes() {
        ArrayList<DtAlbum> albumesAux = new ArrayList();
        for (Album a : this.albumes.values()) {
            albumesAux.add(a.getDatos());
        }
        return albumesAux;
        }

    public void setAlbumes(HashMap<String, Album> albumes) {
        this.albumes = albumes;
    }
    
    public void setAlbum(Album a ){
        this.albumes.put(a.getNombre(),a);
    }
    
    @Override
    public DtArtista getDatos(){
        return new DtArtista(nickname, contrasenia, nombre, apellido, correo, formato.format(fechaNac), biografia, paginaWeb, 0, null, this.getDtAlbumes(), Imagen);
    }
    public String getImagen(){
        return Imagen;
    }
    public ArrayList<DtAlbum> getDtAlbumes(){
        ArrayList<DtAlbum> retorno = new ArrayList<>();
        Iterator iterador = this.albumes.values().iterator();
        while(iterador.hasNext()){
            Album aux = (Album)iterador.next();
            retorno.add(aux.getDatos());
        }
        return retorno;
    }
    public ArrayList<DtAlbum> getDtAlbumes2(){
        ArrayList<DtAlbum> retorno = new ArrayList<>();
        Iterator iterador = this.albumes.values().iterator();
        while(iterador.hasNext()){
            Album aux = (Album)iterador.next();
            retorno.add(aux.getDatos(this.nombre));
        }
        return retorno;
    }
    
    public DtArtista getDatosResumidos(){
        return new DtArtista(nickname, contrasenia, nombre, apellido, correo, formato.format(fechaNac), null, null, 0, null, null, Imagen);
    }
    public void AddAlbum(Album a){
        this.albumes.put(a.getNombre(), a);
    }
    
    public DtArtista GetDtArtista(){
        return new DtArtista(nickname,nombre,apellido,correo);
    }
    
    public ArrayList<DtTema> reproducirAlbum(String album){
        return this.albumes.get(album).getTemasReproducir();
    }
    
    public ArrayList<DtTema> coincideciaT(String palabra){
        ArrayList<DtTema> temas = new ArrayList<>();
        for(Album alb: this.albumes.values()){
            temas.addAll(alb.coincideciaT(palabra));
        }
        return temas;
    }
    
    public ArrayList<DtAlbum> coincideciaA(String palabra){
        ArrayList<DtAlbum> albumesAux = new ArrayList<>();
        String cadena = palabra.toUpperCase();
        for(Album alb: this.albumes.values()){
            if(alb.getNombre().toUpperCase().contains(cadena) || alb.getArtista().toUpperCase().contains(cadena))
                albumesAux.add(alb.getDatos());
        }
        return albumesAux;
    }
    public void nuevaDescargaTema (String album, String tema){
        this.albumes.get(album).nuevaDescargaTema(tema);
    }
    public void nuevaReproduccionTema (String album, String tema){
      this.albumes.get(album).nuevaReproduccionTema(tema);
    }
}
