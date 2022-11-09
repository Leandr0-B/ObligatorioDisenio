/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

import edu.ort.obligatorio.dominio.Exceptions.CantidadMaximaDeLlamadasException;
import edu.ort.obligatorio.dominio.Exceptions.LoginException;
import edu.ort.obligatorio.dominio.Exceptions.SectorNoDisponibleException;
import edu.ort.obligatorio.dominio.Llamada;
import edu.ort.obligatorio.dominio.Sector;
import edu.ort.obligatorio.dominio.Trabajador;
import edu.ort.obligatorio.observador.Observable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author leand
 */
public class Fachada extends Observable{
    private ServicioTrabajador servicioTrabajador;
    private ServicioCliente servicioCliente;
    private ServicioLlamada servicioLlamada;

    private static Fachada instancia;

    private Fachada() {
        servicioTrabajador = new ServicioTrabajador();
        servicioCliente = new ServicioCliente();
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

    public ServicioTrabajador getServicioTrabajador() {
        return servicioTrabajador;
    }

    public ServicioCliente getServicioCliente() {
        return servicioCliente;
    }

    public ServicioLlamada getServicioLlamada() {
        return servicioLlamada;
    }
    
    public Trabajador login(String ci, String password) throws LoginException, Exception{
        
        return servicioTrabajador.login(ci, password);      
    }
    
    public boolean agregar(Trabajador trabajador, Integer numeroSector){
        return servicioTrabajador.agregar(trabajador, numeroSector);
    }
    
    public boolean agregar(Sector s){
        return servicioLlamada.agregar(s);
    }
    
    public void iniciarLlamada(Llamada l) throws SectorNoDisponibleException, CantidadMaximaDeLlamadasException,Exception {
        servicioLlamada.iniciarLlamada(l);
    }
    
     public HashMap<Integer, Sector> getListaSectores() {
        return servicioLlamada.getListaSectores();
    }
}
