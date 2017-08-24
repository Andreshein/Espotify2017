/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Fabrica;
import Logica.IcontArtista;
import Logica.IcontCliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ninoh
 */
public class Principal extends javax.swing.JFrame {

    private IcontCliente Cli; 
    private IcontArtista Art;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        Cli = Fabrica.getCliente();
        Art = Fabrica.getArtista();
        Fabrica.SetControladores();
        
        //levantar datos de la BD
        Cli.cargarDatosDeLaBD();
        
        // Es para que la ventana se centre
        this.setLocationRelativeTo(null);
        
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Fabrica  f = Fabrica.getInstance();
        //f.cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        ConsultarPerfilCliMenuItem = new javax.swing.JMenuItem();
        pubListMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        ConsultaAlbum = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        agregarTemaListaMenuItem = new javax.swing.JMenuItem();
        Datos = new javax.swing.JMenu();
        CargaDatos = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu6.setText("File");
        jMenuBar2.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar2.add(jMenu7);

        jMenu8.setText("File");
        jMenuBar3.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar3.add(jMenu9);

        jMenu10.setText("File");
        jMenuBar4.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar4.add(jMenu11);

        jMenu12.setText("File");
        jMenuBar5.add(jMenu12);

        jMenu13.setText("Edit");
        jMenuBar5.add(jMenu13);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(255, 255, 255));
        escritorio.setPreferredSize(new java.awt.Dimension(645, 421));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(445, 21));

        jMenu3.setText("Nuevo");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setText("Album");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Clientes");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        ConsultarPerfilCliMenuItem.setText("Consultar Perfil");
        ConsultarPerfilCliMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarPerfilCliMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(ConsultarPerfilCliMenuItem);

        pubListMenuItem.setText("Publicar Lista");
        pubListMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubListMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(pubListMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Artistas");

        jMenuItem2.setText("Consultar perfil del artista");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Álbum");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        ConsultaAlbum.setText("Consultar Álbum");
        ConsultaAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaAlbumActionPerformed(evt);
            }
        });
        jMenu5.add(ConsultaAlbum);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Listas");

        agregarTemaListaMenuItem.setText("Agregar Tema");
        agregarTemaListaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTemaListaMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(agregarTemaListaMenuItem);

        jMenuBar1.add(jMenu4);

        Datos.setText("Datos");

        CargaDatos.setText("Cargar Datos de Prueba");
        CargaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargaDatosActionPerformed(evt);
            }
        });
        Datos.add(CargaDatos);

        jMenuBar1.add(Datos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarPerfilCliMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarPerfilCliMenuItemActionPerformed
        // TODO add your handling code here:
        ConsultarPerfilCliente perfilCli = new ConsultarPerfilCliente();
        escritorio.add(perfilCli);
        perfilCli.centrar();
        perfilCli.show();
    }//GEN-LAST:event_ConsultarPerfilCliMenuItemActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AltaPerfil Ap = new AltaPerfil();
        escritorio.add(Ap);
        Ap.centrar();
        Ap.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ConsultarPerfilArtista perfArt = new ConsultarPerfilArtista();
        perfArt.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void agregarTemaListaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTemaListaMenuItemActionPerformed
        AgregarTemaaLista agregarTL = new AgregarTemaaLista();
        escritorio.add(agregarTL);
        agregarTL.centrar();
        agregarTL.show();
    }//GEN-LAST:event_agregarTemaListaMenuItemActionPerformed

    private void CargaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaDatosActionPerformed
        int x = javax.swing.JOptionPane.showConfirmDialog(null, "Esta a punto de cargar los datos de prueba del sistema. Confirmar?", "Carga de datos", 1);
        if (x==0){
               javax.swing.JOptionPane.showMessageDialog(null,"Carga de datos completada","Carga de datos",1);
               Cli.CargadeDatos();
        }
        if (x==1){
            javax.swing.JOptionPane.showMessageDialog(null,"Operación cancelada","Carga de datos",0);    
        }
    }//GEN-LAST:event_CargaDatosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        AltaAlbum ab = new AltaAlbum(escritorio);
        escritorio.add(ab);
        ab.setVisible(true);
        ab.centrar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void ConsultaAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaAlbumActionPerformed
        // TODO add your handling code here:
        ConsultaAlbum album = new ConsultaAlbum();
        escritorio.add(album);
        album.centrar();
        album.show();
    }//GEN-LAST:event_ConsultaAlbumActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void pubListMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubListMenuItemActionPerformed
        PublicarLista pubL = new PublicarLista();
        escritorio.add(pubL);
        pubL.centrar();
        pubL.show();
    }//GEN-LAST:event_pubListMenuItemActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            //</editor-fold>
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CargaDatos;
    private javax.swing.JMenuItem ConsultaAlbum;
    private javax.swing.JMenuItem ConsultarPerfilCliMenuItem;
    private javax.swing.JMenu Datos;
    private javax.swing.JMenuItem agregarTemaListaMenuItem;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem pubListMenuItem;
    // End of variables declaration//GEN-END:variables
}
