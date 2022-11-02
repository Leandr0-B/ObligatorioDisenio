/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.utilidades;

import edu.ort.obligatorio.dominio.Cliente;
import edu.ort.obligatorio.dominio.ClienteGestor;
import edu.ort.obligatorio.dominio.Llamada;
import edu.ort.obligatorio.dominio.Puesto;
import edu.ort.obligatorio.dominio.Sector;
import edu.ort.obligatorio.dominio.TipoCliente;
import edu.ort.obligatorio.dominio.Trabajador;
import edu.ort.obligatorio.logica.Fachada;

/**
 *
 * @author Nadia
 */
public class DatosDePrueba {
    
    public static void cargar(){
        Trabajador trabajador1 = new Trabajador("123","pass");
        trabajador1.setNombreCompleto("Trabajador1");
        Puesto puesto1 = new Puesto();
        puesto1.setNumeroPuesto(1);
        Puesto puesto2 = new Puesto();
        puesto2.setNumeroPuesto(2);
        Sector sector1 = new Sector();
        sector1.setNombre("Sector1");
        
        sector1.agregarPuesto(puesto1);
        sector1.agregarPuesto(puesto2);

        sector1.setNumeroSector(1);
        Fachada.getInstancia().agregar(sector1);
        Fachada.getInstancia().agregar(trabajador1, 1);
        
        Trabajador trabajador2 = new Trabajador("234","pass");
        trabajador2.setNombreCompleto("Trabajador2");

        Fachada.getInstancia().agregar(trabajador2, 1);
        
        Trabajador trabajador3 = new Trabajador("345","pass");
        trabajador3.setNombreCompleto("Trabajador3");
        Fachada.getInstancia().agregar(trabajador3, 1);
        
    }
    
    
    
}
