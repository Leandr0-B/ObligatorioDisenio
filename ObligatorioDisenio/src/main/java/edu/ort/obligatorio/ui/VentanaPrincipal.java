/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.ui;

import edu.ort.obligatorio.logica.Fachada;
import edu.ort.obligatorio.logica.ServicioTrabajador;
import edu.ort.obligatorio.utilidades.DatosDePrueba;



/**
 *
 * @author Nadia
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        System.out.println("componentes");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mLogin = new javax.swing.JMenuItem();
        mSimularLlamada = new javax.swing.JMenuItem();
        mMonitoreo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jMenu1.setText("Menú");

        mLogin.setText("Login");
        mLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginActionPerformed(evt);
            }
        });
        jMenu1.add(mLogin);

        mSimularLlamada.setText("Simular Llamada");
        mSimularLlamada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSimularLlamadaActionPerformed(evt);
            }
        });
        jMenu1.add(mSimularLlamada);

        mMonitoreo.setText("Monitoreo");
        mMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mMonitoreoActionPerformed(evt);
            }
        });
        jMenu1.add(mMonitoreo);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginActionPerformed
        // TODO add your handling code here:
        // TODO: el Servicio de Trabajo no puede ser el modelo, deberia ser la fachada
        // esperar a la clase del Lunes 7/11 
        ServicioTrabajador modelo = Fachada.getInstancia().getServicioTrabajador();
        VistaLoginImp login = new VistaLoginImp(modelo);
        login.setVisible(true);        
    }//GEN-LAST:event_mLoginActionPerformed

    private void mSimularLlamadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSimularLlamadaActionPerformed
        // TODO add your handling code here:
        DialogoSimularLlamadaImp simular = new DialogoSimularLlamadaImp(this,true);
        simular.setVisible(true);
    }//GEN-LAST:event_mSimularLlamadaActionPerformed

    private void mMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMonitoreoActionPerformed
        // TODO add your handling code here:
        DialogoAplicacionDeMonitoreoImp monitoreo = new DialogoAplicacionDeMonitoreoImp(this,true);
        monitoreo.setVisible(true);
    }//GEN-LAST:event_mMonitoreoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here: 
    }//GEN-LAST:event_formWindowOpened

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DatosDePrueba.cargar();
                new VentanaPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mLogin;
    private javax.swing.JMenuItem mMonitoreo;
    private javax.swing.JMenuItem mSimularLlamada;
    // End of variables declaration//GEN-END:variables
}
