/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtGenero;
import Logica.Fabrica;
import Logica.IcontArtista;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author ninoh
 */
public class AltaGenero extends javax.swing.JInternalFrame {
    private IcontArtista Art;
    public AltaGenero() {
        initComponents();
        Art= Fabrica.getArtista();
        this.listargeneros();
    }
    private void listargeneros() {
        DtGenero g = this.Art.listarGArbol();
        DefaultMutableTreeNode principal = new DefaultMutableTreeNode(g.getNombre());
        DefaultTreeModel model = new DefaultTreeModel(principal);
        lgh(model, principal, g.getHijos());
        this.arbol.setModel(model); 
    }

    private void lgh(DefaultTreeModel modelo, DefaultMutableTreeNode padre, ArrayList<DtGenero> g) {
        for (int i = 0; i < g.size(); i++) {
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(g.get(i).getNombre());
            modelo.insertNodeInto(hijo, padre, i);
            lgh(modelo, hijo, g.get(i).getHijos());
        }
    }
     public void centrar() {
        //este metodo devuelve el tamaÃ±o de la pantalla
        Dimension pantalla = this.getParent().getSize();;
        //obtenemos el tamaÃ±o de la ventana
        Dimension ventana = this.getSize();
        //para centrar la ventana lo hacemos con el siguiente calculo
        int a = pantalla.width;
        int b = ventana.width;
        a = (a - b) / 2;
        int c = pantalla.height;
        int d = ventana.height;
        c = (c - d) / 2;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTree1);

        jScrollPane2.setViewportView(arbol);

        jLabel1.setText("Nombre nuevo Genero: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Crear nuevo genero");

        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccionar Genero Padre ");

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Nombre)
                    .addComponent(Aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancelar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        try{
        DefaultMutableTreeNode nodoSeleccionado;
        nodoSeleccionado = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();
        if(nodoSeleccionado != null && !txt_Nombre.getText().equals("")){
        String padre = (String) nodoSeleccionado.getUserObject();
        String nombre =  txt_Nombre.getText();
        this.Art.CrearGenero(nombre, padre);
        javax.swing.JOptionPane.showMessageDialog(null,"Genero agregado");
        dispose();
        }else{
        if(nodoSeleccionado == null) throw new Exception("Seleccione genero padre");
        if(txt_Nombre.getText().equals("")) throw new Exception("Escriba el nombre del genero");
        }}catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        dispose();
    }//GEN-LAST:event_CancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTree arbol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField txt_Nombre;
    // End of variables declaration//GEN-END:variables
}
