/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author stephiRM
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class DtArtista extends DtUsuario{
    private final String biografia;
    private final String pagWeb;
    private final int cantSeguidores;
    private final ArrayList<String> nickSeguidores;
    private final ArrayList<DtAlbum> albumes;

    //Tuve que crearlo porque sino no se podia usar en web service
    public DtArtista() {
        this.nickname = null;
        this.contrasenia = null;
        this.nombre = null;
        this.apellido = null;
        this.fechaNac = null;
        this.correo = null;
        this.biografia = null;
        this.pagWeb = null;
        this.cantSeguidores = 0;
        this.nickSeguidores = null;
        this.albumes = null;
        this.rutaImagen = null;
    }
    
    public DtArtista(String nickname, String contrasenia, String nombre, String apellido, String correo, String fechaNac, String biografia, String pagWeb, int cantSeguidores, ArrayList<String> nickSeguidores, ArrayList<DtAlbum> albumes, String rutaImg) {
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.biografia = biografia;
        this.pagWeb = pagWeb;
        this.cantSeguidores = cantSeguidores;
        this.nickSeguidores = nickSeguidores;
        this.albumes = albumes;
        this.rutaImagen = rutaImg;
    }    
    
    public DtArtista(String nick, String nombre, String ape, String correo){
        this.nickname = nick;
        this.nombre = nombre;
        this.apellido = ape;
        this.correo = correo;
        this.biografia = null;
        this.pagWeb = null;
        this.cantSeguidores = 0;
        this.nickSeguidores = null;
        this.albumes = null;
        this.rutaImagen = null;
    }
        
    public String getBiografia() {
        return biografia;
    }

    public String getPagWeb() {
        return pagWeb;
    }

    public int getCantSeguidores() {
        return cantSeguidores;
    }

    public ArrayList<String> getNickSeguidores() {
        return nickSeguidores;
    }

    public ArrayList<DtAlbum> getAlbumes() {
        return albumes;
    }

    public String getContrasenia() {
        return contrasenia;
    }    
    
}
