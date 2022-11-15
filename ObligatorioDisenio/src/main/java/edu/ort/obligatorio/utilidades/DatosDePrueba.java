/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.utilidades;

import edu.ort.obligatorio.dominio.Cliente;
import edu.ort.obligatorio.dominio.ClienteConCosto;
import edu.ort.obligatorio.dominio.ClienteExonerado;
import edu.ort.obligatorio.dominio.ClienteGestor;
import edu.ort.obligatorio.dominio.Exceptions.SectorNoValidoException;
import edu.ort.obligatorio.dominio.Llamada;
import edu.ort.obligatorio.dominio.Puesto;
import edu.ort.obligatorio.dominio.Sector;
import edu.ort.obligatorio.dominio.Trabajador;
import edu.ort.obligatorio.logica.Fachada;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadia
 */
public class DatosDePrueba {

    public static void cargar() {
        //try {
            /*
            Trabajador trabajador1 = new Trabajador("123", "pass");
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
            Fachada.getInstancia().agregar(sector2);
            
            Fachada.getInstancia().agregar(trabajador1, 1);
            
            Trabajador trabajador2 = new Trabajador("234", "pass");
            trabajador2.setNombreCompleto("Trabajador2");
            
            Fachada.getInstancia().agregar(trabajador2, 1);
            
            Trabajador trabajador3 = new Trabajador("345", "pass");
            trabajador3.setNombreCompleto("Trabajador3");
            Fachada.getInstancia().agregar(trabajador3, 1);
            
            ArrayList<Llamada> llamadasEnEspera = new ArrayList<>();
            Cliente c = new Cliente("789", "Cliente1", new ClienteGestor(), 0f);
            Cliente c2 = new Cliente("4568", "Cliente2", new ClienteConCosto(), 0f);
            Fachada.getInstancia().agregar(c);
            Fachada.getInstancia().agregar(c2);
*/
//            Llamada l = new Llamada(c, sector1);
//            Llamada l2 = new Llamada(c2, sector1);
//            Llamada l3 = new Llamada(c, sector1);
//            Llamada l4 = new Llamada(c, sector1);
//            llamadasEnEspera.add(l);
//            llamadasEnEspera.add(l2);
//            llamadasEnEspera.add(l3);
//            llamadasEnEspera.add(l4);
//            Fachada.getInstancia().getServicioLlamada().getLlamadas().add(l);
//            Fachada.getInstancia().getServicioLlamada().getLlamadas().add(l2);
//            Fachada.getInstancia().getServicioLlamada().getLlamadas().add(l3);
//            Fachada.getInstancia().getServicioLlamada().getLlamadas().add(l4);
//            sector1.setLlamadasEnEspera(llamadasEnEspera);
            
            /***********************************************************************/
            
            Trabajador trabajador1 = new Trabajador("12345671","Pass1", "María López");
            Trabajador trabajador2 = new Trabajador("12345672","Pass2", "Juan Perez");
            Trabajador trabajador3 = new Trabajador("12345673","Pass3", "Pablo Suárez");
            Trabajador trabajador4 = new Trabajador("12345674","Pass4", "Ana Díaz");
            Trabajador trabajador5 = new Trabajador("12345675","Pass5", "Ema Gómez");
            Trabajador trabajador6 = new Trabajador("12345676","Pass6", "Andrés Peraza");
            Trabajador trabajador7 = new Trabajador("12345677","Pass7", "Rosario Martínez");
            Trabajador trabajador8 = new Trabajador("12345678","Pass8", "Sebastián Bentancor");


              
            Cliente cliente1 = new Cliente("23456781", "Luis Martínez", new ClienteConCosto(), 0f);
            Cliente cliente2 = new Cliente("23456782", "Florencia Rodríguez", new ClienteConCosto(), 0f);
            Cliente cliente3 = new Cliente("23456783", "Sergio Benvenuto", new ClienteGestor(), 0f);
            Cliente cliente4 = new Cliente("23456784", "Tomas Navarro", new ClienteGestor(), 0f);
            Cliente cliente5 = new Cliente("23456785", "Lourdes Pose", new ClienteExonerado(), 0f);
            Cliente cliente6 = new Cliente("23456786", "Mónica Pereira", new ClienteExonerado(), 0f);

            Sector sector1 = new Sector(1, "Ventas");
            Sector sector2 = new Sector(2, "Servicio técnico");
            Sector sector3 = new Sector(3, "Postventa");
            Sector sector4 = new Sector(4, "Facturación");
            Puesto puesto1 = new Puesto(1,sector1);
            Puesto puesto2 = new Puesto(2,sector1);
            Puesto puesto3 = new Puesto(3,sector1);
            Puesto puesto4 = new Puesto(4,sector1);
            Puesto puesto5 = new Puesto(5,sector2);
            Puesto puesto6 = new Puesto(6,sector2);
            Puesto puesto7 = new Puesto(7,sector2);
            Puesto puesto8 = new Puesto(8,sector3);
            Puesto puesto9 = new Puesto(9,sector3);
            Puesto puesto10 = new Puesto(10,sector3);
            Puesto puesto11 = new Puesto(11,sector3);
            Puesto puesto12 = new Puesto(12,sector4);
            Puesto puesto14 = new Puesto(14,sector4);
            
            Fachada.getInstancia().agregar(sector1);
            Fachada.getInstancia().agregar(sector2);
            Fachada.getInstancia().agregar(sector3);
            Fachada.getInstancia().agregar(sector4);
            
        try { 
            Fachada.getInstancia().agregar(trabajador1, 1);
            Fachada.getInstancia().agregar(trabajador2, 2);
            Fachada.getInstancia().agregar(trabajador3, 3);
            Fachada.getInstancia().agregar(trabajador4, 4);
            Fachada.getInstancia().agregar(trabajador5, 1);
            Fachada.getInstancia().agregar(trabajador6, 2);
            Fachada.getInstancia().agregar(trabajador7, 1);
            Fachada.getInstancia().agregar(trabajador8, 2);
            
        } catch (SectorNoValidoException ex) {
            Logger.getLogger(DatosDePrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            Fachada.getInstancia().agregar(cliente1);
            Fachada.getInstancia().agregar(cliente2);
            Fachada.getInstancia().agregar(cliente3);
            Fachada.getInstancia().agregar(cliente4);
            Fachada.getInstancia().agregar(cliente5);
            Fachada.getInstancia().agregar(cliente6);
            

    }

}
