/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public abstract class EstadoLlamada {
    public void llamadaEnEspera(Llamada l) throws Exception{
	throw new Exception("El estado de la llamada ya es en Espera/ o no puede cambiar a Espera");
    }
    public void llamadaEnCurso(Llamada l) throws Exception{
        throw new Exception("El estado de la llamada ya es en Curso/ o no puede cambiar a en Curso");
    }
    public void llamadaFinalizada(Llamada l) throws Exception{
        throw new Exception("El estado de la llamada ya es Finalizada/ o no puede cambiar a Finalizada");
    }
    
    public boolean finalizada() {
        return false;
    }
    
    public boolean enEspera(){
        return false;
    }
}
