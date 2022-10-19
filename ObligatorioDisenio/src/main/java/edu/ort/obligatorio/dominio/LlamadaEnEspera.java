/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class LlamadaEnEspera extends EstadoLlamada{
    
    @Override
    public void next(Llamada l) throws Exception{
        l.setEstado(new LlamadaEnCurso());
    }
    
    public void cambiarALlamadaFinalizada(Llamada l){
        l.setEstado(new LlamadaFinalizada());
    };
}
