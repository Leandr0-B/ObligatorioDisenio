/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public abstract class EstadoTrabajador {
    public void trabajadorDisponible(Trabajador T) throws Exception{
	throw new Exception("El estado del trabajador ya es disponible");
    }
    public void trabajadorNoDisponible(Trabajador T) throws Exception{
        throw new Exception("El estado del trabajador ya es no disponible");
    }
    public boolean estaDisponible() {
        return true;
    }
}
