/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

import edu.ort.obligatorio.dominio.Exceptions.CantidadMaximaDeLlamadasException;
import edu.ort.obligatorio.dominio.Exceptions.NoHayLlamadasException;
import edu.ort.obligatorio.dominio.Exceptions.SectorNoDisponibleException;
import edu.ort.obligatorio.dominio.Exceptions.SectorNoValidoException;
import edu.ort.obligatorio.dominio.Llamada;
import edu.ort.obligatorio.dominio.Puesto;
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
    private static final String SECTOR_NO_VALIDO = "Sector No Válido";
    private static final String CANTIDAD_MAXIMA_DE_LLAMADAS = "Comuníquese más tarde, cantidad máxima de llamadas alcanzada";
    private static final String NO_HAY_LLAMADAS = "No hay llamadas en curso o finalizadas en los Sectores";

    
    public Sector getSector(Integer numeroSector) throws SectorNoValidoException{
        Sector s = sectores.get(numeroSector);;
        if(s == null) {
            throw new SectorNoValidoException(SECTOR_NO_VALIDO);
        }
        return s;
    }
        
    public HashMap<Integer, Sector> getListaSectores() {
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
    
    public ArrayList<Llamada> listarLlamadasAtendidas() throws NoHayLlamadasException{
        
        ArrayList<Llamada> atendidas = new ArrayList<>();
        for(Llamada l:llamadas){
            
            if(!l.esLlamadaEnEspera()){
                atendidas.add(l);
            }
        }
        if(!atendidas.isEmpty()) {
            return atendidas;
        } else {
            throw new NoHayLlamadasException(NO_HAY_LLAMADAS);
        }
    }
    
    public boolean agregar(Sector s){
        boolean agregado = false;
        
        if(sectores.get(s.getNumeroSector())== null){
            sectores.put(s.getNumeroSector(), s);
            agregado = true;
        }
        return agregado;
    }
    
    //// TODO QUITAR ////
    public void setLlamadas(ArrayList<Llamada> llamadas) {
        this.llamadas = llamadas;
    }
    
     public ArrayList<Llamada> getLlamadas() {
        return this.llamadas;
    }
    ///////////////////////

    public void finalizarLlamada(Llamada l) throws Exception {
        if(l != null && !l.esLlamadaFinalizada()) {
            if(l.esLlamadaAtendida()) {
                Puesto p = l.getPuesto();
                p.finalizarLlamadaDelPuesto();
            } else {
                Sector s = l.getSector();
                if(s != null) {
                    s.finalizarLlamadaSinSerAtendida(l);
                }
            }
        }
    }
}
