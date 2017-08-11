/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author stephiRM
 */
public class DtClienteLista {
    private final String nickname;
    private final String nombreLista;

    public DtClienteLista(String nickname, String nombreLista) {
        this.nickname = nickname;
        this.nombreLista = nombreLista;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombreLista() {
        return nombreLista;
    }
    
    
}
