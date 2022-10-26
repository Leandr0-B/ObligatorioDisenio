/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class PuestoDisponible extends EstadoPuesto {

    @Override
    public void puestoNoDisponible(Puesto p) {
        p.setEstado(new PuestoNoDisponible());
    }
    
}
