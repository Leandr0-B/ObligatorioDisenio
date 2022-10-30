/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.dominio.Exceptions;

/**
 *
 * @author Nadia
 */
public class ClienteNoRegistradoException extends Exception{
    public ClienteNoRegistradoException(String mensaje){
        super(mensaje);
    };
}
