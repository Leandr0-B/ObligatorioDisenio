package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.dominio.Puesto;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import edu.ort.obligatorio.ui.VistaAtenderLlamada;
import edu.ort.obligatorio.ui.VistaAtenderLlamadaInterfaz;
import edu.ort.obligatorio.ui.VistaLoginInterfaz;

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
    VistaAtenderLlamadaInterfaz vista;   

    public ControladorVistaAtenderLlamada(VistaAtenderLlamadaInterfaz vista, Puesto modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.modelo.agregarObservador(this);
    }

    
    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String nombreSector() {
       return modelo.getTrabajador().getNombreDelSector();
    }

    public int numeroPuesto() {
        return modelo.getNumeroPuesto();
    }

    public int cantidadLlamadasAtendidas() {
        return modelo.cantidadLlamadasAtendidas();
    }

    public float tiempoPromedioLlamadas() {
        return modelo.tiempoPromedioLlamadas();
    }

    public String nombreTrabajador() {
        return modelo.getTrabajador().getNombreCompleto();
    }

    public String nombreCliente() {
        return modelo.getLlamadaEnCurso().getNombreDelCliente();
    }
    
}
