package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.dominio.Puesto;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
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
            vista.estadoLlamadaEsperandoLlamada();
            vista.cantidadLlamadasAtendidas(modelo.cantidadLlamadasAtendidas());
            vista.tiempoPromedioLlamadas(modelo.tiempoPromedioLlamadas());
            vista.mostrarDatosDeLaLLamadaFinalizada(modelo.duracionDeLlamada(), modelo.costoLlamada());
        }
    }
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

    public void nuevoTrabajadorEnPuestoAviso() {
        modelo.nuevoTrabajadorEnPuestoAviso();
    }
    
    public void puestoConTrabajadorDisponibleAviso() {
        modelo.puestoConTrabajadorDisponibleAviso();
    }
    
    public void trabajadorLiberaElPuesto() throws Exception {
        modelo.trabajadorLiberaElPuesto();
        modelo.eliminarObservador(this);
        modelo.eliminarObservador(modelo.getSector());
    }
    
    public boolean hayLlamadaEnCurso() {
        return modelo.hayLlamadaEnCurso();
    }
}
