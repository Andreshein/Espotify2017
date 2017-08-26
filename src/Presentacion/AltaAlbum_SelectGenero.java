/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Genero;
import Logica.Fabrica;
import Logica.IcontArtista;
import Logica.IcontCliente;
import java.awt.Dimension;
import javax.swing.tree.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class AltaAlbum_SelectGenero extends javax.swing.JInternalFrame {

    private IcontArtista Art;
    private IcontCliente Cli;
    /**
     * Creates new form AltaAlbum_SelectGenero
     */
    public AltaAlbum_SelectGenero() {
        initComponents();
        this.Art = Fabrica.getArtista();
        this.Cli = Fabrica.getCliente();
        LlenarArbol(0, null);
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
    public void LlenarArbol(int padre, DefaultMutableTreeNode nodo){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Géneros");
        Map<String, Genero> ListaGeneros = new HashMap();
        ListaGeneros = Art.GetGeneros();
        Set set = ListaGeneros.entrySet();
        Iterator it = set.iterator();
        DefaultTreeModel modeloarbol = new DefaultTreeModel(root);
        this.arbolgen.setModel(modeloarbol);
        while (it.hasNext()){
            Map.Entry mentry = (Map.Entry)it.next();
            Genero g = (Genero) mentry.getValue();
            if(g.getidpadre()== padre){
                DefaultMutableTreeNode nuevonodo = new DefaultMutableTreeNode(g.getNombre());
                if(padre == 0)
                    root.add(nuevonodo);
                else
                    nodo.add(nuevonodo);
                
                LlenarArbol(g.getid(), nuevonodo);
            }
        }
        this.arbolgen.setModel(modeloarbol);
        DefaultMutableTreeNode selected = (DefaultMutableTreeNode) arbolgen.getLastSelectedPathComponent();
        //selected.getUserObject()
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
        arbolgen = new javax.swing.JTree();

        setClosable(true);
        setIconifiable(true);

        jScrollPane1.setViewportView(arbolgen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolgen;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
