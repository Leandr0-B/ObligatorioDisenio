/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.dominio.Puesto;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import edu.ort.obligatorio.ui.VistaSimularLlamada;

/**
 *
 * @author Nadia
 */
public class ControladorVistaSimularLlamada implements Observador {
    
    VistaSimularLlamada vista;
    Puesto modelo;

    public ControladorVistaSimularLlamada(VistaSimularLlamada vista, Puesto modelo) {
        this.vista = vista;
        this.modelo.agregarObservador(this);
        this.modelo.agregarObservador(modelo.getSector());
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void finalizarLlamada() throws Exception {
        modelo.finalizarLlamadaDelPuesto();
    }
    
    public boolean hayLlamadaEnCurso() {
        return modelo.hayLlamadaEnCurso();
    }
}
