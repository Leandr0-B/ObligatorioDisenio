/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ort.obligatorio.ui;

/**
 *
 * @author leand
 */
public interface VistaAtenderLlamada {
    public void nombreSector(String nombreSector);
    
    public void numeroPuesto(int numeroPuesto);
    
    public void cantidadLlamadasAtendidas(int cantidadLlamadas);
    
    public void tiempoPromedioLlamadas(float tiempoPromedio);
    
    public void nombreTrabajador(String nombreTrabajador);
    
    public void nombreCliente(String nombreCliente);
    
    public void estadoLlamadaEnCurso();
    
    public void estadoLlamadaEsperandoLlamada();
    
    public void estadoLlamadaFinalizada();

    public void mostrarMensajeDeError(String mensaje);
    
    public void reset();
}
