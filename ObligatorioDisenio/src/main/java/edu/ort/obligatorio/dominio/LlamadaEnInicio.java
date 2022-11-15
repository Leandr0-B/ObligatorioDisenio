/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class LlamadaEnInicio extends EstadoLlamada{
   
    @Override
    public void llamadaEnEspera(Llamada l) throws Exception{
        l.setEstado(new LlamadaEnEspera());
    }
    
    @Override
    public String toString() {
        return "Llamada En Inicio";
    }
}
