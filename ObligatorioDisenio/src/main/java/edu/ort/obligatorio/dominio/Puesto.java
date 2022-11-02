/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import java.util.ArrayList;

/**
 *
 * @author leand
 */
public class Puesto extends Observable{
    private int numeroPuesto;
    private EstadoPuesto estado;    
    private Trabajador trabajador;
    private ArrayList<Llamada> llamadas;
    private Llamada llamadaEnCurso;

    public Puesto() {
        this.llamadas = new ArrayList();
        this.estado = new PuestoDisponible();
    }

    public Llamada getLlamadaEnCurso() {
        return llamadaEnCurso;
    }

    public void setLlamadaEnCurso(Llamada llamadaEnCurso) {
        this.llamadaEnCurso = llamadaEnCurso;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

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
        this.setTrabajador(t);
        this.cambiarEstadoANoDisponible();
    }
    
    public boolean estaDisponible() {
        return this.estado.estaDisponible();
    }
    
    // si el puesto tiene trabajador y ademas esta el trabajador disponible para atender llamadas
    public boolean trabajadorDisponible() {
        return this.trabajador != null && this.trabajador.estaDisponible();
    }
    
    public void agregarLlamada(Llamada l) {
        this.llamadaEnCurso = l;
        this.llamadas.add(l);
        this.avisar(Observador.Eventos.LLAMADA_EN_CURSO);
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
        int cantidadDeLlamadas = this.cantidadDeLlamadas();
        return cantidadDeLlamadas > 0 ? this.duracionTotalLlamadas()/this.cantidadDeLlamadas() : 0;
    }
    private long duracionTotalLlamadas() {
        long duracionTotal = 0;
        for(Llamada l: this.llamadas) {
            duracionTotal+=l.duracionLlamada();
        }
        return duracionTotal;
    }
    
    // se cuentan solamente las llamadas finalizadas del puesto;
    public int cantidadLlamadasAtendidas() {
        int contador = 0;
        for(Llamada l: llamadas) {
            if(l.esLlamadaFinalizada()) {
                contador++;
            }
        }
        return contador;
    }

    public String getNombreDelTrabajador() {
        return this.getTrabajador().getNombreCompleto();
    }

    public String getNombreDelSector() {
        return this.getTrabajador().getNombreDelSector();
    }
    
}

