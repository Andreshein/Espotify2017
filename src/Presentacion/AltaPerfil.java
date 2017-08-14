/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtDate;
import Logica.Fabrica;
import Logica.IcontArtista;
import Logica.IcontCliente;
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


public class AltaPerfil extends javax.swing.JInternalFrame {

    private IcontArtista Art;
    private IcontCliente Cli; 

    public AltaPerfil() {
        initComponents();
        this.Art=Fabrica.getArtista(); 
        this.Cli=Fabrica.getCliente();
        setTitle("Alta Perfil"); // nombre de la ventana
        setResizable(false); // no se puede modificar el tamaño de la ventana      
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Buscar = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Nick = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        txt_Apellido = new javax.swing.JTextField();
        txt_Correo = new javax.swing.JTextField();
        cmb_Tipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Img = new javax.swing.JLabel();
        CargarImg = new javax.swing.JButton();
        Nomb = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_Biografia = new javax.swing.JTextField();
        txt_PaginaWeb = new javax.swing.JTextField();
        Anio = new javax.swing.JTextField();
        Dia = new javax.swing.JTextField();
        Mes = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(645, 417));

        jLabel1.setText("Nickname: ");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Apellido: ");

        jLabel4.setText("Fecha de Nacimiento: ");

        jLabel5.setText("Correo: ");

        cmb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Artista" }));
        cmb_Tipo.setToolTipText("");
        cmb_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_TipoActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipo de Usuario: ");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Img.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CargarImg.setText("Elegir Imagen");
        CargarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarImgActionPerformed(evt);
            }
        });

        Nomb.setText("Nombre de imagen");

        jLabel7.setText("Biografia: ");

        jLabel8.setText("Pagina Web: ");

        txt_Biografia.setEditable(false);
        txt_Biografia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_Biografia.setEnabled(false);
        txt_Biografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BiografiaActionPerformed(evt);
            }
        });

        txt_PaginaWeb.setEditable(false);
        txt_PaginaWeb.setEnabled(false);
        txt_PaginaWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PaginaWebActionPerformed(evt);
            }
        });

        Dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_Nick)
                                .addComponent(txt_Nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_Apellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_Correo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15))
                                .addComponent(txt_Biografia, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_PaginaWeb, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Anio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jButton1)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap(206, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Nomb, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(CargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Nomb)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(CargarImg))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_Biografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_PaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        txt_Biografia.getAccessibleContext().setAccessibleName("");
        txt_Biografia.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String cadena1,cadena2,cadena3,cadena4,cadena6,cadena7,cadena8;
        String fecha = Dia.getText()+"/"+Mes.getText()+"/"+Anio.getText();
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
        
        cadena1 = txt_Nick.getText();
        cadena2 = txt_Nombre.getText();
        cadena3 = txt_Apellido.getText();
        cadena4 = txt_Correo.getText();
        cadena7 = txt_Biografia.getText();
        cadena8 = txt_PaginaWeb.getText();
        cadena6 = cmb_Tipo.getSelectedItem().toString();
        
        if ((txt_Nick.getText().equals("")) || (txt_Nombre.getText().equals("")) || (txt_Apellido.getText().equals("")) || (txt_Correo.getText().equals("")) || (Dia.getText().equals(""))
            || (Mes.getText().equals("")) || (Anio.getText().equals("")) || ((cmb_Tipo.getSelectedItem() == null))) {

            javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar todos los campos \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Nick.requestFocus();
        }
        else{
        
        boolean Ok;
        if(cadena6.equals("Artista")){
            
           try {
               Ok = Art.IngresarArtista(cadena1,cadena2,cadena3,formato.parse(fecha),cadena4,cadena7,cadena8);
               if(Ok){
                   javax.swing.JOptionPane.showMessageDialog(null,"El artista ha sido dado de alta");}
               else{javax.swing.JOptionPane.showMessageDialog(null,"El artista no ha podido ser dado de alta");}
           } catch (ParseException ex) {
               Logger.getLogger(AltaPerfil.class.getName()).log(Level.SEVERE, null, ex);
               javax.swing.JOptionPane.showMessageDialog(null,"El formato de la Fecha es incorrecto, debe ser tipo: 'dd/MM/yyyy'");
           }
        }

        if(cadena6.equals("Cliente")){
            
           try {
               Ok = Cli.IngresarCliente(cadena1,cadena2,cadena3,formato.parse(fecha),cadena4);
               if(Ok){
                   javax.swing.JOptionPane.showMessageDialog(null,"El cliente ha sido dado de alta");}
               else{javax.swing.JOptionPane.showMessageDialog(null,"El cliente no ha podido ser dado de alta");}
           } catch (ParseException ex) {
               Logger.getLogger(AltaPerfil.class.getName()).log(Level.SEVERE, null, ex);
               javax.swing.JOptionPane.showMessageDialog(null,"El formato de la Fecha es incorrecto, debe ser tipo: 'dd/MM/yyyy'");
           }
    }                                        
    
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarImgActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "jpg","gif","png", "JPG","GIF","PNG"); // filtro para el Filechooser
        Buscar.setFileFilter(filtro);
        int a= Buscar.showOpenDialog(this); // guarda la accion que se realiza en el filechooser
        
        if(a == JFileChooser.APPROVE_OPTION){ // la accion si se le da a abrir
            File archivo = Buscar.getSelectedFile(); // capturar el nombre y ruta
            
            String nombre = archivo.getName();
            String ruta = archivo.getParent();
            
            String Rutaimagen = ruta + "\\"+ nombre;
            
            ImageIcon imagen = new ImageIcon(Rutaimagen); //genera la imagen que seleccionamos
            
            int w = imagen.getIconWidth();
            int h = imagen.getIconWidth();
            this.Img.setSize(w , h); // ajusta la etiqueta al tamaño de la imagen para no tener problemas
            
            this.Img.setIcon(imagen); // coloca la imagen en el label
            this.Nomb.setText(nombre);
            
            this.pack();
        }
        
    }//GEN-LAST:event_CargarImgActionPerformed
    
    private void cmb_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_TipoActionPerformed
        
        String texto;
        texto=cmb_Tipo.getSelectedItem().toString();
        if("Cliente".equals(texto))
        {            
            txt_Biografia.setEnabled(false);
            txt_Biografia.setEditable(false);
            txt_PaginaWeb.setEnabled(false);
            txt_PaginaWeb.setEditable(false);
        }
        else if("Artista".equals(texto))
        {
            txt_Biografia.setEnabled(true);
            txt_Biografia.setEditable(true);
            txt_PaginaWeb.setEnabled(true);
            txt_PaginaWeb.setEditable(true);
        }        
    }//GEN-LAST:event_cmb_TipoActionPerformed
    
        
    private void txt_BiografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BiografiaActionPerformed
    
    }//GEN-LAST:event_txt_BiografiaActionPerformed

    private void txt_PaginaWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PaginaWebActionPerformed

    }//GEN-LAST:event_txt_PaginaWebActionPerformed

    private void DiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Anio;
    private javax.swing.JFileChooser Buscar;
    private javax.swing.JButton CargarImg;
    private javax.swing.JTextField Dia;
    private javax.swing.JLabel Img;
    private javax.swing.JTextField Mes;
    private javax.swing.JLabel Nomb;
    private javax.swing.JComboBox<String> cmb_Tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Biografia;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Nick;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_PaginaWeb;
    // End of variables declaration//GEN-END:variables
}
