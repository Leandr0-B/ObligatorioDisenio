/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class LlamadaEsperandoCliente extends EstadoLlamada {
    @Override
    public void llamadaEsperandoSector(Llamada l) throws Exception{
        l.setEstado(new LlamadaEsperandoSector());
    }
    
    @Override
    public boolean esperandoCliente() {
        return true;
    }

    @Override
    public String toString() {
        return "Esperando CI";
    }
}
