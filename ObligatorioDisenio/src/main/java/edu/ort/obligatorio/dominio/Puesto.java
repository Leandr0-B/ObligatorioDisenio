/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import java.util.ArrayList;

/**
 *
 * @author leand
 */
public class Puesto {
    private EstadoPuesto estado;    
    private Trabajador trabajador;
    private ArrayList<Llamada> llamadas;

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
    
    public int cantidadDeLlamadas() {
        return llamadas.size();
    }
    
    public float tiempoPromedioLlamadas() {
        return this.duracionTotalLlamadas()/this.cantidadDeLlamadas();
    }
    private long duracionTotalLlamadas() {
        long duracionTotal = 0;
        for(Llamada l: this.llamadas) {
            duracionTotal+=l.duracionLlamada();
        }
        return duracionTotal;
    }
    
    public boolean estaDisponible() {
        return this.estado.estaDisponible();
    }
    
    public boolean trabajadorDisponible() {
        return this.trabajador.estaDisponible();
    }
    
    
}
