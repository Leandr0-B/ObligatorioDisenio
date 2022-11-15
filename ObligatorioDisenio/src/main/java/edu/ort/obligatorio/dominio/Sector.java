/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import edu.ort.obligatorio.dominio.Exceptions.LlamadaEnEsperaException;
import edu.ort.obligatorio.dominio.Exceptions.NoHayLlamadasException;
import edu.ort.obligatorio.dominio.Exceptions.PuestoNoDisponibleException;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leand
 */
public class Sector implements Observador{
    private String nombre;
    private ArrayList<Trabajador> trabajadores;
    private int numeroSector; 
    private ArrayList<Puesto> puestos;
    private ArrayList<Llamada> llamadasEnEspera;
    private ArrayList<Llamada> llamadasEnCursoOFinalizadas;
    private static final String NO_HAY_PUESTOS_DISPONIBLES = "No hay puestos disponibles";
    private String LLAMADA_EN_ESPERA = "Aguarde en línea, Ud. se encuentra a N llamadas de ser " +
       "atendido, la espera estimada es de X minutos";
    private String NO_HAY_LLAMADAS ="No hay llamadas en curso o finalizadas en el Sector";
    DecimalFormat df = new DecimalFormat("0.00");


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

    public ArrayList<Llamada> getLlamadasEnCursoOFinalizadas() throws NoHayLlamadasException {
        ArrayList<Llamada> llamadasEnCursooFinalizadasyAtendidas = new ArrayList<>();
        for(Llamada l: llamadasEnCursoOFinalizadas) {
            if(l.esLlamadaAtendida()) {
                llamadasEnCursooFinalizadasyAtendidas.add(l);
            }
        }
        if(!llamadasEnCursooFinalizadasyAtendidas.isEmpty()) {
            return llamadasEnCursooFinalizadasyAtendidas;
        } else {
            throw new NoHayLlamadasException(NO_HAY_LLAMADAS);
        }
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
    public boolean asignarPuesto(Trabajador t) throws PuestoNoDisponibleException, Exception {
        boolean puestoAsignado = false;
        Puesto auxPuestoDisponible = this.obtenerPuestoDisponible();
        if(auxPuestoDisponible != null) {
            auxPuestoDisponible.asignarTrabajador(t);
            t.asignarPuesto(auxPuestoDisponible);
            puestoAsignado = true;
        } else {
            throw new PuestoNoDisponibleException(NO_HAY_PUESTOS_DISPONIBLES);
        }
        return puestoAsignado;
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
            p.agregarLlamada(l);
            l.setPuesto(p);
            
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
    
    public void iniciarLlamada(Llamada l) throws LlamadaEnEsperaException, Exception{
        // primero recibo la llamada y la agrego a la lista de espera
        l.cambiarALlamadaEnEspera();
        llamadasEnEspera.add(l);
        if(hayPuestoConTrabajadorDisponible()){
            // luego intento asignar la llamda a un puesto
            asignarLlamadaAPuesto(l);
        }
        else{
            String LLAMADA_EN_ESPERA_Mensaje = LLAMADA_EN_ESPERA.replace("N",String.valueOf(cantidadLlamadasEnEspera()));
            LLAMADA_EN_ESPERA_Mensaje = LLAMADA_EN_ESPERA_Mensaje.replace("X",String.valueOf(df.format(tiempoPromedioDeAtencionDelSector()/60f)));
            throw new LlamadaEnEsperaException(LLAMADA_EN_ESPERA_Mensaje);
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
        int cantidadPuestos = 0;
        for(Puesto p:puestos){
            if(!p.estaDisponible()) {
                promedioAcumulado += p.tiempoPromedioLlamadas();
                cantidadPuestos++;
            }
        }
        return cantidadPuestos > 0 ? promedioAcumulado/cantidadPuestos : 0;
    }
    
   
    public void finalizarLlamadaSinSerAtendida(Llamada l) throws Exception{
        if(this.llamadasEnEspera.remove(l)) {
            this.llamadasEnCursoOFinalizadas.add(l);
            this.llamadasEnEspera.remove(l);
            l.cambiarALLamadaFinalizada();
        }
            
    }
    
    public Llamada obtenerPrimeraLlamadaEnEspera() {
        Llamada llamada = null;
        if (!this.llamadasEnEspera.isEmpty()) {
            llamada = this.llamadasEnEspera.get(0);
        }
        return llamada;
    }
     
    public synchronized void asignarPrimeraLlamaEnEsperaAPuesto(Puesto p) throws Exception {
        if(p.esValido()) {
            Llamada primerLlamadaEnEspera = obtenerPrimeraLlamadaEnEspera();
            if(primerLlamadaEnEspera != null) {
                asignarLlamadaAPuesto(primerLlamadaEnEspera, p);
            }
        }
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(Observador.Eventos.PUESTO_CON_TRABAJADOR_DISPONIBLE) || evento.equals(Observador.Eventos.NUEVO_TRABAJADOR_EN_PUESTO)) {
            try {
                asignarPrimeraLlamaEnEsperaAPuesto((Puesto)origen);
            } catch (Exception ex) {
                Logger.getLogger(Sector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
   
    
   
}
