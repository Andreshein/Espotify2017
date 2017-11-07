/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtAlbum;
import Logica.DtTema;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Album extends javax.swing.JInternalFrame {

    /**
     * Creates new form Album
     */
    public Album(DtAlbum album, String Nombre) {
        initComponents();
        ImageIcon imagen = null;
        this.lblAlbum.setText(album.getNombre());
        this.lblArtista.setText(Nombre);
        this.lblAnio.setText(String.valueOf(album.getAnio()));
        if (album.getRutaImagen() != null) {
            File archivo = new File(album.getRutaImagen());
            String Rutaimagen = archivo.getPath();
            imagen = new ImageIcon(Rutaimagen);
            Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(275,208,Image.SCALE_DEFAULT));          
            this.lblImagen.setIcon(icono);
        }else
            this.lblImagen.setIcon(null);
        ArrayList<DtTema> temas = album.getTemas();
        DefaultTableModel modeloTemas=(DefaultTableModel) tablap1.getModel();
        modeloTemas.setRowCount(0);
        for (DtTema tema: temas) {
            Object[] dat={
                tema.getOrden(),
                tema.getNombre(),
                tema.getDuracion(),
                tema.getDireccion(),
                tema.getArchivo(),
                
            };
            modeloTemas.addRow(dat);
        }
    }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblAlbum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblArtista = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablap1 = new javax.swing.JTable();

        setClosable(true);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Temas:");

        lblAlbum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAlbum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlbum.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Artista:");

        lblArtista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblArtista.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Año:");

        lblAnio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAnio.setText("jLabel2");

        tablap1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablap1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden", "Nombre Tema", "Duración", "Dirección", "Archivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablap1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablap1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablap1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tablap1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(59, 59, 59)
                                .addComponent(lblAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41)
                                .addComponent(lblArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblArtista))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblAnio))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlbum;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblArtista;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tablap1;
    // End of variables declaration//GEN-END:variables
}
