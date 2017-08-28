/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtAlbum;
import Logica.DtCliente;
import Logica.DtLista;
import Logica.DtListaP;
import Logica.DtListaPD;
import Logica.DtTema;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IcontCliente;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class ConsultarPerfilCliente extends javax.swing.JInternalFrame {

    IcontCliente contClientes;
    
    ArrayList<DtListaP> listasCreadas = new ArrayList<>();
    ArrayList<DtTema> temasFavCli = new ArrayList<>();
    ArrayList<DtAlbum> albumesFavCli = new ArrayList<>();
    ArrayList<DtLista> listasFavCli = new ArrayList<>();
    ArrayList<DtUsuario> usuariosSeguidos = new ArrayList<>();
    ArrayList<DtCliente> seguidores = new ArrayList<>();
    /**
     * Creates new form ConsultarPerfilCliente
     */
    public ConsultarPerfilCliente() {
        initComponents();
        
        Fabrica f = Fabrica.getInstance();
        this.contClientes=f.getCliente();
        
        //lista todos
        listarClientes("");
        
        //Por defecto mostrar esas tablas al principio
        mostrarFavoritos("Temas");
        mostrarUsuarios("Siguiendo");
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
        jScrollPane2 = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        listasCreadasTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        favoritosComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        usuariosComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        favoritosPanel = new javax.swing.JPanel();
        albumesPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        albumesTable = new javax.swing.JTable();
        listasFavPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listasFavTable = new javax.swing.JTable();
        temasPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        temasTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        usuariosPanel = new javax.swing.JPanel();
        usuariosSeguidosPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        usuariosSeguidosTable = new javax.swing.JTable();
        seguidoresPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        seguidoresTable = new javax.swing.JTable();
        buscarCliTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        imagenLabel = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Perfil Del Cliente");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Buscar Cliente:");

        clientesTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        clientesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Fecha de nacimiento", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientesTable.setGridColor(new java.awt.Color(204, 204, 204));
        clientesTable.setShowVerticalLines(false);
        clientesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesTableMouseClicked(evt);
            }
        });
        clientesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clientesTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(clientesTable);

        listasCreadasTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        listasCreadasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listasCreadasTable.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(listasCreadasTable);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Favoritos:");

        favoritosComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        favoritosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Temas", "Álbumes", "Listas" }));
        favoritosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoritosComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Usuarios:");

        usuariosComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        usuariosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Siguiendo", "Seguidores" }));
        usuariosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Listas Creadas:");

        favoritosPanel.setLayout(new java.awt.CardLayout());

        albumesTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        albumesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artista", "Nombre", "Año"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(albumesTable);

        javax.swing.GroupLayout albumesPanelLayout = new javax.swing.GroupLayout(albumesPanel);
        albumesPanel.setLayout(albumesPanelLayout);
        albumesPanelLayout.setHorizontalGroup(
            albumesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(albumesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, albumesPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        albumesPanelLayout.setVerticalGroup(
            albumesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
            .addGroup(albumesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(albumesPanelLayout.createSequentialGroup()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );

        favoritosPanel.add(albumesPanel, "albumesPanel");

        listasFavTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        listasFavTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Creador/Género"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(listasFavTable);

        javax.swing.GroupLayout listasFavPanelLayout = new javax.swing.GroupLayout(listasFavPanel);
        listasFavPanel.setLayout(listasFavPanelLayout);
        listasFavPanelLayout.setHorizontalGroup(
            listasFavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
            .addGroup(listasFavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listasFavPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(117, 117, 117)))
        );
        listasFavPanelLayout.setVerticalGroup(
            listasFavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
            .addGroup(listasFavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listasFavPanelLayout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );

        favoritosPanel.add(listasFavPanel, "listasPanel");

        temasTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        temasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artista", "Album", "Nombre", "Orden", "Duración"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        temasTable.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane3.setViewportView(temasTable);

        javax.swing.GroupLayout temasPanelLayout = new javax.swing.GroupLayout(temasPanel);
        temasPanel.setLayout(temasPanelLayout);
        temasPanelLayout.setHorizontalGroup(
            temasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(temasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, temasPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        temasPanelLayout.setVerticalGroup(
            temasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
            .addGroup(temasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(temasPanelLayout.createSequentialGroup()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );

        favoritosPanel.add(temasPanel, "temasPanel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(favoritosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(favoritosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        usuariosPanel.setLayout(new java.awt.CardLayout());

        usuariosSeguidosTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        usuariosSeguidosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usuariosSeguidosTable.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane7.setViewportView(usuariosSeguidosTable);

        javax.swing.GroupLayout usuariosSeguidosPanelLayout = new javax.swing.GroupLayout(usuariosSeguidosPanel);
        usuariosSeguidosPanel.setLayout(usuariosSeguidosPanelLayout);
        usuariosSeguidosPanelLayout.setHorizontalGroup(
            usuariosSeguidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
            .addGroup(usuariosSeguidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usuariosSeguidosPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        usuariosSeguidosPanelLayout.setVerticalGroup(
            usuariosSeguidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
            .addGroup(usuariosSeguidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(usuariosSeguidosPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        usuariosPanel.add(usuariosSeguidosPanel, "siguiendoPanel");

        seguidoresTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        seguidoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(seguidoresTable);

        javax.swing.GroupLayout seguidoresPanelLayout = new javax.swing.GroupLayout(seguidoresPanel);
        seguidoresPanel.setLayout(seguidoresPanelLayout);
        seguidoresPanelLayout.setHorizontalGroup(
            seguidoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
            .addGroup(seguidoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(seguidoresPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        seguidoresPanelLayout.setVerticalGroup(
            seguidoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
            .addGroup(seguidoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(seguidoresPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        usuariosPanel.add(seguidoresPanel, "seguidoresPanel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(usuariosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(usuariosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        buscarCliTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarCliTextFieldKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Imagen:");

        imagenLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarCliTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(imagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(usuariosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(favoritosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(favoritosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usuariosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 73, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(buscarCliTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTableMouseClicked
        getDatosCliente();
    }//GEN-LAST:event_clientesTableMouseClicked

    private void favoritosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoritosComboBoxActionPerformed
        // TODO add your handling code here:
        mostrarFavoritos( (String) favoritosComboBox.getSelectedItem() );
    }//GEN-LAST:event_favoritosComboBoxActionPerformed

    private void usuariosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosComboBoxActionPerformed
        // TODO add your handling code here:
        mostrarUsuarios( (String) usuariosComboBox.getSelectedItem() );
    }//GEN-LAST:event_usuariosComboBoxActionPerformed

    private void clientesTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientesTableKeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_DOWN || evt.getKeyCode()== KeyEvent.VK_UP){
            getDatosCliente();
        }
    }//GEN-LAST:event_clientesTableKeyReleased

    private void buscarCliTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarCliTextFieldKeyReleased
        listarClientes(buscarCliTextField.getText());
    }//GEN-LAST:event_buscarCliTextFieldKeyReleased

    // Funciones
    public void getDatosCliente(){
        String nickname = (String) clientesTable.getValueAt(clientesTable.getSelectedRow(), 0);
        DtCliente cliente = contClientes.verPerfilCliente(nickname);

        //Imagen
//        ImageIcon imagen = new ImageIcon(Rutaimagen); //genera la imagen que seleccionamos
//        Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(),foto.getHeight(),Image.SCALE_DEFAULT));
//
//        imagenLabel.setIcon(icono); // coloca la imagen en el label
//        
//        this.pack();
        
        // limpiar las variables arraylist
        listasCreadas.clear();
        temasFavCli.clear();
        albumesFavCli.clear();
        listasFavCli.clear();
        seguidores.clear();
        usuariosSeguidos.clear();

        //guardar los datos el cliente para poder mostrarlos o ocultarlos en la interfaz
        listasCreadas = cliente.getListas();
        temasFavCli = cliente.getFavTemas();
        albumesFavCli = cliente.getFavAlbumes();
        listasFavCli = cliente.getFavListas();
        seguidores = contClientes.getSeguidores(nickname);
        usuariosSeguidos = cliente.getUsuariosSeguidos();

        listarListasCreadas();
        listarTemas(); 
        listarUsuariosSeguidos();
        listarSeguidores();
        listarAlbumes();        
        listarListasFavoritas();
        listarListasCreadas();
        listarUsuariosSeguidos();
    }

    public void mostrarFavoritos(String tipo){
        CardLayout cl = (CardLayout)(favoritosPanel.getLayout());
        
        switch(tipo){
            case "Temas":
                cl.show(favoritosPanel, "temasPanel");
                break;
            case "Álbumes":
                cl.show(favoritosPanel, "albumesPanel");
                break;
            case "Listas":
                cl.show(favoritosPanel, "listasPanel");
                break;
        }
    }
    
    public void mostrarUsuarios(String tipo){
        CardLayout cl = (CardLayout)(usuariosPanel.getLayout());
        
        switch(tipo){
            case "Siguiendo":
                cl.show(usuariosPanel, "siguiendoPanel");
                break;
            case "Seguidores":
                cl.show(usuariosPanel, "seguidoresPanel");
                break;
        }
    }
    
    public void listarClientes(String palabra){
        DefaultTableModel modelo = (DefaultTableModel) clientesTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla
         
        ArrayList<DtCliente> clientes = contClientes.BuscarClientes(palabra);
        
        for (DtCliente cliente : clientes) {
            String[] datos = {cliente.getNickname(), cliente.getNombre(), cliente.getApellido(), cliente.getFechaNac(), cliente.getCorreo()}; 
            modelo.addRow(datos);
        }
    }
    
    public void listarListasCreadas(){
        DefaultTableModel modelo = (DefaultTableModel) listasCreadasTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla
        
        for (DtListaP lista : listasCreadas) {
            String tipo = "Pública";
            if(lista.isPrivada()){
                tipo = "Privada";
            }
            String[] datos ={lista.getNombre(), tipo};
            modelo.addRow(datos);
        }
    }
    
    public void listarTemas(){
        DefaultTableModel modelo = (DefaultTableModel) temasTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla
        if(temasFavCli != null){
            for (DtTema tema : temasFavCli) {
                String[] datos ={"nomArtista", "nomAlbum", tema.getNombre(), String.valueOf(tema.getOrden()), tema.getDuracion()};
                modelo.addRow(datos);
            }
        }
    }
    
    
    public void listarAlbumes(){
        DefaultTableModel modelo = (DefaultTableModel) albumesTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla
        if(albumesFavCli != null){
            for (DtAlbum album : albumesFavCli) {
                String[] datos ={album.getNombreArtista(), album.getNombre(), String.valueOf(album.getAnio())};
                modelo.addRow(datos);
            }
        }
    }
    
    public void listarListasFavoritas(){
        DefaultTableModel modelo = (DefaultTableModel) listasFavTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla
        if(listasFavCli != null){
            for (DtLista lista : listasFavCli) {
                String tipo;
                String creadorOgenero;
                if(lista instanceof DtListaPD){
                    tipo = "Por defecto";
                    creadorOgenero = ((DtListaPD) lista).getGenero();
                }else{
                    tipo = "Particular";
                    creadorOgenero = ((DtListaP) lista).getUsuario();
                }
                String[] datos ={lista.getNombre(), tipo, creadorOgenero};
                modelo.addRow(datos);
            }
        }
    }
    
    public void listarUsuariosSeguidos(){
        DefaultTableModel modelo = (DefaultTableModel) usuariosSeguidosTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla
        if(usuariosSeguidos != null){
            for (DtUsuario usuario : usuariosSeguidos) {
                String tipo;
                if(usuario instanceof DtCliente){
                    tipo = "Cliente";
                }else{
                    tipo = "Artista";
                }
                String[] datos ={usuario.getNickname(), usuario.getNombre(), usuario.getApellido(), tipo};
                modelo.addRow(datos);
            }
        }
    }
    
    public void listarSeguidores(){
        DefaultTableModel modelo = (DefaultTableModel) seguidoresTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla
        if(seguidores != null){
            for (DtCliente seguidor : seguidores) {
                String[] datos ={seguidor.getNickname(), seguidor.getNombre(), seguidor.getApellido()};
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
    private javax.swing.JPanel albumesPanel;
    private javax.swing.JTable albumesTable;
    private javax.swing.JTextField buscarCliTextField;
    private javax.swing.JTable clientesTable;
    private javax.swing.JComboBox<String> favoritosComboBox;
    private javax.swing.JPanel favoritosPanel;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable listasCreadasTable;
    private javax.swing.JPanel listasFavPanel;
    private javax.swing.JTable listasFavTable;
    private javax.swing.JPanel seguidoresPanel;
    private javax.swing.JTable seguidoresTable;
    private javax.swing.JPanel temasPanel;
    private javax.swing.JTable temasTable;
    private javax.swing.JComboBox<String> usuariosComboBox;
    private javax.swing.JPanel usuariosPanel;
    private javax.swing.JPanel usuariosSeguidosPanel;
    private javax.swing.JTable usuariosSeguidosTable;
    // End of variables declaration//GEN-END:variables
}
