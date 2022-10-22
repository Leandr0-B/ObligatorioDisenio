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
public class Sector {
    private String nombre;
    private ArrayList<Trabajador> trabajadores;
    private int numeroSector; 
    private ArrayList<Puesto> puestos;

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
    
    public void asignarPuestoATrabajador(Trabajador t) {
        Puesto auxPuestolibre = null;
        for(Puesto p: this.puestos) {
            if(auxPuestolibre == null && p.getEstado().estaLibre()) {
                auxPuestolibre = p;
            }
        }
        if(auxPuestolibre != null) {
            auxPuestolibre.asignarTrabajador(t);
        }
    }
    
}
