/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.logica.Fachada;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import edu.ort.obligatorio.ui.VistaSimularLlamada;

/**
 *
 * @author Nadia
 */
public class ControladorVistaSimularLlamada implements Observador {
    
    VistaSimularLlamada vista;
    Fachada modelo;

    public ControladorVistaSimularLlamada(VistaSimularLlamada vista) {
        this.vista = vista;
        this.modelo = Fachada.getInstancia();
        this.modelo.agregarObservador(this);
  
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void finalizarLlamada() throws Exception {
        
        //modelo.finalizarLlamadaDelPuesto();
    }
    
    public boolean hayLlamadaEnCurso() {
        //retorno true para evitar error
        return true;
        //return modelo.hayLlamadaEnCurso();
    }

}
