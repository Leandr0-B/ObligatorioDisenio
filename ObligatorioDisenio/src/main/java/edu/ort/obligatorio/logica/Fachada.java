/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

import edu.ort.obligatorio.dominio.Sector;

/**
 *
 * @author leand
 */
public class Fachada {
    private ServicioUsuario servicioUsuario;
    private ServicioLlamada servicioLlamada;

    private static Fachada instancia;

    private Fachada() {
        servicioUsuario = new ServicioUsuario();
        servicioLlamada = new ServicioLlamada();
    }

    public synchronized static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
    
    public Sector getSector(Integer numeroSector) {
        return servicioLlamada.getSector(numeroSector);
    }
}
