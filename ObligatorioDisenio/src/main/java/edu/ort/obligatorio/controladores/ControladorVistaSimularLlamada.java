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
    String ci = "";
    String mensajeParaConsola = "";
    String sector = "";

    public ControladorVistaSimularLlamada(VistaSimularLlamada vista) {
        this.vista = vista;
        this.fachada = Fachada.getInstancia();
        this.modelo = new Llamada();
        
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(Observador.Eventos.LLAMADA_EN_CURSO)) {           
            vista.mostrarInformacionDeLlamadaAtendida(this.modelo);
        }
        if(evento.equals(Observador.Eventos.LLAMADA_FINALIZADA)) {
            vista.reset();
            vista.mostrarInformacionDeLlamadaFinalizada(this.modelo);
            modelo = new Llamada();
            ci = "";
            mensajeParaConsola = "";
            sector = "";
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
    
    public void iniciarLlamada() {
        try {
            fachada.iniciarLlamada(this.modelo);
        } catch (CantidadMaximaDeLlamadasException ex) {
            this.reset();
            vista.mostrarMensajePorConsola(ex.getMessage());
        } catch (SectorNoDisponibleException ex) {
            this.reset();
            vista.mostrarMensajePorConsola(ex.getMessage());
        } catch (SectorNoValidoException ex) {
            this.reset();
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
                this.modelo.iniciarLlamada();
                this.modelo.agregarObservador(this);
                esPosible = true;
                this.mensajeParaConsola = "Ingrese su cédula seguida de la tecla numeral";
                vista.mostrarMensajePorConsola(this.mensajeParaConsola);
            }
        } catch (CantidadMaximaDeLlamadasException ex) {
           this.reset();
           vista.mostrarMensajePorConsola(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ControladorVistaSimularLlamada.class.getName()).log(Level.SEVERE, null, ex);
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
            this.reset();
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
           this.reset();
           vista.mostrarMensajePorConsola(ex.getMessage());
        } finally {
            return ret;
        }
    }
    
    public boolean hayLlamadaEnCursoOEspera() {
        return this.modelo != null && (this.modelo.esLlamadaEnCurso() || this.modelo.esLlamadaEnEspera());
    }

    public void armarSeleccion(String seleccion) {
        if(this.modelo.esLlamadaEsperandoCliente()) {
            if(seleccion.equalsIgnoreCase("#")) {
                if (this.agregarClienteALlamada(ci)) {
                    vista.mostrarSectores(fachada.getListaSectores());
                }
            } else {
                this.ci += seleccion;
                vista.mostrarMensajePorConsola(this.mensajeParaConsola +"\nCI:"+ this.ci);
            }
        } else if(this.modelo.esperandoSector()) {
            this.sector += seleccion;
            if (this.agregarSectorALlamada(this.sector)) {
                this.iniciarLlamada();
            }
        }
    }
    
    private void reset() {
        this.ci = "";
        this.mensajeParaConsola = "";
        this.sector = "";
        this.modelo = new Llamada();
        vista.reset();
    }
}
