/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

import edu.ort.obligatorio.dominio.Cliente;
import edu.ort.obligatorio.dominio.Exceptions.LoginException;
import edu.ort.obligatorio.dominio.Trabajador;
import edu.ort.obligatorio.dominio.Usuario;
import edu.ort.obligatorio.dominio.Sector;

import java.util.HashMap;

/**
 *
 * @author leand
 */
public class ServicioUsuario {
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private static final String ACCESO_DENEGADO = "Acceso denegado";
    
    public Boolean agregar(Cliente cliente) {
        return agregarUsuario(cliente);
    }
    
    // el trabajador no va a ser agregado si el sector no existe
    public Boolean agregar(Trabajador trabajador, Integer numeroSector) {
        // Nadia es feliz con esta nueva variable; =)
        Boolean retorno = false;
        Sector sector = Fachada.getInstancia().getSector(numeroSector);
        // Lea opiona que Retorno no es necesaria , con agregarOk era suficiente =);
        Boolean agregarOk = false;
        if(sector != null) {
        agregarOk = agregarUsuario(trabajador);
        if (agregarOk) {
                trabajador.setSector(sector);
                sector.agregarTrabajador(trabajador);
                retorno = true;
            }
        }
        return retorno;
    }

    private Boolean agregarUsuario(Usuario usuario) {
        Boolean usuarioAgregado = false;
        try {
            usuarios.put(usuario.getCi(), usuario);
            usuarioAgregado = true;
        } finally {
            // TO DO
        }
        return usuarioAgregado;
    }
    
    public Trabajador login(String ci, String password) throws LoginException {
        Trabajador t = (Trabajador)usuarios.get(ci);
        if (t == null || !t.esPasswordValido(password)) {
            throw new LoginException(ACCESO_DENEGADO);
        }
        return t;
    }
}
