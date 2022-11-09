/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

import edu.ort.obligatorio.dominio.Exceptions.CantidadMaximaDeLlamadasException;
import edu.ort.obligatorio.dominio.Exceptions.SectorNoDisponibleException;
import edu.ort.obligatorio.dominio.Llamada;
import edu.ort.obligatorio.dominio.Sector;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author leand
 */
public class ServicioLlamada {
    
    private static int cantidadMaximaLLamadaEnCursoyEnEspera = 5;
    private HashMap<Integer, Sector> sectores = new HashMap<>();
    private ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
    private static final String SECTOR_NO_DISPONIBLE = "Sector No Disponible";
    private static final String CANTIDAD_MAXIMA_DE_LLAMADAS = "Comuníquese más tarde, cantidad máxima de llamadas alcanzada";
    
    public Sector getSector(Integer numeroSector) {
        return sectores.get(numeroSector);
    }
        
    public HashMap<Integer, Sector> getListaSectores(){
        return sectores;
    }    
    
    // TO DO , ver como manejar esa Exception que viene del los tipos de llamada
    public void iniciarLlamada(Llamada l) throws SectorNoDisponibleException, CantidadMaximaDeLlamadasException, Exception{
       if(esPosibleIniciarLlamada()) {
            Sector s = l.getSector();
            // al menos un puesto del sector tiene un trabajador asignado
            if(s.estaDisponible()){
                llamadas.add(l);
                s.iniciarLlamada(l); 
            }else{
                throw new SectorNoDisponibleException(SECTOR_NO_DISPONIBLE);
            }
        } else {
            throw new CantidadMaximaDeLlamadasException(CANTIDAD_MAXIMA_DE_LLAMADAS);
        }
    }
       
    private int cantidadLlamadasEnCursoOEspera(){
        int cantidad = 0;
        for(Llamada l: llamadas){
            if(!l.esLlamadaFinalizada()){
                cantidad++;
            }
        }
        return cantidad;
    }
    
    private boolean esPosibleIniciarLlamada(){
        return cantidadLlamadasEnCursoOEspera() < cantidadMaximaLLamadaEnCursoyEnEspera;
    }
    
    public ArrayList<Llamada> listarLlamadasAtendidas(){
        
        ArrayList<Llamada> atendidas = null;
        for(Llamada l:llamadas){
            
            if(!l.esLlamadaEnEspera()){
                atendidas.add(l);
            }
        }
        return atendidas;
    }
    
    public boolean agregar(Sector s){
        boolean agregado = false;
        
        if(sectores.get(s.getNumeroSector())== null){
            sectores.put(s.getNumeroSector(), s);
            agregado = true;
        }
        return agregado;
    }
}
