/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ort.obligatorio.ui;

import edu.ort.obligatorio.dominio.Llamada;
import edu.ort.obligatorio.dominio.Sector;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author leand
 */
public interface VistaAplicacionDeMonitoreo {
    public void mostrarSectores(HashMap<Integer, Sector> sectores);
     
    public void mostrarLlamadasDeSector(ArrayList<Llamada> llamadas);
    
    public void mostrarLlamadasDeTodosLosSectores(ArrayList<Llamada> llamadas);

    public void reset();

    public void recargarListaLlamadas();
    
    public void mostrarMensajeDeError(String mensaje);
}
