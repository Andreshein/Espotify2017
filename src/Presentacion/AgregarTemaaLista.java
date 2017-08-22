/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Fabrica;
import Logica.IcontArtista;
import Logica.IcontCliente;
import Logica.Particular;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static javax.xml.bind.DatatypeConverter.parseInteger;

public class AgregarTemaaLista extends javax.swing.JInternalFrame {
     
    private IcontCliente Cli;
    
    public AgregarTemaaLista() {
        initComponents();
        setTitle("AgregarTemaaLista");
        Fabrica f = Fabrica.getInstance();
        this.Cli=f.getCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmb_Busqueda = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        cmb_Lista = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        PanelPadre = new javax.swing.JPanel();
        Album = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAlbum = new javax.swing.JTable();
        ListaPD = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaPart = new javax.swing.JList<>();
        ListaP = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaListaP = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(745, 621));

        cmb_Busqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Album", "Lista Por Defecto", "Lista Particular" }));
        cmb_Busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_BusquedaActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione el tipo de busqueda: ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Artista", "Album"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Aceptar");

        jButton2.setText("Cancelar");

        jScrollPane4.setViewportView(jList2);

        jLabel2.setText("Lista a agregar Tema: ");

        cmb_Lista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por Defecto", "Particular" }));
        cmb_Lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ListaActionPerformed(evt);
            }
        });

        jLabel3.setText("Temas: ");

        PanelPadre.setLayout(new java.awt.CardLayout());

        TablaAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artista", "Nombre Album", "Año"
            }
        ));
        jScrollPane2.setViewportView(TablaAlbum);

        javax.swing.GroupLayout AlbumLayout = new javax.swing.GroupLayout(Album);
        Album.setLayout(AlbumLayout);
        AlbumLayout.setHorizontalGroup(
            AlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
            .addGroup(AlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlbumLayout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        AlbumLayout.setVerticalGroup(
            AlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(AlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        );

        PanelPadre.add(Album, "Album");

        jScrollPane3.setViewportView(ListaPart);

        javax.swing.GroupLayout ListaPDLayout = new javax.swing.GroupLayout(ListaPD);
        ListaPD.setLayout(ListaPDLayout);
        ListaPDLayout.setHorizontalGroup(
            ListaPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
            .addGroup(ListaPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
        );
        ListaPDLayout.setVerticalGroup(
            ListaPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(ListaPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        );

        PanelPadre.add(ListaPD, "ListaPD");

        TablaListaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artista", "Nombre Lista"
            }
        ));
        jScrollPane5.setViewportView(TablaListaP);

        javax.swing.GroupLayout ListaPLayout = new javax.swing.GroupLayout(ListaP);
        ListaP.setLayout(ListaPLayout);
        ListaPLayout.setHorizontalGroup(
            ListaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
            .addGroup(ListaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ListaPLayout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        ListaPLayout.setVerticalGroup(
            ListaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(ListaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ListaPLayout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PanelPadre.add(ListaP, "ListaP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_Lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelPadre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_Lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelPadre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_BusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_BusquedaActionPerformed
        CardLayout cl = (CardLayout)(PanelPadre.getLayout());
        String Busqueda= (String) cmb_Busqueda.getSelectedItem();
        if(Busqueda.equals("Album"))
        {
            cl.show(PanelPadre, "Album");
        }
        if(Busqueda.equals("Lista Por Defecto"))
        {
            cl.show(PanelPadre, "ListaPD");
        }
        if(Busqueda.equals("Lista Particular"))
        {
            cl.show(PanelPadre, "ListaP");
        }
        
    }//GEN-LAST:event_cmb_BusquedaActionPerformed

    private void cmb_ListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ListaActionPerformed
        String texto=cmb_Lista.getSelectedItem().toString();
        if("Particular".equals(texto))
        {            
          ArrayList<Particular> listap=Cli.ListarListaP();
            DefaultTableModel modelo=(DefaultTableModel) jList2.getModel();
            modelo.setRowCount(0);
            for (int i=0;i<listap.size();i++) {
            Particular lp=(Particular)listap.get(i);
            Object[] dat={lp.getNombre(),lp.getDtTemas()};
            modelo.addRow(dat);
        }
        /*else if("Por Defecto".equals(texto))
        {
            
        } */              
        }
    }//GEN-LAST:event_cmb_ListaActionPerformed

    public void centrar(){
        //este metodo devuelve el tamaÃ±o de la pantalla
        Dimension pantalla = this.getParent().getSize();
        //obtenemos el tamaÃ±o de la ventana
        Dimension ventana = this.getSize();
        //para centrar la ventana lo hacemos con el siguiente calculo
        int a = pantalla.width;
        int b = ventana.width;
        a = (a-b)/2;
        int c = pantalla.height;
        int d = ventana.height;
        c = (c-d)/2;
        this.setLocation(a, c);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Album;
    private javax.swing.JPanel ListaP;
    private javax.swing.JPanel ListaPD;
    private javax.swing.JList<String> ListaPart;
    private javax.swing.JPanel PanelPadre;
    private javax.swing.JTable TablaAlbum;
    private javax.swing.JTable TablaListaP;
    private javax.swing.JComboBox<String> cmb_Busqueda;
    private javax.swing.JComboBox<String> cmb_Lista;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
