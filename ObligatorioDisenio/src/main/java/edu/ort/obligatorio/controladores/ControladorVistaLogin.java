/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.controladores;

import edu.ort.obligatorio.dominio.Exceptions.LoginException;
import edu.ort.obligatorio.dominio.Trabajador;
import edu.ort.obligatorio.logica.Fachada;
import edu.ort.obligatorio.logica.ServicioTrabajador;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import edu.ort.obligatorio.ui.VistaLogin;


/**
 *
 * @author Nadia
 */
public class ControladorVistaLogin implements Observador{

    VistaLogin vista;   
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        //System.out.println("llegue");
    }

    public ControladorVistaLogin() {
    }
    
    public Trabajador login(String ci, String password) throws LoginException, Exception{
        return Fachada.getInstancia().login(ci, password);
    }
    
}
