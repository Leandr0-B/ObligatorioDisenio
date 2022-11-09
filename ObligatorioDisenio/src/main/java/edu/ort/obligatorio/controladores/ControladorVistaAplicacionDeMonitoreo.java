package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.dominio.Sector;
import edu.ort.obligatorio.logica.Fachada;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import edu.ort.obligatorio.ui.VistaAplicacionDeMonitoreo;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leand
 */
public class ControladorVistaAplicacionDeMonitoreo implements Observador {
    private final VistaAplicacionDeMonitoreo vista;
    private final Fachada modelo = Fachada.getInstancia();

    public ControladorVistaAplicacionDeMonitoreo(VistaAplicacionDeMonitoreo vista) {
        this.vista = vista;
        modelo.agregarObservador(this);
    }
    
    
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(Observador.Eventos.LLAMADA_FINALIZADA)) {
            this.recargarLlamadas();
        }
        if(evento.equals(Observador.Eventos.LLAMADA_EN_CURSO)) {
            this.recargarLlamadas();
        }
    }
    
    public void inicializar() {
        HashMap<Integer,Sector> Sectores = modelo.getListaSectores();
        vista.mostrarSectores(Sectores);
    }

    public void sectorSeleccionado(Sector sector) {
        if(sector != null) {
            vista.mostrarLlamadas(sector.getLlamadasEnCursoOFinalizadas());
        }
    }
    
    public void recargarLlamadas() {
        vista.recargarListaLlamadas();
    }
    
}
