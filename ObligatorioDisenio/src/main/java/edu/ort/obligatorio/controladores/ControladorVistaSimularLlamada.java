/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.dominio.Cliente;
import edu.ort.obligatorio.dominio.Exceptions.CantidadMaximaDeLlamadasException;
import edu.ort.obligatorio.dominio.Exceptions.ClienteNoRegistradoException;
import edu.ort.obligatorio.dominio.Exceptions.LlamadaEnEsperaException;
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
    Fachada fachada;
    Llamada modelo;

    public ControladorVistaSimularLlamada(VistaSimularLlamada vista) {
        this.vista = vista;
        this.fachada = Fachada.getInstancia();
        
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(Observador.Eventos.LLAMADA_EN_CURSO)) {           
            vista.mostrarInformacionDeLlamadaAtendida(this.modelo);
        }
        if(evento.equals(Observador.Eventos.LLAMADA_FINALIZADA)) {
            vista.reset();
            vista.mostrarInformacionDeLlamadaFinalizada(this.modelo);
        }
    }
    
    
    public void finalizarLlamada() {
        try {
            fachada.finalizarLlamada(this.modelo);
            //modelo.finalizarLlamadaDelPuesto();
        } catch (Exception ex) {
            Logger.getLogger(ControladorVistaSimularLlamada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean hayLlamadaEnCurso() {
        //retorno true para evitar error
        return true;
        //return modelo.hayLlamadaEnCurso();
    }   
    public HashMap<Integer, Sector> getListaSectores() {
        return fachada.getListaSectores();
    }
    
    public void iniciarLlamada() {
        try {
            fachada.iniciarLlamada(this.modelo);
        } catch (CantidadMaximaDeLlamadasException ex) {
            vista.reset();
            vista.mostrarMensajePorConsola(ex.getMessage());
        } catch (SectorNoDisponibleException ex) {
            vista.reset();
            vista.mostrarMensajePorConsola(ex.getMessage());
        } catch (SectorNoValidoException ex) {
            vista.reset();
            vista.mostrarMensajePorConsola(ex.getMessage());
        } catch (LlamadaEnEsperaException ex) {
            vista.mostrarMensajePorConsola(ex.getMessage());
        } catch (Exception ex) {
            // esta exception captura cuando se cambia de un tipo de llamada 
            // al mismo tipo, eso no deberia ocurrir
            vista.mostrarMensajePorConsola(ex.getMessage());
        }
    }
    
    public boolean crearNuevaLlamada() {
        boolean esPosible = false;
        try {
            if (fachada.esPosibleIniciarLlamada()) {
                this.modelo = new Llamada();
                this.modelo.agregarObservador(this);
                esPosible = true;
            }
        } catch (CantidadMaximaDeLlamadasException ex) {
           vista.reset();
           vista.mostrarMensajePorConsola(ex.getMessage());
        }
        return esPosible;
    }
    
    public boolean agregarClienteALlamada(String ci){
        boolean ret = false;
        try {
            Cliente cliente = fachada.buscarCliente(ci);
            if(cliente != null) {
                this.modelo.setCliente(cliente);
                ret = true;
            }
        } catch (ClienteNoRegistradoException ex) {
            vista.reset();
            vista.mostrarMensajePorConsola(ex.getMessage());
        } finally {
            return ret;
        }
    }
    
    public boolean agregarSectorALlamada(String sector) {
        boolean ret = false;
        int sectorInt = Integer.parseInt(sector);
        Sector s = null;
        try {
            s = fachada.getSector(sectorInt);
            if(s != null) {
                this.modelo.setSector(s);
                ret = true;
            }
        } catch (SectorNoValidoException ex) {
           vista.reset();
           vista.mostrarMensajePorConsola(ex.getMessage());
        } finally {
            return ret;
        }
    }
}
