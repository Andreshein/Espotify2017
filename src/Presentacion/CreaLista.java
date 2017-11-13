/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.*;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author pc
 */
public class CreaLista extends javax.swing.JInternalFrame {

    private IcontCliente icc;
    private ArrayList<DtCliente> usr;
    private int parte;
    private String ruta;

    public CreaLista() {
        initComponents();
        Fabrica f = Fabrica.getInstance();
        this.icc = f.getCliente();
        this.limpiar();
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

    public void limpiar() {
        this.campo1.setText("");
        this.campo2.setText("");
        this.txNombre.setText("");
        this.txtBuscar.setText("");
        DefaultListModel modelo = new DefaultListModel();
        this.lista.setModel(modelo);
        this.lista.setVisible(false);
        this.scLista.setVisible(false);
        this.Info2.setVisible(false);
        this.campo2.setVisible(false);
        this.Img.setIcon(null);
        this.ruta=null;
        this.usr = new ArrayList<>();
        this.listargeneros();
        this.jButton1.setEnabled(false);
        this.btnBuscar.setEnabled(false);
        this.txtBuscar.setEditable(false);
    }

    private void listargeneros() {
        DtGenero g = this.icc.listarGArbol();
        DefaultMutableTreeNode principal = new DefaultMutableTreeNode(g.getNombre());
        DefaultTreeModel model = new DefaultTreeModel(principal);
        lgh(model, principal, g.getHijos());
        this.arbol.setModel(model);
        this.arbol.setRootVisible(false);
    }

    private void lgh(DefaultTreeModel modelo, DefaultMutableTreeNode padre, ArrayList<DtGenero> g) {
        for (int i = 0; i < g.size(); i++) {
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(g.get(i).getNombre());
            modelo.insertNodeInto(hijo, padre, i);
            lgh(modelo, hijo, g.get(i).getHijos());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Buscar = new javax.swing.JFileChooser();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scArbol = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();
        scLista = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        Img = new javax.swing.JLabel();
        Nomb = new javax.swing.JLabel();
        CargarImg = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        Info1 = new javax.swing.JLabel();
        campo1 = new javax.swing.JLabel();
        Info2 = new javax.swing.JLabel();
        campo2 = new javax.swing.JLabel();
        Confirmar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por defecto", "Particular" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Crear lista de reproducción");

        arbol.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arbolValueChanged(evt);
            }
        });
        scArbol.setViewportView(arbol);

        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        scLista.setViewportView(lista);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        Img.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Nomb.setText("Nombre de imagen");

        CargarImg.setText("Elegir Imagen");
        CargarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarImgActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre:");

        Info1.setText("Genero:");

        campo1.setText("jLabel5");

        Info2.setText("Nombre del Usuario");

        campo2.setText("jLabel7");

        Confirmar.setText("Confirmar");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(scArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(scLista, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBuscar)
                                        .addGap(272, 272, 272))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(Info1)
                                            .addComponent(Info2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campo2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campo1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Nomb, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(CargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(Img, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(Nomb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CargarImg)
                    .addComponent(jButton1))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo1)
                            .addComponent(Info1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Info2)
                            .addComponent(campo2)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scArbol, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(scLista))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(Confirmar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarImgActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "jpg", "png", "JPG", "PNG"); // filtro para el Filechooser
        Buscar.setFileFilter(filtro);
        int a = Buscar.showOpenDialog(this); // guarda la accion que se realiza en el filechooser

        if (a == Buscar.APPROVE_OPTION) { // la accion si se le da a abrir
            File archivo = Buscar.getSelectedFile(); // capturar el nombre y ruta

            String Rutaimagen = archivo.getPath();
            this.ruta = Rutaimagen;
            ImageIcon imagen = new ImageIcon(Rutaimagen); //genera la imagen que seleccionamos
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(Img.getWidth(), Img.getHeight(), Image.SCALE_DEFAULT));
            this.Nomb.setText(Rutaimagen);
            this.Img.setIcon(icono); // coloca la imagen en el label
            this.jButton1.setEnabled(true);
            this.pack();
        }

    }//GEN-LAST:event_CargarImgActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        DefaultListModel list = new DefaultListModel();
        if (!this.txtBuscar.getText().equals("")) {
            this.usr = this.icc.BuscarClientes(this.txtBuscar.getText());
            for (int i = 0; i < this.usr.size(); i++) {
                list.addElement(usr.get(i).getNickname());
            }
        }
        this.lista.setModel(list);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        int index = this.lista.getSelectedIndex();
        if (index != -1) {
            DtCliente dtc = this.usr.get(index);
            this.campo1.setText(dtc.getNickname());
            this.campo2.setText(dtc.getNombre() + " " + dtc.getApellido());
        }
    }//GEN-LAST:event_listaMouseClicked

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        if (this.cmbTipo.getSelectedIndex() == 0) {
            this.btnBuscar.setEnabled(false);
            this.txtBuscar.setEditable(false);
            this.arbol.setVisible(true);
            this.scArbol.setVisible(true);
            this.parte = 0;
            this.lista.setVisible(false);
            this.scLista.setVisible(false);
            this.Info1.setText("Genero:");
            this.Info2.setVisible(false);
            this.campo2.setVisible(false);
            this.campo1.setText("");
            this.campo2.setText("");

        } else {
            this.parte = 1;
            this.btnBuscar.setEnabled(true);
            this.txtBuscar.setEditable(true);
            this.arbol.setVisible(false);
            this.scArbol.setVisible(false);
            this.lista.setVisible(true);
            this.scLista.setVisible(true);
            this.Info1.setText("Nickname:");
            this.Info2.setVisible(true);
            this.campo2.setVisible(true);
            this.campo1.setText("");
            this.campo2.setText("");
        }
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.Img.setIcon(null);
        this.Nomb.setText("Imagen");
        this.ruta=null;
        this.jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void arbolValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arbolValueChanged
        DefaultMutableTreeNode nodoSeleccionado;
        nodoSeleccionado = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();
        if(nodoSeleccionado != null){
        String valor = (String) nodoSeleccionado.getUserObject();
        this.campo1.setText(valor);}
    }//GEN-LAST:event_arbolValueChanged

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
        try{
        switch (this.parte) {
            case 0: {
                String genero = this.campo1.getText();
                if(genero.equals("")) 
                    throw new Exception("No selecciono genero");
                String nombre = this.txNombre.getText();
                if(nombre.equals("")) 
                    throw new Exception("Debe nombrar la lista de reproducción");
                nombre = this.ConvertirString(nombre);
                Calendar fecha = Calendar.getInstance();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH);
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                String fechac = año + "-" + (mes+1) + "-" + dia;
                this.icc.crearListaPD(genero, nombre, ruta, fechac);
                this.icc.confirmar();
                javax.swing.JOptionPane.showMessageDialog(null,"Operación realizada");
                this.dispose();
            }
            break;
            case 1: {
                String nickname = this.campo1.getText();
                if(nickname.equals("")) 
                throw new Exception("No selecciono cliente");
                String nombre = this.txNombre.getText();
                if(nombre.equals("")) 
                    throw new Exception("Debe nombrar la lista de reproducción");
                nombre = this.ConvertirString(nombre);
                Calendar fecha = Calendar.getInstance();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH);
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                String fechac = año + "-" + (mes+1) + "-" + dia;
                this.icc.crearListaP(nickname, nombre, ruta, fechac);
                this.icc.confirmar();
                javax.swing.JOptionPane.showMessageDialog(null,"Operación realizada");
                this.dispose();
            }
            break;

        }} catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_ConfirmarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    String ConvertirString(String cad){
        cad = cad.toLowerCase();
        String[] palabras = cad.split("\\s+");
        cad = "";
        for (int i=0;i<palabras.length;i++){
            palabras[i].toLowerCase();
            palabras[i] = palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1);
            if (i==0)
                cad = cad + palabras[i];           
            else
                cad = cad + " " + palabras[i];
        }
        return cad;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser Buscar;
    private javax.swing.JButton CargarImg;
    private javax.swing.JButton Confirmar;
    private javax.swing.JLabel Img;
    private javax.swing.JLabel Info1;
    private javax.swing.JLabel Info2;
    private javax.swing.JLabel Nomb;
    private javax.swing.JTree arbol;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel campo1;
    private javax.swing.JLabel campo2;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> lista;
    private javax.swing.JScrollPane scArbol;
    private javax.swing.JScrollPane scLista;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
