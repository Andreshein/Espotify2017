/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtAlbum;
import Logica.DtArtista;
import Logica.DtCliente;
import Logica.DtGenero;
import Logica.DtListaP;
import Logica.DtListaPD;
import Logica.DtTema;
import Logica.Fabrica;
import Logica.IcontArtista;
import Logica.IcontCliente;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stephiRM
 */
public class ConsultarListaReproduccion extends javax.swing.JInternalFrame {
    
    private IcontArtista artista;
    private IcontCliente cliente;
    /**
     * Creates new form ConsultarListaReproduccion
     */
    public ConsultarListaReproduccion() {
        initComponents();
        this.mostrarListaP();
        this.mostrarListaPD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboxBuscar = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTemas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        ListasPanel = new javax.swing.JPanel();
        ParticularesPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblParticular = new javax.swing.JTable();
        DefectoPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDefecto = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consultar Lista de reproducción");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Consultar por:");

        cboxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Género" }));
        cboxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Listas de reproducción:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Información de los temas:");

        tblTemas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblTemas);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Imagen:");

        Imagen.setBackground(new java.awt.Color(153, 153, 153));
        Imagen.setForeground(new java.awt.Color(153, 153, 153));
        Imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ListasPanel.setLayout(new java.awt.CardLayout());

        tblParticular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Nombre de la lista", "Es privado?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblParticular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblParticularMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblParticular);

        javax.swing.GroupLayout ParticularesPanelLayout = new javax.swing.GroupLayout(ParticularesPanel);
        ParticularesPanel.setLayout(ParticularesPanelLayout);
        ParticularesPanelLayout.setHorizontalGroup(
            ParticularesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParticularesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );
        ParticularesPanelLayout.setVerticalGroup(
            ParticularesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParticularesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        ListasPanel.add(ParticularesPanel, "ParticularesPanel");

        tblDefecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la lista", "Género"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDefecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDefectoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDefecto);

        javax.swing.GroupLayout DefectoPanelLayout = new javax.swing.GroupLayout(DefectoPanel);
        DefectoPanel.setLayout(DefectoPanelLayout);
        DefectoPanelLayout.setHorizontalGroup(
            DefectoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DefectoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        DefectoPanelLayout.setVerticalGroup(
            DefectoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DefectoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        ListasPanel.add(DefectoPanel, "DefectoPanel");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ListasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar))
                                    .addComponent(jLabel3))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(ListasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxBuscarActionPerformed
        mostrarListas((String) cboxBuscar.getSelectedItem());
        mostrarListaPD();
        mostrarListaP();
    }//GEN-LAST:event_cboxBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(cboxBuscar.getSelectedItem().equals("Cliente")){
            String nickname = txtBuscar.getText();
            DefaultTableModel modelo = (DefaultTableModel) tblParticular.getModel();
            ArrayList<DtCliente> cli = Fabrica.getCliente().BuscarClientes(nickname);
            if(cli.isEmpty()){
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Error al buscar", JOptionPane.ERROR_MESSAGE);
            }else{
                while(modelo.getRowCount()>0){
                    modelo.setRowCount(0);
                }
         
                for (int i=0;i<cli.size();i++) {
                    ArrayList<DtListaP> lista=cli.get(i).getListas();
 
                    for(int j=0;j<lista.size();j++){
                        DtListaP lp =(DtListaP) lista.get(j);
               
                        Object[] datos={
                            lp.getUsuario(),
                            lp.getNombre(),
                            lp.isPrivada()  
                        };
                
                        modelo.addRow(datos);
                    }
                }
            }
        }else if(cboxBuscar.getSelectedItem().equals("Género")){
            String nombreG=txtBuscar.getText();
            DefaultTableModel modelo=(DefaultTableModel) tblDefecto.getModel();
            ArrayList<DtGenero> gen=Fabrica.getArtista().listarGeneros(nombreG);
            while(modelo.getRowCount()>0){
                modelo.setRowCount(0);
            }
                
            for(int i=0;i<gen.size();i++){
                ArrayList<DtListaPD> listaPD=gen.get(i).getListaspordefecto();
                for(int j=0;j<listaPD.size();j++){
                    DtListaPD lpd=(DtListaPD) listaPD.get(j);
                    Object[] datos={lpd.getNombre(),lpd.getGenero()};
                    modelo.addRow(datos);
                }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblParticularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblParticularMouseClicked
        this.mostrarTemasListaP();
    }//GEN-LAST:event_tblParticularMouseClicked

    private void tblDefectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDefectoMouseClicked
        this.mostrarTemasListaPD();
    }//GEN-LAST:event_tblDefectoMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int confirmar=JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
        
        if(confirmar==JOptionPane.YES_OPTION){
            this.dispose();
        }     
    }//GEN-LAST:event_btnSalirActionPerformed
 
    public void mostrarListas(String tipo){
        CardLayout cl = (CardLayout)(ListasPanel.getLayout());
        
        switch(tipo){
            case "Género":
                cl.show(ListasPanel, "DefectoPanel");
                break;
            case "Cliente":
                cl.show(ListasPanel, "ParticularesPanel");
                break;
        }
    }
    
    public void mostrarListaP(){
        if(cboxBuscar.getSelectedItem().equals("Cliente")){
            List<DtListaP> lista= Fabrica.getCliente().ListarListaP();
            DefaultTableModel modelo=(DefaultTableModel) tblParticular.getModel();
        
            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
            }
           
            for(DtListaP lp: lista){
                //Imagen es opcional
                if(lp.getImagen() != null){
                Icon icono= new ImageIcon(lp.getImagen().getImage().getScaledInstance(Imagen.getWidth(),Imagen.getHeight(),Image.SCALE_DEFAULT));

                Imagen.setIcon(icono); // coloca la imagen en el label

                }else{
                    Imagen.setIcon(null); 
                }
                
                Object[] datos={lp.getUsuario(),lp.getNombre(),lp.isPrivada()};
                modelo.addRow(datos);
            }
        }
    }

    public void mostrarListaPD(){
        if(cboxBuscar.getSelectedItem().equals("Género")){
            List<DtListaPD> lista= Fabrica.getArtista().ListarListaPD();
            DefaultTableModel modelo=(DefaultTableModel) tblDefecto.getModel();
        
            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
            }
            
            for(DtListaPD lpd: lista){
                Object[] datos={lpd.getNombre(),lpd.getGenero()};
                modelo.addRow(datos);
            }
        }
    }
    
    public void mostrarTemasListaP(){
        if(cboxBuscar.getSelectedItem().equals("Cliente")){
            String nickname=(String) tblParticular.getValueAt(tblParticular.getSelectedRow(), 0);
            String listaP=(String) tblParticular.getValueAt(tblParticular.getSelectedRow(), 1);
            DefaultTableModel modelo = (DefaultTableModel) tblTemas.getModel();
            ArrayList<DtTema> temaLP=Fabrica.getCliente().listarTemasListaP(nickname, listaP);
            
            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
            }
            
            for(DtTema tema:temaLP){
                Object[] datos={tema.getNombre(),tema.getDuracion(),tema.getOrden(),tema.getDireccion(),tema.getArchivo()};
                modelo.addRow(datos);
            }
        }
    }
    
    public void mostrarTemasListaPD(){
        if(cboxBuscar.getSelectedItem().equals("Género")){
            String listaPD=(String) tblDefecto.getValueAt(tblDefecto.getSelectedRow(), 0);
            String nombreG=(String) tblDefecto.getValueAt(tblDefecto.getSelectedRow(), 1);
            DefaultTableModel modelo=(DefaultTableModel) tblTemas.getModel();
            ArrayList<DtTema> temaLPD=Fabrica.getArtista().listarTemasListaPD(listaPD, nombreG);
            
            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
            }
            
            for(DtTema tema:temaLPD){
                Object[] datos={tema.getNombre(),tema.getDuracion(),tema.getOrden(),tema.getDireccion(),tema.getArchivo()};
                modelo.addRow(datos);
            }
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
    private javax.swing.JPanel DefectoPanel;
    private javax.swing.JLabel Imagen;
    private javax.swing.JPanel ListasPanel;
    private javax.swing.JPanel ParticularesPanel;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboxBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblDefecto;
    private javax.swing.JTable tblParticular;
    private javax.swing.JTable tblTemas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}