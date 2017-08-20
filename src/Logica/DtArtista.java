/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author stephiRM
 */
public class DtArtista extends DtUsuario{
    private final String biografia;
    private final String pagWeb;
    private final int cantSeguidores;
    private final ArrayList<String> nickSeguidores;
    private final ArrayList<DtAlbum> albumes;

    SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
    
    public DtArtista(String nickname, String nombre, String apellido, String correo, Date fechaNac, ImageIcon imagen, String biografia, String pagWeb, int cantSeguidores, ArrayList<String> nickSeguidores, ArrayList<DtAlbum> albumes) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNac = formato.format(fechaNac);
        this.imagen = imagen;
        this.biografia = biografia;
        this.pagWeb = pagWeb;
        this.cantSeguidores = cantSeguidores;
        this.nickSeguidores = nickSeguidores;
        this.albumes = albumes;
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
}
