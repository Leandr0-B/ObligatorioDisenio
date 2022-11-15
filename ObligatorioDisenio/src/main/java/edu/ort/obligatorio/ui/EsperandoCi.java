/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.ui;

/**
 *
 * @author leand
 */
public class EsperandoCi extends EstadoVistaSimularLlamada {
    public void esperandoSector(VistaSimularLlamada simularLlamada) throws Exception{
        simularLlamada.setEstado(new EsperandoSector());
    }
    
    public boolean esperandoCI() {
        return true;
    }
}
