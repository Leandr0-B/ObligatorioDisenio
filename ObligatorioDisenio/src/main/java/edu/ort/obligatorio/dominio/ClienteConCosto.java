/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class ClienteConCosto extends TipoCliente{
    
    @Override
    public void cambiarAClienteConCosto(Cliente c) throws Exception{
        throw new Exception("Cliente Con Costo no puede cambiarse a Cliente Con Costo");
    }
    
    @Override
    public float factorDeAjuste(Llamada l){
        float factorDeAjuste;
        if(l.tiempoEnEspera() < 60){
           factorDeAjuste = 1f;
        }
        else{
            factorDeAjuste = 1/2f;
        }
        return factorDeAjuste;
    }
}
