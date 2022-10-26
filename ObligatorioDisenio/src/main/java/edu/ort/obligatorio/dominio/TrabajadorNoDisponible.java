/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class TrabajadorNoDisponible extends EstadoTrabajador{

    @Override
    public void trabajadorDisponible(Trabajador p) {
        p.setEstado(new TrabajadorDisponible());
    }
    
    @Override
    public boolean estaDisponible() {
        return false;
    }
    
}
