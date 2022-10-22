/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class Puesto {
    private EstadoPuesto estado;
    private Trabajador trabajador;

    public EstadoPuesto getEstado() {
        return estado;
    }

    public void setEstado(EstadoPuesto estado) {
        this.estado = estado;
    }

    public Trabajador getTrabajador() {
        return this.trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    public void asignarTrabajador(Trabajador t) {
        this.setTrabajador(trabajador);
        this.cambiarEstado();
    }
    
    public void cambiarEstado() {
        this.estado.next(this);
    }
    
    
}
