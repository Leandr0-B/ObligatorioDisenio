/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.observador;

/**
 *
 * @author Nadia
 */
public interface Observador {
    public enum Eventos{
        LOGIN_TRABAJADOR,
        LLAMADA_EN_CURSO,
        LLAMADA_FINALIZADA;
    }
   
    public void actualizar(Observable origen, Object evento);
}
