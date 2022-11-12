/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.ui;

/**
 *
 * @author leand
 */
public class EsperandoInicioLlamada extends EstadoVistaSimularLlamada{
    public void esperandoCI(VistaSimularLlamada simularLlamada) throws Exception{
        simularLlamada.setEstado(new EsperandoCi());
    }
}
