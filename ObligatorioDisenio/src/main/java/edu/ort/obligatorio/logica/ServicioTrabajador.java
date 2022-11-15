/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

import edu.ort.obligatorio.dominio.Exceptions.CIException;
import edu.ort.obligatorio.dominio.Exceptions.LoginException;
import edu.ort.obligatorio.dominio.Exceptions.PasswordException;
import edu.ort.obligatorio.dominio.Exceptions.PuestoNoDisponibleException;
import edu.ort.obligatorio.dominio.Exceptions.SectorNoValidoException;
import edu.ort.obligatorio.dominio.Sector;
import edu.ort.obligatorio.dominio.Trabajador;
import java.util.HashMap;

/**
 *
 * @author leand
 */
public class ServicioTrabajador {
    private HashMap<String, Trabajador> trabajadores = new HashMap<>();
    private HashMap<String, Trabajador> trabajadoresLogeados = new HashMap<>();

    private static final String ACCESO_DENEGADO = "Acceso denegado";
    private static final String TRABAJADOR_YA_LOGEADO = "Acceso denegado, Trabajador previamente logeado";

        
    // el trabajador no va a ser agregado si el sector no existe
    public boolean agregar(Trabajador trabajador, Integer numeroSector) throws SectorNoValidoException {
        Boolean retorno = false;
        Sector sector = Fachada.getInstancia().getSector(numeroSector);
        Boolean agregarOk = false;
        if(sector != null) {
        agregarOk = agregarTrabajador(trabajador);
        if (agregarOk) {
                trabajador.setSector(sector);
                sector.agregarTrabajador(trabajador);
                retorno = true;
            }
        }
        return retorno;
    }
    
    private Boolean agregarTrabajador(Trabajador trabajador) {
        Boolean usuarioAgregado = false;
        try {
            trabajadores.put(trabajador.getCi(), trabajador);
            usuarioAgregado = true;
        } finally {
            // TO DO
        }
        return usuarioAgregado;
    }
    
    public Trabajador login(String ci, String password) throws LoginException, PuestoNoDisponibleException, CIException, PasswordException, Exception {
        Trabajador t = null;
        
        if(Trabajador.ciValida(ci) && Trabajador.passwordValida(password)){
            if(trabajadoresLogeados.get(ci) == null) {
                t = trabajadores.get(ci);
                if (t == null || !t.esPasswordValido(password)) {
                    throw new LoginException(ACCESO_DENEGADO);
                }
                if(!t.estaDisponible()){
                    //Siempre que se loguea le cambiamos el estado a disponible para que pueda antender llamadas
                    t.cambiarEstadoADisponble();   
                }
                Sector sector = t.getSector();
                if (sector.asignarPuesto(t)) {
                    this.agregarATrabajadoresLogeados(t);
                }
            } else {
                throw new LoginException(TRABAJADOR_YA_LOGEADO);
            } 
        } 
        return t;
    }
    
    private void agregarATrabajadoresLogeados(Trabajador t) {
        this.trabajadoresLogeados.put(t.getCi(),t);
    }
    
    public void logOut(Trabajador t) {
        if (t != null && trabajadoresLogeados.containsKey(t.getCi())) {
            trabajadoresLogeados.remove(t.getCi());
        }
    }
    
}
