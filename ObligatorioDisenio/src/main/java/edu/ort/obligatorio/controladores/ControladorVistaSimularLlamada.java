/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.dominio.Cliente;
import edu.ort.obligatorio.dominio.Exceptions.CantidadMaximaDeLlamadasException;
import edu.ort.obligatorio.dominio.Exceptions.ClienteNoRegistradoException;
import edu.ort.obligatorio.dominio.Exceptions.SectorNoDisponibleException;
import edu.ort.obligatorio.dominio.Exceptions.SectorNoValidoException;
import edu.ort.obligatorio.dominio.Llamada;
import edu.ort.obligatorio.dominio.Sector;
import edu.ort.obligatorio.logica.Fachada;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import edu.ort.obligatorio.ui.VistaSimularLlamada;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void finalizarLlamada() throws Exception {
        
        //modelo.finalizarLlamadaDelPuesto();
    }
    
    public boolean hayLlamadaEnCurso() {
        //retorno true para evitar error
        return true;
        //return modelo.hayLlamadaEnCurso();
    }
    
    public Cliente buscarCliente(String ci) {
        Cliente cliente = null;
        try {
            cliente = modelo.buscarCliente(ci);
        } catch (ClienteNoRegistradoException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
            vista.reset();
        }
        return cliente;
    }
    
    public HashMap<Integer, Sector> getListaSectores() {
        return modelo.getListaSectores();
    }
    
    public Sector getSector(String sector){
        int sectorInt = Integer.parseInt(sector);
        Sector s = null;
        try {
            s = modelo.getSector(sectorInt);
        } catch (SectorNoValidoException ex) {
           vista.mostrarMensajeDeError(ex.getMessage());
           vista.reset();
        }
        return s;
    }

    public void iniciarLlamada(Llamada l) {
        try {
            modelo.iniciarLlamada(l);
        } catch (CantidadMaximaDeLlamadasException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
            vista.reset();
        } catch (SectorNoDisponibleException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
            vista.reset();
        } catch (Exception ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
            vista.reset();
        }
    }

}
