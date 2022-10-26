/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import java.time.ZonedDateTime;
import java.time.Duration;

/**
 *
 * @author leand
 */
public class Llamada {
    private ZonedDateTime fechaHoraInicio;
    private ZonedDateTime fechaHoraInicioAtencion;
    private ZonedDateTime fechaHoraFin;
    private EstadoLlamada estado;
    private Puesto puesto;
    private Trabajador trabajador;

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public EstadoLlamada getEstado() {
        return estado;
    }

    public void setEstado(EstadoLlamada estado) {
        this.estado = estado;
    }

    public ZonedDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(ZonedDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public ZonedDateTime getFechaHoraInicioAtencion() {
        return fechaHoraInicioAtencion;
    }

    public void setFechaHoraInicioAtencion(ZonedDateTime fechaHoraInicioAtencion) {
        this.fechaHoraInicioAtencion = fechaHoraInicioAtencion;
    }

    public ZonedDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(ZonedDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
    
    public long duracionLlamada(){
        return Duration.between(fechaHoraInicioAtencion, fechaHoraFin).toSeconds();
    }
    
    public void cambiarALLamadaEnCurso() throws Exception {
        this.estado.llamadaEnCurso(this);
    }
    public void cambiarALLamadaFinalizada() throws Exception {
        this.estado.llamadaFinalizada(this);
    }
    
    public boolean esLlamadaFinalizada() {
        return this.estado.finalizada();
    }
}
