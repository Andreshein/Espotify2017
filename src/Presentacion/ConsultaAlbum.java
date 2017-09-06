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
import Logica.Fabrica;
import Logica.IcontArtista;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author usuario
 */
public class ConsultaAlbum extends javax.swing.JInternalFrame {

    private IcontArtista Art;
    ArrayList<DtAlbum> al = new ArrayList<>();
    private ArrayList<ImageIcon> imagenes = new ArrayList<>();
    /**
     * Creates new form ConsultaAlbum
     */
   public ConsultaAlbum() {
        initComponents();
        this.Art=Fabrica.getArtista(); 
        setTitle("Consulta Álbum"); // nombre de la ventana
        setResizable(false);
        buscarTipo("Género");
        this.botonDescargar.setEnabled(false);
        this.botonurl.setEnabled(false);
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
        txnombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablap1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        botonDescargar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablap = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaGenerosAlbum = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        PanelArtistas = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaArtista = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        PanelGeneros = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaGeneros = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        botonurl = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Género", "Artista" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        txnombre.setToolTipText("");
        txnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablap1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Tema", "Duración", "Orden", "Dirección", "Archivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablap1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablap1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablap1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Imágen");

        Imagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botonDescargar.setText("Descargar Archivo");
        botonDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDescargarActionPerformed(evt);
            }
        });

        tablap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artista", "Álbum", "Año"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablapMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablap);

        listaGenerosAlbum.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaGenerosAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaGenerosAlbumMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(listaGenerosAlbum);

        contenedor.setLayout(new java.awt.CardLayout());

        tablaArtista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nick", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaArtista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaArtistaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaArtista);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Artistas");

        javax.swing.GroupLayout PanelArtistasLayout = new javax.swing.GroupLayout(PanelArtistas);
        PanelArtistas.setLayout(PanelArtistasLayout);
        PanelArtistasLayout.setHorizontalGroup(
            PanelArtistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArtistasLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelArtistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelArtistasLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
        );
        PanelArtistasLayout.setVerticalGroup(
            PanelArtistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArtistasLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
        );

        contenedor.add(PanelArtistas, "PanelArtistas");

        listaGeneros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaGeneros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaGenerosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(listaGeneros);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Géneros:");

        javax.swing.GroupLayout PanelGenerosLayout = new javax.swing.GroupLayout(PanelGeneros);
        PanelGeneros.setLayout(PanelGenerosLayout);
        PanelGenerosLayout.setHorizontalGroup(
            PanelGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGenerosLayout.createSequentialGroup()
                .addGroup(PanelGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        PanelGenerosLayout.setVerticalGroup(
            PanelGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelGenerosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contenedor.add(PanelGeneros, "PanelGeneros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Álbumes:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Géneros del álbum:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Temas:");

        botonurl.setText("Abrir URL");
        botonurl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonurlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(136, 136, 136))
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(botonDescargar)
                                .addGap(41, 41, 41)
                                .addComponent(botonurl))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBuscar)
                    .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonDescargar)
                    .addComponent(jButton1)
                    .addComponent(botonurl))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        buscarTipo( (String) combo.getSelectedItem() );
    }//GEN-LAST:event_comboActionPerformed

    private void btBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscarMouseClicked

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if(combo.getSelectedItem().equals("Género")){
            ArrayList<String> listageneros = this.Art.BuscarGenero(this.txnombre.getText());
            DefaultListModel modelo= new DefaultListModel();
            for (String genero:listageneros) {
            
            modelo.addElement(genero);}
            this.listaGeneros.setModel(modelo);


        }else {
            ArrayList<DtArtista> art = this.Art.BuscarArtista(this.txnombre.getText());
            DefaultTableModel modelo=(DefaultTableModel) tablaArtista.getModel();
            modelo.setRowCount(0);
            for (DtArtista artista: art) {
                Object[] dat={
                    artista.getNickname(),
                    artista.getNombre(),
                    artista.getApellido(),
                };
                modelo.addRow(dat);
            }
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tablap.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla albumes
        
        listaGenerosAlbum.setModel(new DefaultListModel<>()); //limpiar generos del album
        Imagen.setIcon(null); //limpiar imagen
        
        modelo = (DefaultTableModel) tablap1.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla temas
    }//GEN-LAST:event_btBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listaGenerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaGenerosMouseClicked
        String generoSelec = listaGeneros.getSelectedValue();
        al = Art.listarAlbumGenero(generoSelec);
        
        imagenes.clear(); //limpiar las imagenes de los albumes mostrados antes
        Imagen.setIcon(null); //limpiar imagen mostrada
        
        DefaultTableModel modelo=(DefaultTableModel) tablap.getModel();
        modelo.setRowCount(0);
        for (int i=0;i<al.size();i++) {
            DtAlbum p=(DtAlbum)al.get(i);
            Object[] dat={
                p.getNombreArtista(),
                p.getNombre(),
                p.getAnio(),
            };
            modelo.addRow(dat);

            imagenes.add(p.getImagen()); // si no tiene imagen, guarda el null para limpiar la imagen al seleccionar el album
        }
         
        listaGenerosAlbum.setModel(new DefaultListModel<>());
        Imagen.setIcon(null);
        
        modelo = (DefaultTableModel) tablap1.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla temas
    }//GEN-LAST:event_listaGenerosMouseClicked

    private void listaGenerosAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaGenerosAlbumMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaGenerosAlbumMouseClicked

    private void tablapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablapMouseClicked
        ArrayList<String> gen = al.get(tablap.getSelectedRow()).getGeneros();
        DefaultListModel modelo= new DefaultListModel();
        for (String genero:gen) {
            modelo.addElement(genero);
        }
        this.listaGenerosAlbum.setModel(modelo);
        
        String nickname = (String) tablap.getValueAt(tablap.getSelectedRow(), 0);
        String nomalb = (String) tablap.getValueAt(tablap.getSelectedRow(), 1);
        ArrayList<DtTema> temas = this.Art.obtenerTema(nickname, nomalb);
        DefaultTableModel modeloTemas=(DefaultTableModel) tablap1.getModel();
        modeloTemas.setRowCount(0);
        for (DtTema tema: temas) {
            Object[] dat={
                tema.getNombre(),
                tema.getDuracion(),
                tema.getOrden(),
                tema.getDireccion(),
                tema.getArchivo(),
            };
            modeloTemas.addRow(dat);
        }
        
        int indice = tablap.getSelectedRow(); //el indice es la fila del album seleccionado
        if(imagenes.get(indice) != null){
            Icon icono= new ImageIcon(imagenes.get(indice).getImage().getScaledInstance(Imagen.getWidth(),Imagen.getHeight(),Image.SCALE_DEFAULT));

            Imagen.setIcon(icono); // coloca la imagen en el label

            this.pack();
        }else{
            Imagen.setIcon(null); // se limpia la imagen del label
        }
    }//GEN-LAST:event_tablapMouseClicked

    private void botonDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDescargarActionPerformed
        if(tablap1.getSelectedRow()>-1){
            String ruta = (String) tablap1.getValueAt(tablap1.getSelectedRow(), 4);
            if(ruta != null){
            JFileChooser elegirArchivo = new JFileChooser();
            elegirArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            elegirArchivo.setAcceptAllFileFilterUsed(false);
            elegirArchivo.setDialogTitle("Seleccionar carpeta");

            int a= elegirArchivo.showDialog(this, "Seleccionar"); // guarda la accion que se realiza en el filechooser

            if(a == JFileChooser.APPROVE_OPTION){ // la accion si se le da a abrir
//            File archivo = elegirarchivo.getSelectedFile(); // capturar el nombre y ruta
//            String RutaArchivo = archivo.getPath();
                String carpetaDestino = elegirArchivo.getSelectedFile().toString();
            
                
                String nickArtista = (String) tablap.getValueAt(tablap.getSelectedRow(), 0);
                String nombreTema = (String) tablap1.getValueAt(tablap1.getSelectedRow(), 0);

                if(Art.descargarArchivo(ruta, carpetaDestino, nickArtista, nombreTema) == true){
                    JOptionPane.showMessageDialog(this,"Se ha descargado el archivo correctamente","Descarga completa",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this,"Ha ocurrido un error al decargar el tema, la descarga ha sido cancelada","Descarga cancelada",javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
            }else{
                 JOptionPane.showMessageDialog(this,"El tema seleccionado no tiene archivo","Aviso",javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonDescargarActionPerformed

    private void tablaArtistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArtistaMouseClicked
        String nickname = (String) tablaArtista.getValueAt(tablaArtista.getSelectedRow(), 0);
        al = Art.listarAlbumesArtista(nickname);
        
        imagenes.clear(); //limpiar las imagenes de los albumes mostrados antes
        Imagen.setIcon(null); //limpiar imagen mostrada
        
        DefaultTableModel modelo=(DefaultTableModel) tablap.getModel();
        modelo.setRowCount(0);
        for (int i=0;i<al.size();i++) {
            DtAlbum p=(DtAlbum)al.get(i);
            Object[] dat={
                p.getNombreArtista(),
                p.getNombre(),
                p.getAnio(),
            };
            modelo.addRow(dat);
        
            imagenes.add(p.getImagen()); // si no tiene imagen, guarda el null para limpiar la imagen al seleccionar el album
        }

        listaGenerosAlbum.setModel(new DefaultListModel<>());
        Imagen.setIcon(null);
        
        modelo = (DefaultTableModel) tablap1.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla temas
    }//GEN-LAST:event_tablaArtistaMouseClicked

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnombreActionPerformed

    private void tablap1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablap1MouseClicked
        String archivo = (String) tablap1.getValueAt(tablap1.getSelectedRow(), 4);
        String url = (String) tablap1.getValueAt(tablap1.getSelectedRow(), 3);
        if (archivo==null){
            this.botonDescargar.setEnabled(false);
            this.botonurl.setEnabled(true);
        }
        if (url==null){
            this.botonDescargar.setEnabled(true);
            this.botonurl.setEnabled(false);
        }
    }//GEN-LAST:event_tablap1MouseClicked

    private void botonurlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonurlActionPerformed
        String url = (String) tablap1.getValueAt(tablap1.getSelectedRow(), 3);
        url = "http://" + url;
        try{
        if(Desktop.isDesktopSupported())
            {
            Desktop.getDesktop().browse(new URI(url));
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(ConsultaAlbum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsultaAlbum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonurlActionPerformed
  
    
    public void buscarTipo(String tipo){
        CardLayout cl = (CardLayout)(contenedor.getLayout());
        
        switch(tipo){
            case "Género":
                cl.show(contenedor, "PanelGeneros");
                break;
            case "Artista":
                cl.show(contenedor, "PanelArtistas");
                break;
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
    private javax.swing.JLabel Imagen;
    private javax.swing.JPanel PanelArtistas;
    private javax.swing.JPanel PanelGeneros;
    private javax.swing.JButton botonDescargar;
    private javax.swing.JButton botonurl;
    private javax.swing.JButton btBuscar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<String> listaGeneros;
    private javax.swing.JList<String> listaGenerosAlbum;
    private javax.swing.JTable tablaArtista;
    private javax.swing.JTable tablap;
    private javax.swing.JTable tablap1;
    private javax.swing.JTextField txnombre;
    // End of variables declaration//GEN-END:variables
}
