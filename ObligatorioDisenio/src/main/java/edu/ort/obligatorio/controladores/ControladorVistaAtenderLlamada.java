package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.dominio.Llamada;
import edu.ort.obligatorio.dominio.Puesto;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import edu.ort.obligatorio.ui.VistaAtenderLlamadaImp;
import edu.ort.obligatorio.ui.VistaLogin;
import edu.ort.obligatorio.ui.VistaAtenderLlamada;

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
    }

    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(Observador.Eventos.LLAMADA_EN_CURSO)) {
            // TO DO
            vista.nombreCliente(modelo.getLlamadaEnCurso().getNombreDelCliente());
            vista.estadoLlamada("En Curso");
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
        
    }
    
}
