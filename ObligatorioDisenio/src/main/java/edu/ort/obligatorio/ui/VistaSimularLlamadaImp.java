/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.ui;

import edu.ort.obligatorio.controladores.ControladorVistaSimularLlamada;
import edu.ort.obligatorio.dominio.Llamada;
import edu.ort.obligatorio.dominio.Sector;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadia
 */
public class VistaSimularLlamadaImp extends javax.swing.JDialog implements VistaSimularLlamada{
    private String ci = "";
    private String sector = "";
    private EstadoVistaSimularLlamada estado;
    private String mensajeDeConsola = "";
    ControladorVistaSimularLlamada controlador;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
    /**
     * Creates new form DialogoSimularLlamada
     */
    public VistaSimularLlamadaImp(){
        initComponents();
        setTitle("Simulador de llamadas");
        this.controlador = new ControladorVistaSimularLlamada(this);
        this.estado = new EsperandoInicioLlamada();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        lMensaje = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnAsterisco = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnNumeral = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        jScrollPane1.setViewportView(txtMensaje);

        lMensaje.setText("Mensaje");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btnAsterisco.setText("*");
        btnAsterisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsteriscoActionPerformed(evt);
            }
        });

        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnNumeral.setText("#");
        btnNumeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumeralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn3)
                                .addGap(190, 190, 190))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAsterisco)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn0)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn9)
                                    .addComponent(btn6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNumeral)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSalir))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnIniciar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lMensaje)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnFinalizar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lMensaje)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1)
                    .addComponent(btn2)
                    .addComponent(btn3))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4)
                    .addComponent(btn5)
                    .addComponent(btn6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn9)
                    .addComponent(btn8)
                    .addComponent(btn7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNumeral)
                    .addComponent(btn0)
                    .addComponent(btnAsterisco)
                    .addComponent(btnSalir))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.cerrarVista();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.cerrarVista();
    }//GEN-LAST:event_formWindowClosing

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        try {
            // TODO add your handling code here:
            inicioLlamada();
        } catch (Exception ex) {
            Logger.getLogger(VistaSimularLlamadaImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btnNumeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumeralActionPerformed
        // TODO add your handling code here:
        armarSeleccion("#");
    }//GEN-LAST:event_btnNumeralActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("5");

    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnAsteriscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsteriscoActionPerformed
        // TODO add your handling code here:
        armarSeleccion("*");
    }//GEN-LAST:event_btnAsteriscoActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
        armarSeleccion("0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        finalizarLlamada();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAsterisco;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnNumeral;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lMensaje;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration//GEN-END:variables

    @Override
    public void reset() {
        btnIniciar.setEnabled(true);
        txtMensaje.setText("");
        this.ci = "";
        this.mensajeDeConsola = "";
        this.sector = "";
        this.estado = new EsperandoInicioLlamada();
    }

    @Override
    public void cerrarVista() {
//         if (controlador.hayLlamadaEnCurso()) {
//            int opt = JOptionPane.showConfirmDialog(this, "¿Desea Finalizar la llamada en curso y salir de la aplicación?", "Salir de la Aplicación", JOptionPane.OK_CANCEL_OPTION);
//            if (opt == JOptionPane.OK_OPTION) {
//                try {
//                    controlador.finalizarLlamada();
//                } catch (Exception ex1) {
//                    mostrarMensajeDeError(ex1.getMessage());
//                }
//                this.dispose();
//            } 
//        } else {
//            try {
//                this.dispose();
//            } catch (Exception ex) {
//                mostrarMensajeDeError(ex.getMessage());
//            }
//        }
    }

    @Override
    public void setEstado(EstadoVistaSimularLlamada estado) {
        this.estado = estado;
    }
    
    private void armarSeleccion(String seleccion) {
        if(this.estado.esperandoCI()) {
            if(seleccion.equalsIgnoreCase("#")) {
                if (controlador.agregarClienteALlamada(ci)) {
                    try {
                        this.estado.esperandoSector(this);
                    } catch (Exception ex) {
                        Logger.getLogger(VistaSimularLlamadaImp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    mostrarSectores(controlador.getListaSectores());
                }
            } else {
                this.ci += seleccion;
                this.mostrarMensajePorConsola(this.mensajeDeConsola +"\nCI:"+ this.ci);
            }
        } else if(this.estado.esperandoSector()) {
            this.sector += seleccion;
            if (controlador.agregarSectorALlamada(this.sector)) {
                controlador.iniciarLlamada();
            }
        }
    }
    
    private void inicioLlamada() throws Exception {
        this.btnIniciar.setEnabled(false);
        this.txtMensaje.setText("");
        this.estado.esperandoCI(this);
        this.mensajeDeConsola = "Ingrese su cédula seguida de la tecla numeral";
        this.mostrarMensajePorConsola(this.mensajeDeConsola);
        controlador.crearNuevaLlamada();
    }
    
    @Override
    public void mostrarMensajePorConsola(String mensaje) {
        this.txtMensaje.setText(mensaje);
    }

    @Override
    public void mostrarSectores(HashMap<Integer, Sector> sectores) {
        String cadenaSectores = "Para comunicarse con: \n";
        for(Sector s: sectores.values()) {
            cadenaSectores += s.getNombre() + " digite " + s.getNumeroSector() + " , ";
        }
        cadenaSectores = cadenaSectores.substring(0, cadenaSectores.length()-2);
        this.mensajeDeConsola = cadenaSectores + ".";
        this.mostrarMensajePorConsola(mensajeDeConsola);
    }

    private void finalizarLlamada() {
        controlador.finalizarLlamada();
    }
    
    @Override 
    public void mostrarInformacionDeLlamadaAtendida(Llamada l) {
        String mensaje = "Llamada en curso… ud. se está comunicando con el sector: " + l.getNombreSector() + 
                "\nY está siendo atendido por " + l.getNombreDelTrabajador() +
                "\nSu llamada se ha iniciado en " + l.getFechaHoraInicioAtencion().format(formatter);
        this.mostrarMensajePorConsola(mensaje);
    }
    
    @Override 
    public void mostrarInformacionDeLlamadaFinalizada(Llamada l) {
        String mensaje = "Llamada finalizada... Duración: " + l.duracionLlamada() + " segundos " +
                "\nCosto: " + l.getCostoLlamada() + ". Su saldo es de: " + l.getSaldoDelCliente();
        this.mostrarMensajePorConsola(mensaje);
    }
    
}
