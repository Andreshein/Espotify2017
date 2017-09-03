/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtAlbum;
import Logica.DtTema;
import Logica.DtArtista;
//import Logica.DtDate;
import Logica.DtGenero;
import Logica.Fabrica;
import Logica.IcontArtista;
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
/**
 *
 * @author usuario
 */
public class ConsultaAlbum extends javax.swing.JInternalFrame {

    private IcontArtista Art;
    /**
     * Creates new form ConsultaAlbum
     */
   public ConsultaAlbum() {
        initComponents();
        this.Art=Fabrica.getArtista(); 
        setTitle("Consulta Álbum"); // nombre de la ventana
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        Img = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        Nombre = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablap = new javax.swing.JTable();
        btBuscar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablap1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Género", "Artista" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar por:");

        btBuscar.setText("Buscar");
        btBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBuscarMouseClicked(evt);
            }
        });
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        Img.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jSplitPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Nombre.setText("Nombre");
        jSplitPane1.setLeftComponent(Nombre);

        txnombre.setToolTipText("");
        txnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreActionPerformed(evt);
            }
        });
        jSplitPane1.setRightComponent(txnombre);

        jLabel3.setText("Imágen");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nick", "Álbum", "Año"
            }
        ));
        jScrollPane1.setViewportView(tablap);

        btBuscar1.setText("Seleccionar");
        btBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBuscar1MouseClicked(evt);
            }
        });
        btBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscar1ActionPerformed(evt);
            }
        });

        tablap1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Tema", "Duración", "Orden", "Dirección", "Archivo"
            }
        ));
        jScrollPane2.setViewportView(tablap1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 395, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btBuscar)))))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(btBuscar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed

    }//GEN-LAST:event_comboActionPerformed

    private void btBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscarMouseClicked

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if(combo.getSelectedItem().equals("Género")){
            ArrayList<DtAlbum> al = this.Art.BuscarGenero(this.txnombre.getText());
            DefaultTableModel modelo=(DefaultTableModel) tablap.getModel();
            modelo.setRowCount(0);
            for (int i=0;i<al.size();i++) {
                DtAlbum p=(DtAlbum)al.get(i);
                Object[] dat={
                    p.getNombreArtista(),
                    p.getNombre(),
                    p.getAnio(),
                };
                modelo.addRow(dat);}

        }else {
            ArrayList<DtAlbum> art = this.Art.BuscarArtista(this.txnombre.getText());
            DefaultTableModel modelo=(DefaultTableModel) tablap.getModel();
            modelo.setRowCount(0);
            for (int i=0;i<art.size();i++) {
                DtAlbum al=(DtAlbum)art.get(i);
                Object[] dat={
                    al.getNombreArtista(),
                    al.getNombre(),
                    al.getAnio(),
                };
                modelo.addRow(dat);
            }
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btBuscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBuscar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscar1MouseClicked

    private void btBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscar1ActionPerformed
        if(tablap.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Fila no seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String nickname = (String) tablap.getValueAt(tablap.getSelectedRow(), 0);
            String nomalb = (String) tablap.getValueAt(tablap.getSelectedRow(), 1);
            ArrayList<DtTema> al = this.Art.obtenerTema(nickname, nomalb);
            DefaultTableModel modelo=(DefaultTableModel) tablap1.getModel();
            modelo.setRowCount(0);
            for (int i=0;i<al.size();i++) {
                DtTema p=(DtTema)al.get(i);
                Object[] dat={
                    p.getNombre(),
                    p.getDuracion(),
                    p.getOrden(),
                    p.getDireccion(),
                    p.getArchivo(),
                };
                modelo.addRow(dat);
    }//GEN-LAST:event_btBuscar1ActionPerformed
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Img;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btBuscar1;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tablap;
    private javax.swing.JTable tablap1;
    private javax.swing.JTextField txnombre;
    // End of variables declaration//GEN-END:variables
}
