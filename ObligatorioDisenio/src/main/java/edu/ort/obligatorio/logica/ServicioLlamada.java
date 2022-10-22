/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

import edu.ort.obligatorio.dominio.Sector;
import java.util.HashMap;

/**
 *
 * @author leand
 */
public class ServicioLlamada {
    private HashMap<Integer, Sector> sectores = new HashMap<>();
    public static int cantidadMaximaLLamadaEnCursoyEnEspera = 5;
    private float costoFijoLlamadaPorSegundo = 1;
    
    public Sector getSector(Integer numeroSector) {
        return sectores.get(numeroSector);
    }
    
}
