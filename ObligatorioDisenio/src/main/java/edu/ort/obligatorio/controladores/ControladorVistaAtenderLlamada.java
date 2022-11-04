package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.dominio.Puesto;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import edu.ort.obligatorio.ui.VistaAtenderLlamada;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leand
 */
public class ControladorVistaAtenderLlamada implements Observador {
    
    Puesto modelo;
    VistaAtenderLlamada vista;   

    public ControladorVistaAtenderLlamada(VistaAtenderLlamada vista, Puesto modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.modelo.agregarObservador(this);
        this.modelo.agregarObservador(modelo.getSector());
    }

    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(Observador.Eventos.LLAMADA_EN_CURSO)) {           
            vista.nombreCliente(modelo.getLlamadaEnCurso().getNombreDelCliente());
            vista.estadoLlamadaEnCurso();          
        }
        if(evento.equals(Observador.Eventos.LLAMADA_FINALIZADA)) {
            vista.reset();
            vista.estadoLlamadaFinalizada();
            
            // TO DO: ver con el profe
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ControladorVistaAtenderLlamada.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
            vista.cantidadLlamadasAtendidas(modelo.cantidadLlamadasAtendidas());
            vista.tiempoPromedioLlamadas(modelo.tiempoPromedioLlamadas());
            
        }
    }

//    public String nombreSector() {
//       return modelo.getTrabajador().getNombreDelSector();
//    }
//
//    public int numeroPuesto() {
//        return modelo.getNumeroPuesto();
//    }
//
//    public int cantidadLlamadasAtendidas() {
//        return modelo.cantidadLlamadasAtendidas();
//    }
//
//    public float tiempoPromedioLlamadas() {
//        return modelo.tiempoPromedioLlamadas();
//    }
//
//    public String nombreTrabajador() {
//        return modelo.getTrabajador().getNombreCompleto();
//    }
//
//    public String nombreCliente() {
//        return modelo.getLlamadaEnCurso().getNombreDelCliente();
//    }
    
    public void inicializar() {
        vista.nombreTrabajador(modelo.getNombreDelTrabajador());
        vista.nombreSector(modelo.getNombreDelSector());
        vista.numeroPuesto(modelo.getNumeroPuesto());
        vista.cantidadLlamadasAtendidas(modelo.cantidadLlamadasAtendidas());
        vista.tiempoPromedioLlamadas(modelo.tiempoPromedioLlamadas());
        vista.estadoLlamadaEsperandoLlamada();
        
    }

    public void finalizarLlamada() throws Exception {
        modelo.finalizarLlamadaDelPuesto();
    }

    public void setearDescirpcionDeLlamada(String descripcionDeLLamada) {
        modelo.setearDescripcionDeLlamada(descripcionDeLLamada);
    }
    
}
