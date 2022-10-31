/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.utilidades;

import edu.ort.obligatorio.dominio.Puesto;
import edu.ort.obligatorio.dominio.Sector;
import edu.ort.obligatorio.dominio.Trabajador;
import edu.ort.obligatorio.logica.Fachada;

/**
 *
 * @author Nadia
 */
public class DatosDePrueba {
    
    public static void cargar(){
        Trabajador trabajador1 = new Trabajador("123","pass");
        trabajador1.setNombreCompleto("Nombre Completo");
        Puesto puesto1 = new Puesto();
        puesto1.setNumeroPuesto(1);
        Sector sector1 = new Sector();
        sector1.setNombre("Sector1");
        sector1.agregarPuesto(puesto1);
        sector1.setNumeroSector(1);
        Fachada.getInstancia().agregar(sector1);
        Fachada.getInstancia().agregar(trabajador1, 1);
        
        Trabajador trabajador2 = new Trabajador("234","pass");
        Fachada.getInstancia().agregar(trabajador2, 1);
        
        
    }
    
    
    
}
