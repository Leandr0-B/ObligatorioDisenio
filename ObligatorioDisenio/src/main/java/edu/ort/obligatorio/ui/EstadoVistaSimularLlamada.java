/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.ui;

/**
 *
 * @author leand
 */
public abstract class EstadoVistaSimularLlamada {
    
    public void esperandoInicioLlamada(VistaSimularLlamada simularLlamada) throws Exception{
	throw new Exception("El estado de la vista ya es inicio Llamada");
    }
    
    public void esperandoCI(VistaSimularLlamada simularLlamada) throws Exception{
	throw new Exception("El estado de la vista ya es Esperando CI");
    }
    public void esperandoSector(VistaSimularLlamada simularLlamada) throws Exception{
        throw new Exception("El estado de la vista ya es esperandoSector");
    }
    
    public boolean esperandoCI() {
        return false;
    }
    
    public boolean esperandoSector() {
        return false;
    }
   
}
