/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtArtista;
import Logica.Fabrica;
import Logica.IcontArtista;
import Logica.IcontCliente;
import Logica.Genero;
import Logica.Tema;
import Logica.Artista;
import Logica.Album;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Admin
 */
public class AltaAlbum extends javax.swing.JInternalFrame {
    
    private IcontArtista Art;
    private IcontCliente Cli;
    private DefaultTableModel modelo;
    private DefaultTableModel modelotemas;
    private JDesktopPane escritorio;
    private String x;
    private HashMap<String, Genero> gendealbum = new HashMap();
    private HashMap<String, Tema> temas = new HashMap();
    private DefaultListModel lista = new DefaultListModel();
    private int contador=0;
    /**
     * Creates new form AltaAlbum
     */
    public AltaAlbum(JDesktopPane escritorio) {
        initComponents();
        this.Art = Fabrica.getArtista();
        this.Cli = Fabrica.getCliente();
        setResizable(false);
        this.BusquedaArtista.setText("");
        this.NombreArtista.setText("Seleccionar en tabla...");
        this.NombreArtista.setEditable(false);
        this.NombreAlbum.setEditable(false);
        this.anio.setEditable(false);
        this.jButton1.setEnabled(false);
        this.jButton2.setEnabled(false);
        this.jButton3.setEnabled(false);
        this.escritorio = escritorio;
        this.modelotemas = (DefaultTableModel) tablart1.getModel();
        this.modelotemas.setRowCount(0);
    }

    public int getContador(){
        return contador;
    }
    public void SetContador(int x){
        this.contador = x;
    }
    public JTable getTablaTemas(){
        return this.tablart1;
    }
    public DefaultTableModel getModeloTemas(){
        return this.modelotemas;
    }
    public DefaultListModel getModelo(){
        return lista;
    }
    public Map<String, Genero> getGeneros(){
        return this.gendealbum;
    }
    public Map<String, Tema> getTemas(){
        return this.temas;
    }
    public JList<String> getLista(){
        return listageneros;
    }
    
    public JButton getboton(){
        return this.jButton2;
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BusquedaArtista = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablart = new javax.swing.JTable();
        NombreArtista = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NombreAlbum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        anio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listageneros = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablart1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo Album");

        BusquedaArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaArtistaActionPerformed(evt);
            }
        });
        BusquedaArtista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BusquedaArtistaKeyReleased(evt);
            }
        });

        jLabel1.setText("1. Buscar Artista");

        tablart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablart);

        NombreArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreArtistaActionPerformed(evt);
            }
        });

        jLabel2.setText("2. Artista Seleccionado:");

        jLabel3.setText("3. Insertar Datos del Album");

        NombreAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreAlbumActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre:");

        anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioActionPerformed(evt);
            }
        });

        jLabel5.setText("Año:");

        jLabel6.setText("Ruta de Imagen:");

        foto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Elegir Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar Generos...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar Temas...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listageneros);

        jLabel9.setText("Géneros Asociados");

        jLabel10.setText("Temas Asociados");

        tablart1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden", "Nombre", "Duración", "URL", "Archivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablart1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablart1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablart1);

        jButton4.setText("Aceptar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar Temas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BusquedaArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(NombreAlbum))
                                        .addGap(16, 16, 16))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8))
                                            .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(8, 8, 8)
                                        .addComponent(NombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BusquedaArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(NombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))
                            .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BusquedaArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaArtistaActionPerformed

    private void BusquedaArtistaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusquedaArtistaKeyReleased
        if (Art.GetGeneros()==null)
            javax.swing.JOptionPane.showMessageDialog(null,"No hay artistas ingresados", "Aviso", 2);
        else{
            this.NombreAlbum.setEditable(false);
            this.anio.setEditable(false);
            this.jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            List<DtArtista> artistas = Art.BuscarArtistas(BusquedaArtista.getText());
            modelo=(DefaultTableModel) tablart.getModel();
            modelo.setRowCount(0);
            for (int i=0;i<artistas.size();i++){
                DtArtista dt = (DtArtista)artistas.get(i);
                Object[] dat={dt.getNickname(), dt.getNombre(), dt.getApellido()};
                modelo.addRow(dat);
                }
            }
    }//GEN-LAST:event_BusquedaArtistaKeyReleased

    private void tablartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablartMouseClicked
        x = (String) modelo.getValueAt(tablart.getSelectedRow(), 0);
        NombreArtista.setText(x);
        this.NombreAlbum.setEditable(true);
        this.anio.setEditable(true);
        this.jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
    }//GEN-LAST:event_tablartMouseClicked

    private void NombreArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreArtistaActionPerformed

    private void NombreAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreAlbumActionPerformed

    private void anioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser elegirimagen = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "jpg","png", "JPG","PNG"); // filtro para el Filechooser
        elegirimagen.setFileFilter(filtro);
        int a= elegirimagen.showOpenDialog(this); // guarda la accion que se realiza en el filechooser
        
        if(a == JFileChooser.APPROVE_OPTION){ // la accion si se le da a abrir
            File archivo = elegirimagen.getSelectedFile(); // capturar el nombre y ruta
            
            
            String Rutaimagen = archivo.getPath();
            
            jLabel8.setText(Rutaimagen);
            ImageIcon imagen = new ImageIcon(Rutaimagen); //genera la imagen que seleccionamos
            Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(),foto.getHeight(),Image.SCALE_DEFAULT));
                        
            this.foto.setIcon(icono); // coloca la imagen en el label
            this.pack();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AltaAlbum_SelectGenero albse = new AltaAlbum_SelectGenero(this);
        escritorio.add(albse);
        albse.setVisible(true);
        albse.centrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AltaAlbum_AltaTema aat = new AltaAlbum_AltaTema(this);
        escritorio.add(aat);
        aat.setVisible(true);
        aat.centrar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablart1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablart1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablart1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String cadenaart,cadenanom,cadenaanio,cadenaimg;
        if (jLabel8.getText().equals(""))
                cadenaimg = null;
        else
            cadenaimg = jLabel8.getText();
        if (this.temas.isEmpty())
            javax.swing.JOptionPane.showMessageDialog(null, "Este album no tiene ningun tema agregado", "Error",0);
        if (this.gendealbum.isEmpty())
            javax.swing.JOptionPane.showMessageDialog(null, "Este album no tiene ningun género agregado", "Error",0);
        if (!this.gendealbum.isEmpty() && !this.temas.isEmpty()){
            //javax.swing.JOptionPane.showMessageDialog(null, "Bien", "bien",0);
            cadenaart = NombreArtista.getText();
            cadenanom = NombreAlbum.getText();
            cadenaanio = anio.getText();
            
            if (cadenanom.isEmpty() || cadenaanio.isEmpty()){
                javax.swing.JOptionPane.showMessageDialog(null, "Se deben llenar todos los campos vacíos", "Error",0);
                NombreAlbum.requestFocus();
            }
            else{
                int x = Integer.parseInt(anio.getText());
                if (x<1500 || x>2017)
                    javax.swing.JOptionPane.showMessageDialog(null, "Año inválido", "Error",0);
                else
                    if ((Art.GetArtistas().get(cadenaart).getAlbumes().get(cadenanom))!=null) {
                        javax.swing.JOptionPane.showMessageDialog(null, "Este Artista ya tiene un album con ese nombre", "Error",0);
                    }
                    else{
                        Art.IngresarAlbum(cadenaart, cadenaanio, cadenanom, cadenaimg, this.temas, this.gendealbum);
                        javax.swing.JOptionPane.showMessageDialog(null, "Album Ingresado Correctamente", "Operación Finalizada",1);
                        this.dispose();
                    }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.temas.clear();
        this.modelotemas.setRowCount(0);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BusquedaArtista;
    private javax.swing.JTextField NombreAlbum;
    private javax.swing.JTextField NombreArtista;
    private javax.swing.JTextField anio;
    private javax.swing.JLabel foto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> listageneros;
    private javax.swing.JTable tablart;
    private javax.swing.JTable tablart1;
    // End of variables declaration//GEN-END:variables
}
