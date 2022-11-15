/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.utilidades;

import edu.ort.obligatorio.dominio.Cliente;
import edu.ort.obligatorio.dominio.ClienteConCosto;
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
        try {
//            Trabajador trabajador1 = new Trabajador("123", "pass");
//            trabajador1.setNombreCompleto("Trabajador1");
//            
//            Sector sector1 = new Sector();
//            sector1.setNombre("Sector1");
//            sector1.setNumeroSector(1);
//            
//            Sector sector2 = new Sector();
//            sector2.setNombre("Sector2");
//            sector2.setNumeroSector(2);
//            
//            Puesto puesto1 = new Puesto(sector1);
//            puesto1.setNumeroPuesto(1);
//            Puesto puesto2 = new Puesto(sector1);
//            puesto2.setNumeroPuesto(2);
//            
//            sector1.agregarPuesto(puesto1);
//            sector1.agregarPuesto(puesto2);
//            
//            Fachada.getInstancia().agregar(sector1);
//            Fachada.getInstancia().agregar(sector2);
//            
//            Fachada.getInstancia().agregar(trabajador1, 1);
//            
//            Trabajador trabajador2 = new Trabajador("234", "pass");
//            trabajador2.setNombreCompleto("Trabajador2");
//            
//            Fachada.getInstancia().agregar(trabajador2, 1);
//            
//            Trabajador trabajador3 = new Trabajador("345", "pass");
//            trabajador3.setNombreCompleto("Trabajador3");
//            Fachada.getInstancia().agregar(trabajador3, 1);
//            
//            ArrayList<Llamada> llamadasEnEspera = new ArrayList<>();
//            Cliente c = new Cliente("789", "Cliente1", new ClienteGestor(), 0f);
//            Cliente c2 = new Cliente("4568", "Cliente2", new ClienteConCosto(), 0f);
//            Fachada.getInstancia().agregar(c);
//            Fachada.getInstancia().agregar(c2);
//
//            Llamada l = new Llamada(c, sector1);
//            Llamada l2 = new Llamada(c2, sector1);
//            Llamada l3 = new Llamada(c, sector1);
//            Llamada l4 = new Llamada(c, sector1);
////            llamadasEnEspera.add(l);
////            llamadasEnEspera.add(l2);
////            llamadasEnEspera.add(l3);
////            llamadasEnEspera.add(l4);
////            Fachada.getInstancia().getServicioLlamada().getLlamadas().add(l);
////            Fachada.getInstancia().getServicioLlamada().getLlamadas().add(l2);
////            Fachada.getInstancia().getServicioLlamada().getLlamadas().add(l3);
////            Fachada.getInstancia().getServicioLlamada().getLlamadas().add(l4);
////            sector1.setLlamadasEnEspera(llamadasEnEspera);
            
            /***********************************************************************/
            
            Trabajador trabajador1 = new Trabajador("12223334","Pass1");
            Trabajador trabajador2 = new Trabajador("23334445","Pass2");
            Trabajador trabajador3 = new Trabajador("34445556","Pass3");
            Trabajador trabajador4 = new Trabajador("45556667","Pass4");
            Trabajador trabajador5 = new Trabajador("56667778","Pass5");
            trabajador1.setNombreCompleto("María López");
            trabajador2.setNombreCompleto("Juan Perez");
            trabajador3.setNombreCompleto("Pablo Suárez");
            trabajador4.setNombreCompleto("Ana Díaz");
            trabajador5.setNombreCompleto("Ema Gómez");
            Sector sector1 = new Sector();
            Sector sector2 = new Sector();
            Sector sector3 = new Sector();
            Sector sector4 = new Sector();
            sector1.setNumeroSector(1);
            sector2.setNumeroSector(2);
            sector3.setNumeroSector(3);
            sector4.setNumeroSector(4);
            sector1.setNombre("Ventas");
            sector2.setNombre("Servicio técnico");
            sector3.setNombre("Postventa");
            sector4.setNombre("Facturación");
            Puesto puesto1 = new Puesto(sector1);
            Puesto puesto2 = new Puesto(sector1);
            Puesto puesto3 = new Puesto(sector1);
            Puesto puesto4 = new Puesto(sector1);
            Puesto puesto5 = new Puesto(sector2);
            Puesto puesto6 = new Puesto(sector2);
            Puesto puesto7 = new Puesto(sector2);
            Puesto puesto8 = new Puesto(sector3);
            Puesto puesto9 = new Puesto(sector3);
            Puesto puesto10 = new Puesto(sector3);
            Puesto puesto11 = new Puesto(sector3);
            Puesto puesto12 = new Puesto(sector4);
            Puesto puesto14 = new Puesto(sector4);
            sector1.agregarPuesto(puesto1);
            sector1.agregarPuesto(puesto2);
            sector1.agregarPuesto(puesto3);
            sector1.agregarPuesto(puesto4);
            sector2.agregarPuesto(puesto5);
            sector2.agregarPuesto(puesto6);
            sector2.agregarPuesto(puesto7);
            sector3.agregarPuesto(puesto8);
            sector3.agregarPuesto(puesto9);
            sector3.agregarPuesto(puesto10);
            sector3.agregarPuesto(puesto11);
            sector4.agregarPuesto(puesto12);
            sector4.agregarPuesto(puesto14);
            puesto1.setNumeroPuesto(1);
            puesto2.setNumeroPuesto(2);
            puesto3.setNumeroPuesto(3);
            puesto4.setNumeroPuesto(4);
            puesto5.setNumeroPuesto(5);
            puesto6.setNumeroPuesto(6);
            puesto7.setNumeroPuesto(7);
            puesto8.setNumeroPuesto(8);
            puesto9.setNumeroPuesto(9);
            puesto10.setNumeroPuesto(10);
            puesto11.setNumeroPuesto(11);
            puesto12.setNumeroPuesto(12);
            puesto14.setNumeroPuesto(14);
            
            
            Fachada.getInstancia().agregar(sector1);
            Fachada.getInstancia().agregar(sector2);
            Fachada.getInstancia().agregar(sector3);
            Fachada.getInstancia().agregar(sector4);
            
            Fachada.getInstancia().agregar(trabajador1, 1);
            Fachada.getInstancia().agregar(trabajador2, 2);
            Fachada.getInstancia().agregar(trabajador3, 3);
            Fachada.getInstancia().agregar(trabajador4, 4);
            Fachada.getInstancia().agregar(trabajador5, 1);
            
        } catch (SectorNoValidoException ex) {
            Logger.getLogger(DatosDePrueba.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
