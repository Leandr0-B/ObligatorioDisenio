/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author Nadia
 */
public class LlamadaEsperandoInicio extends EstadoLlamada{

    @Override
    public void llamadaEsperandoCliente(Llamada l) throws Exception{
        l.setEstado(new LlamadaEsperandoCliente());
    }
    
    @Override
    public boolean esperandoInicio() {
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Llamada Esperando Iniciarse";
    }
    
    
    
}
