/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class TrabajadorDisponible implements EstadoTrabajador{

    @Override
    public void next(Trabajador p) {
        p.setEstado(new TrabajadorNoDisponible());
    }
    
}
