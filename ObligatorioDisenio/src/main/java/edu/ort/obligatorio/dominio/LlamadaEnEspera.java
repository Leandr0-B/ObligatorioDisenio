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
    public void llamadaEnCurso(Llamada l) throws Exception{
        l.setEstado(new LlamadaEnCurso());
    }
    @Override
    public void llamadaFinalizada(Llamada l) throws Exception{
        l.setEstado(new LlamadaFinalizada());
    }
}
