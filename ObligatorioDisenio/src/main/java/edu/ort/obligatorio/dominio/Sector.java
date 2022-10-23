/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import edu.ort.obligatorio.dominio.Exceptions.PuestoDisponibleException;
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
    
    public void asignarPuestoATrabajador(Trabajador t) throws PuestoDisponibleException {
        Puesto auxPuestoDisponible = this.obtenerPuestoDisponible();
        if(auxPuestoDisponible != null) {
            auxPuestoDisponible.asignarTrabajador(t);
            t.asignarPuesto(auxPuestoDisponible);
        } else {
            throw new PuestoDisponibleException(NO_HAY_PUESTOS_DISPONIBLES);
        }
    }
    
    public void asignarLlamadaAPuesto(Llamada l) {
        Puesto aux = obtenerPuestoConTrabajadorDisponible();
        if(aux != null) {
            // TO:DO todo lo que haya que hacer con llamada
            // tambien cambiar el estado del trabajador
            // asignar la llamada al puesto y al reves
            // asignar la llamada al sector , ver
            // asignar la llamada al trabajador
        }
        // TO:DO la llamada tiene que quedar en cola
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
}
