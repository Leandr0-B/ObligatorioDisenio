/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import edu.ort.obligatorio.logica.Fachada;
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
    private Sector sector;

    public Puesto(int numeroPuesto, Sector sector) {
        this.llamadas = new ArrayList();
        this.estado = new PuestoDisponible();
        this.sector = sector;
        this.numeroPuesto = numeroPuesto;
        this.sector.agregarPuesto(this);
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
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
    
    // el puesto esta disponible si no tiene trabajador asignado
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
    
    private long duracionTotalLlamadasAtendidas() {
        long duracionTotal = 0;
        for(Llamada l: this.llamadas) {
            if(l.esLlamadaFinalizada()) {
                duracionTotal+=l.duracionLlamada();
            }
        }
        return duracionTotal;
    }
    
    public float tiempoPromedioLlamadas() {
        int cantidadDeLlamadasAtendidas = this.cantidadLlamadasAtendidas();
        return cantidadDeLlamadasAtendidas > 0 ? this.duracionTotalLlamadasAtendidas()/cantidadDeLlamadasAtendidas : 0;
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
        return this.sector.getNombre();
    }
    
    public void finalizarLlamadaDelPuesto() throws Exception {
        
        this.llamadaEnCurso.cambiarALLamadaFinalizada();
        // vacío la llamada en curso
        this.trabajador.cambiarEstadoADisponble();
        this.avisar(Observador.Eventos.LLAMADA_FINALIZADA);

        this.setLlamadaEnCurso(null);
    }
    
    public void setearDescripcionDeLlamada(String descrpcion) {
       this.llamadaEnCurso.setDescripcion(descrpcion);
    }
    
    public void nuevoTrabajadorEnPuestoAviso() {
        this.avisar(Observador.Eventos.NUEVO_TRABAJADOR_EN_PUESTO);
    }
    
    public void puestoConTrabajadorDisponibleAviso() {
        this.avisar(Observador.Eventos.PUESTO_CON_TRABAJADOR_DISPONIBLE);
    }
    
    public long duracionDeLlamada() {
        return this.llamadaEnCurso.duracionLlamada();
    }
    
    public float costoLlamada(){
        return this.llamadaEnCurso.getCostoLlamada();
    }
    
    public void trabajadorLiberaElPuesto() throws Exception {
            this.setTrabajador(null);
            this.cambiarEstadoADisponible();
    } 
    
    public boolean hayLlamadaEnCurso() {
        return this.llamadaEnCurso != null;
    }
    
    public boolean esValido() {
        return this.trabajadorDisponible() && !this.estaDisponible();
    }
}

