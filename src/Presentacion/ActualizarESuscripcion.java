/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtCliente;
import Logica.DtSuscripcion;
import Logica.Fabrica;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Admin
 */
public class ActualizarESuscripcion extends javax.swing.JInternalFrame {

    private ArrayList<DtCliente> clientes;
    private ArrayList<DtSuscripcion> suscripciones;

    public ActualizarESuscripcion() {
        initComponents();
        this.limpiar();
    }

    public void centrar() {
        //este metodo devuelve el tamaÃ±o de la pantalla
        Dimension pantalla = this.getParent().getSize();
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

    void limpiar() {
        this.clientes = Fabrica.getCliente().BuscarClientes("");
        DefaultListModel modelo = new DefaultListModel();
        this.listSuscripcion.setModel(new DefaultListModel());
        if (!this.clientes.isEmpty()) {
            Iterator iterador = this.clientes.iterator();
            while (iterador.hasNext()) {
                DtCliente auxiliar = (DtCliente) iterador.next();
                modelo.addElement(auxiliar.getNickname());
            }
        }
        this.listCliente.setModel(modelo);
        this.lblEstado.setText("");
        this.lblTipo.setText("");
        this.lblFecha.setText("");
        this.lblNombre.setText("");
        this.lblNick.setText("");
        this.cmbEstado.setEnabled(false);
        this.btnCambiar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listSuscripcion = new javax.swing.JList<>();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNick = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        btnCambiar = new javax.swing.JButton();
        jlabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCliente = new javax.swing.JList<>();
        cmbEstado = new javax.swing.JComboBox<>();

        listSuscripcion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listSuscripcion.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSuscripcionValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listSuscripcion);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNick.setText("jLabel1");

        lblNombre.setText("jLabel1");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Estado:");

        jLabel5.setText("Fecha de creación:");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        btnCambiar.setText("Cambiar estado");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        jlabel1.setText("Nickname:");

        jLabel7.setText("Nombre:");

        lblTipo.setText("jLabel3");

        lblEstado.setText("jLabel4");

        lblFecha.setText("jLabel5");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Cambiar estado de suscripción");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Suscripcion");

        listCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCliente.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listClienteValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listCliente);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cancelada", "Vigente" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlabel1)
                                .addGap(24, 24, 24)
                                .addComponent(lblNick)))
                        .addGap(18, 96, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFecha))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipo)
                                    .addComponent(lblEstado)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCambiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(37, 37, 37))))
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblFecha))
                        .addGap(18, 18, 18)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCambiar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel1)
                                        .addComponent(lblNick))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(lblNombre)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(Salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!this.txtBuscar.getText().equals("")) {
            this.clientes = Fabrica.getCliente().BuscarClientes(this.txtBuscar.getText());
            DefaultListModel modelo = new DefaultListModel();
            if (!this.clientes.isEmpty()) {
                Iterator iterador = this.clientes.iterator();
                while (iterador.hasNext()) {
                    DtCliente auxiliar = (DtCliente) iterador.next();
                    modelo.addElement(auxiliar.getNickname());
                }
            }
            this.listCliente.setModel(modelo);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void listClienteValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listClienteValueChanged
        int index = this.listCliente.getSelectedIndex();
        if (index != -1) {
            DtCliente dtc = (DtCliente) this.clientes.get(index);
            this.lblNick.setText(dtc.getNickname());
            this.lblNombre.setText(dtc.getNombre() + " " + dtc.getApellido());
            this.suscripciones = Fabrica.getCliente().getSuscripCliente(dtc.getNickname());
            DefaultListModel modelo = new DefaultListModel();
            for (DtSuscripcion s : this.suscripciones) {
                modelo.addElement(s.getTipo() + "(" + s.getEstado() + ")");
            }
            this.listSuscripcion.setModel(modelo);
        }

    }//GEN-LAST:event_listClienteValueChanged

    private void listSuscripcionValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSuscripcionValueChanged
        int index = this.listSuscripcion.getSelectedIndex();
        if (index != -1) {
            DtSuscripcion dt = (DtSuscripcion) this.suscripciones.get(index);
            this.lblTipo.setText(dt.getTipo());
            this.lblEstado.setText(dt.getEstado());
            this.lblFecha.setText(dt.getFecha());
            this.btnCambiar.setEnabled(dt.getEstado().equals("Pendiente"));
            this.cmbEstado.setEnabled(dt.getEstado().equals("Pendiente"));
        }
    }//GEN-LAST:event_listSuscripcionValueChanged

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        int index = this.listSuscripcion.getSelectedIndex();
        if (index != -1) {
            try {
                DtSuscripcion aux = (DtSuscripcion) this.suscripciones.get(index);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                DtSuscripcion dt = new DtSuscripcion(aux.getId(), aux.getCliente(), formato.parse(aux.getFecha()), (String) this.cmbEstado.getSelectedItem(), aux.getTipo(), aux.getMonto());
                Fabrica.getCliente().CambiarEstadoSuscripcion(dt);
                index = this.listCliente.getSelectedIndex();
                if (index != -1) {
                    DtCliente dtc = (DtCliente) this.clientes.get(index);
                    this.suscripciones = Fabrica.getCliente().getSuscripCliente(dtc.getNickname());
                    DefaultListModel modelo = new DefaultListModel();
                    for (DtSuscripcion s : this.suscripciones) {
                        modelo.addElement(s.getTipo() + "(" + s.getEstado() + ")");
                    }
                    this.listSuscripcion.setModel(modelo);
                }

                this.lblEstado.setText("");
                this.lblTipo.setText("");
                this.lblFecha.setText("");
                this.cmbEstado.setEnabled(false);
                this.btnCambiar.setEnabled(false);
                javax.swing.JOptionPane.showMessageDialog(null, "Operación exitosa");
            } catch (ParseException ex) {
                Logger.getLogger(ActualizarESuscripcion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCambiarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCambiar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNick;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JList<String> listCliente;
    private javax.swing.JList<String> listSuscripcion;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
