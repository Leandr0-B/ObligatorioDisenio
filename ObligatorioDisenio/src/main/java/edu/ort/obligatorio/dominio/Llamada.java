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
    private String descripcion;
    private EstadoLlamada estado;
    private Puesto puesto;
    private Trabajador trabajador;
    private Cliente cliente;
    private Sector sector;
    private float saldoDelCliente;
    public static float costoFijoLlamadaPorSegundo = 1;

    

    public Llamada(Cliente cliente, Sector sector) {
        this.fechaHoraInicio = ZonedDateTime.now();
        this.sector= sector;
        this.cliente= cliente;
        this.estado = new LlamadaEnEspera();
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    } 

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

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
       
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public long duracionLlamada(){
        return Duration.between(fechaHoraInicioAtencion, fechaHoraFin).toSeconds();
    }
    
    public long tiempoEnEspera(){
        return Duration.between(fechaHoraInicio, fechaHoraInicioAtencion).toSeconds();
    }
    
    public void cambiarALLamadaEnCurso() throws Exception {
        this.estado.llamadaEnCurso(this);
        setFechaHoraInicioAtencion(ZonedDateTime.now());
        this.saldoDelCliente = cliente.getSaldo();
        System.out.println("llamada en curso " + this.saldoDelCliente);
    }
    public void cambiarALLamadaFinalizada() throws Exception {
        this.estado.llamadaFinalizada(this);
        setFechaHoraFin(ZonedDateTime.now());
        // solo se actualizara el saldo si la llamada fue atendida
        if(this.esllamadaAtendida()) {
            cliente.actualizarSaldo(this.costoLlamada());
            this.saldoDelCliente = this.cliente.getSaldo();
            System.out.println("llamada finalizada " + this.saldoDelCliente);
        }
    }
    
    public boolean esLlamadaFinalizada() {
        return this.estado.finalizada();
    }
    
    public boolean esLlamadaEnEspera() {
        return this.estado.enEspera();
    }
    
    public boolean esllamadaAtendida() {
        return this.fechaHoraInicioAtencion != null;
    }
    
    public String getNombreDelCliente() {
        return this.getCliente().getNombreCompleto();
    }
    
    public float costoFijoDeLlamada(){
        return costoFijoLlamadaPorSegundo * duracionLlamada();
    }
    
    public float costoLlamada(){
        float costoLlamada = costoFijoDeLlamada() * this.cliente.factorDeAjuste(this);
        costoLlamada = costoLlamada - this.cliente.descuento(this);
        return costoLlamada < 0 ? 0 : costoLlamada;
    }
    
}
