/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class PuestoNoDisponible extends EstadoPuesto{

    @Override
    public void next(Puesto p) {
        p.setEstado(new PuestoDisponible());
    }
    
}
