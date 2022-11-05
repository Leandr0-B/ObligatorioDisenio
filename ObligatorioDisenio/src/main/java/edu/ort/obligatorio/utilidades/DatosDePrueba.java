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
import edu.ort.obligatorio.dominio.Trabajador;
import edu.ort.obligatorio.logica.Fachada;
import java.util.ArrayList;

/**
 *
 * @author Nadia
 */
public class DatosDePrueba {
    
    public static void cargar(){
        Trabajador trabajador1 = new Trabajador("123","pass");
        trabajador1.setNombreCompleto("Trabajador1");
        
        Sector sector1 = new Sector();
        sector1.setNombre("Sector1");
        sector1.setNumeroSector(1);
        
        Sector sector2 = new Sector();
        sector2.setNombre("Sector2");
        sector2.setNumeroSector(2);
        
        Puesto puesto1 = new Puesto(sector1);
        puesto1.setNumeroPuesto(1);
        Puesto puesto2 = new Puesto(sector1);
        puesto2.setNumeroPuesto(2);
       
        sector1.agregarPuesto(puesto1);
        sector1.agregarPuesto(puesto2);

        
        Fachada.getInstancia().agregar(sector1);
        Fachada.getInstancia().agregar(trabajador1, 1);
        
        
        Trabajador trabajador2 = new Trabajador("234","pass");
        trabajador2.setNombreCompleto("Trabajador2");

        Fachada.getInstancia().agregar(trabajador2, 1);
        
        Trabajador trabajador3 = new Trabajador("345","pass");
        trabajador3.setNombreCompleto("Trabajador3");
        Fachada.getInstancia().agregar(trabajador3, 1);
        
        ArrayList<Llamada> llamadasEnEspera = new ArrayList<>();
        Cliente c = new Cliente("789","Cliente1",new ClienteGestor(),500f);
        Cliente c2 = new Cliente("4568","Cliente2",new ClienteGestor(),500f);
        Llamada l = new Llamada(c,sector1);
        Llamada l2 = new Llamada(c2,sector1);
        Llamada l3 = new Llamada(c,sector1);
        Llamada l4 = new Llamada(c,sector1);
        llamadasEnEspera.add(l);
        llamadasEnEspera.add(l2);
        llamadasEnEspera.add(l3);
        llamadasEnEspera.add(l4);
        sector1.setLlamadasEnEspera(llamadasEnEspera);
        
        
//        Fachada.getInstancia().agregar(sector2);
//        Puesto puesto3 = new Puesto(sector2);
//        puesto1.setNumeroPuesto(1);
//        sector2.agregarPuesto(puesto3);

        
    }
    
    
    
}
