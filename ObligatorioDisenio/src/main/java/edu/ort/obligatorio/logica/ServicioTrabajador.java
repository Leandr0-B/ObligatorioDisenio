/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

import edu.ort.obligatorio.dominio.Exceptions.LoginException;
import edu.ort.obligatorio.dominio.Persona;
import edu.ort.obligatorio.dominio.Sector;
import edu.ort.obligatorio.dominio.Trabajador;
import java.util.HashMap;

/**
 *
 * @author leand
 */
public class ServicioTrabajador {
    private HashMap<String, Trabajador> trabajadores = new HashMap<>();
    private static final String ACCESO_DENEGADO = "Acceso denegado";
        
    // el trabajador no va a ser agregado si el sector no existe
    public Boolean agregar(Trabajador trabajador, Integer numeroSector) {
        // Nadia es feliz con esta nueva variable; =)
        Boolean retorno = false;
        Sector sector = Fachada.getInstancia().getSector(numeroSector);
        // Lea opiona que Retorno no es necesaria , con agregarOk era suficiente =);
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
    
    public Trabajador login(String ci, String password) throws LoginException {
        Trabajador t = trabajadores.get(ci);
        if (t == null || !t.esPasswordValido(password)) {
            throw new LoginException(ACCESO_DENEGADO);
        }
        return t;
    }

}
