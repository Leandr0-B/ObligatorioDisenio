/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ort.obligatorio.ui;

/**
 *
 * @author Nadia
 */
public interface VistaSimularLlamada {
    
    public void mostrarDatosDeLaLLamadaFinalizada(long duracion, float costo);
    public void mostrarMensajeDeError(String mensaje);
    public void reset();
    public void cerrarVista();
}
