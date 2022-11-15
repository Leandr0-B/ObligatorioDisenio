/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import edu.ort.obligatorio.dominio.Exceptions.CIException;
import edu.ort.obligatorio.dominio.Exceptions.NombreCompletoException;

/**
 *
 * @author leand
 */
public abstract class Persona {
    private String ci;
    private String nombreCompleto;
    private static final String  CI_INCORRECTA = "La CI debe contener entre 7 y 9 caracteres";
    private static final String  NOMBRE_INCORRECTO = "EL nombre debe contener entre 3 y 50 caracteres";



    public Persona(String ci, String nombreCompleto) {
        this.ci = ci;
        this.nombreCompleto = nombreCompleto;
    }
    
    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    public static boolean ciValida(String ci) throws CIException{
        boolean valida = true;
        if(ci.length() < 7 || ci.length() > 9) {
            valida = false;
            throw new CIException(CI_INCORRECTA);
        }  
        return valida;
    }
    
    public static boolean nombreCompletoValido(String nombreCompleto) throws NombreCompletoException{
        boolean valido = false;
       
        if(nombreCompleto.length() > 2 && nombreCompleto.length() < 25) {
            valido = true;
        }
        return valido;
    }
}
