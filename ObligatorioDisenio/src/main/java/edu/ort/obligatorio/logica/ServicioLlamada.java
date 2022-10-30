/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

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
    
    public static int cantidadMaximaLLamadaEnCursoyEnEspera = 5;
    private float costoFijoLlamadaPorSegundo = 1;
    private HashMap<Integer, Sector> sectores = new HashMap<>();
    private ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
    private static final String SECTOR_NO_DISPONIBLE = "Sector No Disponible";
    
    public Sector getSector(Integer numeroSector) {
        return sectores.get(numeroSector);
    }
        
    public HashMap<Integer, Sector> getListaSectores(){
        return sectores;
    }    
    
    public void iniciarLlamada(Llamada l) throws Exception{
       Sector s = l.getSector();
       if(s.estaDisponible()){
           llamadas.add(l);
           s.iniciarLlamada(l); 
       }else{
           throw new SectorNoDisponibleException(SECTOR_NO_DISPONIBLE);
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
    
    public boolean esPosibleIniciarLlamada() throws Exception{
        return cantidadLlamadasEnCursoOEspera()<cantidadMaximaLLamadaEnCursoyEnEspera;
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
    
    public Boolean agregar(Sector s){
        Boolean agregado = false;
        
        if(sectores.get(s.getNumeroSector())== null){
            sectores.put(s.getNumeroSector(), s);
            agregado = true;
        }
        return agregado;
    }
}
