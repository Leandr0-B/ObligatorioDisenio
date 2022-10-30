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

    private void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    public void cambiarEstadoADisponible() throws Exception {
        this.estado.puestoDisponible(this);
        this.setTrabajador(null);
    }
    
    public void cambiarEstadoANoDisponible() throws Exception {
        this.estado.puestoNoDisponible(this);
    }
    
    //le asigna un trabajador al puesto y el T pasa a estar no disponible
    public void asignarTrabajador(Trabajador t) throws Exception {
        this.setTrabajador(trabajador);
        this.cambiarEstadoANoDisponible();
    }
    
    public boolean estaDisponible() {
        return this.estado.estaDisponible();
    }
    
    public boolean trabajadorDisponible() {
        return this.trabajador.estaDisponible();
    }
    
    public void agregarLlamada(Llamada l) {
        this.llamadas.add(l);
    }
   
    //puesto con trabajador Disponible para atender Llamadas
    public void puestoConTrabajadorDisponible()throws Exception{
        this.trabajador.cambiarEstadoADisponble();
        //avisar
    } 
     
    //puesto con trabajador No Disponible para atender Llamadas
     public void puestoConTrabajadorNoDisponible()throws Exception{
        this.trabajador.cambiarEstadoANoDisponble();
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
}
