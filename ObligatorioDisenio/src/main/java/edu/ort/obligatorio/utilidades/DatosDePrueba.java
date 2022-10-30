/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.utilidades;

import edu.ort.obligatorio.dominio.Sector;
import edu.ort.obligatorio.dominio.Trabajador;
import edu.ort.obligatorio.logica.Fachada;

/**
 *
 * @author Nadia
 */
public class DatosDePrueba {
    
    public static void cargar(){
        Trabajador trabajador = new Trabajador("123","pass");
        Sector sector = new Sector();
        sector.setNumeroSector(1);
        Fachada.getInstancia().agregar(sector);
        Fachada.getInstancia().agregar(trabajador, 1);
        
    }
    
    
    
}
