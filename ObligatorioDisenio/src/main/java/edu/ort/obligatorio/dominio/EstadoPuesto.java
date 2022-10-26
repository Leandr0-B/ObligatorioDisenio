/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public abstract class  EstadoPuesto {
    public void puestoDisponible(Puesto P) throws Exception{
	throw new Exception("El estado del puesto ya es disponible");
    }
    public void puestoNoDisponible(Puesto P) throws Exception{
        throw new Exception("El estado del puesto ya es no disponible");
    }
    
    public boolean estaDisponible() {
        return true;
    }
    
    
}
