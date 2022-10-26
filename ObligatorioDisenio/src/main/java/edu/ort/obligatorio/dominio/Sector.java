/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

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
    private static final String NO_HAY_PUESTOS_DISPONIBLES = "no hay puestos disponibles";
    private ArrayList<Llamada> llamadasEnEspera;
    private ArrayList<Llamada> llamadasEnCursoOFinalizadas;

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
    
    public void asignarPuesto(Trabajador t) throws PuestoNoDisponibleException, Exception {
        Puesto auxPuestoDisponible = this.obtenerPuestoDisponible();
        if(auxPuestoDisponible != null) {
            auxPuestoDisponible.asignarTrabajador(t);
            t.asignarPuesto(auxPuestoDisponible);
        } else {
            throw new PuestoNoDisponibleException(NO_HAY_PUESTOS_DISPONIBLES);
        }
    }
    
    public void asignarLlamadaAPuesto(Llamada l) throws Exception {
        Puesto puestoAux = obtenerPuestoConTrabajadorDisponible();
        if(puestoAux != null) {
            
            // cambiamos el estado del trabajador // asignar la llamada al trabajador
            Trabajador t = puestoAux.getTrabajador();
            t.cambiarEstadoANoDisponble();
            l.setTrabajador(t);
            
            // asignar la llamada al puesto y al reves
            // TO DO: en lugar de agregar llamada, deberia ser atender llamada?
            puestoAux.agregarLlamada(l);
            l.setPuesto(puestoAux);
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
    
    public void nuevaLlamada(Llamada l) throws Exception{
        // primero recibo la llamada y la agrego a la lista de espera
        llamadasEnEspera.add(l);
        // luego intento asignar la llamda a un puesto
        asignarLlamadaAPuesto(l);
        
    }
    
    // pasa de una lista a la otra y tambien setea la hora de atencion
    private void moverLlamadaDeEsperaAAtendida(Llamada l) throws Exception{
        llamadasEnEspera.remove(l);
        llamadasEnCursoOFinalizadas.add(l);
        // TO DO: ver si esto es correcto hacerlo aca
        l.setFechaHoraInicioAtencion(ZonedDateTime.now());
        l.cambiarALLamadaEnCurso();
    }
}
