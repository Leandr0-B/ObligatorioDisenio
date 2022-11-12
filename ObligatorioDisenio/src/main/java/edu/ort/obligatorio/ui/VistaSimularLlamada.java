/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ort.obligatorio.ui;
import edu.ort.obligatorio.dominio.Sector;
import java.util.HashMap;

/**
 *
 * @author Nadia
 */
public interface VistaSimularLlamada {
    
    public void mostrarMensajeDeError(String mensaje);
    public void mostrarMensajePorConsola(String mensaje);
    public void reset();
    public void mostrarSectores(HashMap<Integer, Sector> sectores);

    
    
    public void cerrarVista();
    public void setEstado(EstadoVistaSimularLlamada estado);
}
