/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import edu.ort.obligatorio.dominio.Exceptions.LlamadaEnEsperaException;
import edu.ort.obligatorio.dominio.Exceptions.PuestoNoDisponibleException;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 *
 * @author leand
 */
public class Sector {
    private String nombre;
    private ArrayList<Trabajador> trabajadores;
    private int numeroSector; 
    private ArrayList<Puesto> puestos;
    private ArrayList<Llamada> llamadasEnEspera;
    private ArrayList<Llamada> llamadasEnCursoOFinalizadas;
    private static final String NO_HAY_PUESTOS_DISPONIBLES = "no hay puestos disponibles";
    private String LLAMADA_EN_ESPERA = "Aguarde en línea, Ud. se encuentra a N llamadas de ser " +
       "atendido, la espera estimada es de X minutos";

    public Sector() {
        this.puestos = new ArrayList<>();
        this.llamadasEnEspera = new ArrayList<>();
        this.llamadasEnCursoOFinalizadas = new ArrayList<>();
        this.trabajadores = new ArrayList<>();
    }

    public ArrayList<Llamada> getLlamadasEnEspera() {
        return llamadasEnEspera;
    }

    public void setLlamadasEnEspera(ArrayList<Llamada> llamadasEnEspera) {
        this.llamadasEnEspera = llamadasEnEspera;
    }

    public ArrayList<Llamada> getLlamadasEnCursoOFinalizadas() {
        return llamadasEnCursoOFinalizadas;
    }

    public void setLlamadasEnCursoOFinalizadas(ArrayList<Llamada> llamadasEnCursoOFinalizadas) {
        this.llamadasEnCursoOFinalizadas = llamadasEnCursoOFinalizadas;
    }
      
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public int getNumeroSector() {
        return numeroSector;
    }

    public void setNumeroSector(int numeroSector) {
        this.numeroSector = numeroSector;
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }

    public void agregarPuesto(Puesto p) {
        this.puestos.add(p);
    }
    
    public int cantidadPuestos() {
        return this.puestos.size();
    }
    
    public void agregarTrabajador(Trabajador t) {
        this.trabajadores.add(t);
    }
    
    //le asigna un puesto disponible al T
    public void asignarPuesto(Trabajador t) throws PuestoNoDisponibleException, Exception {
        Puesto auxPuestoDisponible = this.obtenerPuestoDisponible();
        if(auxPuestoDisponible != null) {
            auxPuestoDisponible.asignarTrabajador(t);
            t.asignarPuesto(auxPuestoDisponible);
        } else {
            throw new PuestoNoDisponibleException(NO_HAY_PUESTOS_DISPONIBLES);
        }
    }
    
    
    public void asignarLlamadaAPuesto(Llamada l) throws Exception{
        
        Puesto p = obtenerPuestoConTrabajadorDisponible();
        asignarLlamadaAPuesto(l,p);
    }
    
    public void asignarLlamadaAPuesto(Llamada l, Puesto p) throws Exception {
        
        if(p != null) {
            
            // cambiamos el estado del trabajador // asignar la llamada al trabajador
            Trabajador t = p.getTrabajador();
            t.cambiarEstadoANoDisponble();
            l.setTrabajador(t);
            
            // asignar la llamada al puesto y al reves
            // TO DO: en lugar de agregar llamada, deberia ser atender llamada?
            p.agregarLlamada(l);
            l.setPuesto(p);
            // asignar la llamada al sector , ver
            
            //hay un puesto disponbile voy a poder mover la llamda de la lista de espera
            // a la lista de en curso o finalizada
            // setear hora de atender
            moverLlamadaDeEsperaAAtendida(l);
        }
        // si no asigno la llamada porque no habia puestos disponibles, entonces seguria en la lista de espera;
    }
    
    // metodo que busca un puesto disponible es decir, que no tenga un trabajador asignado
    public Puesto obtenerPuestoDisponible() {
        Puesto auxPuesto = null;
        for(Puesto p: this.puestos) {
            if(auxPuesto == null && p.estaDisponible()) {
                auxPuesto = p;
            }
        }
        return auxPuesto;
    }
    
    private Puesto obtenerPuestoConTrabajadorDisponible() {
        Puesto auxPuesto = null;
        for(Puesto p: this.puestos) {
            if(auxPuesto == null && !p.estaDisponible() && p.trabajadorDisponible()) {
                auxPuesto = p;
            }
        }
        return auxPuesto;
    }
    
    public void iniciarLlamada(Llamada l) throws Exception{
        // primero recibo la llamada y la agrego a la lista de espera
        llamadasEnEspera.add(l);
        if(hayPuestoConTrabajadorDisponible()){
            // luego intento asignar la llamda a un puesto
            asignarLlamadaAPuesto(l);
        }
        else{
            LLAMADA_EN_ESPERA = LLAMADA_EN_ESPERA.replace("N",String.valueOf(cantidadLlamadasEnEspera()));
            LLAMADA_EN_ESPERA = LLAMADA_EN_ESPERA.replace("X",String.valueOf(tiempoPromedioDeAtencionDelSector()));
            throw new LlamadaEnEsperaException(LLAMADA_EN_ESPERA);
        }
    }
    
    // pasa de una lista a la otra y tambien setea la hora de atencion
    private void moverLlamadaDeEsperaAAtendida(Llamada l) throws Exception{
        llamadasEnEspera.remove(l);
        llamadasEnCursoOFinalizadas.add(l);
        l.cambiarALLamadaEnCurso();
    }
    
    public boolean estaDisponible(){
        boolean sectorDisponible = false;
        for(Puesto p: puestos){ 
            // si el puesto esta disponible es porque no tiene un trabajador asignado
            // si el puesto NO esta disponible es porque el puesto TIENE un trabajador asignado
            if(!p.estaDisponible()){
                sectorDisponible = true;
            }
        }
        return sectorDisponible;
    }
    
    public boolean hayPuestoConTrabajadorDisponible(){
        
        boolean hay = false;
        for(Puesto p:puestos){
            if(p.trabajadorDisponible()){
                hay = true;
            }
        }
        return hay;
    }
    
    public int cantidadLlamadasEnEspera(){
        return this.llamadasEnEspera.size();
    }
    
    public float esperaEstimadaParaElSector(){
        return tiempoPromedioDeAtencionDelSector()*cantidadLlamadasEnEspera();
    }
   
    //Es el promedio De Los Tiempos Promedio De Atención De Cada Puesto
    public float tiempoPromedioDeAtencionDelSector(){
        float promedioAcumulado = 0;
        int cantidadPuestos = puestos.size();
        for(Puesto p:puestos){
            promedioAcumulado += p.tiempoPromedioLlamadas();
        }
        return cantidadPuestos > 0 ? promedioAcumulado/cantidadPuestos : 0;
    }
    
    public void finalizarLlamadaSinSerAtendida(Llamada l) throws Exception{
        this.llamadasEnCursoOFinalizadas.add(l);
        this.llamadasEnEspera.remove(l);    
        l.cambiarALLamadaFinalizada();
    }
    
   
}
