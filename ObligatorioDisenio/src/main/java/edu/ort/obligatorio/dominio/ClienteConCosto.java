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
    public float costoLlamada(Llamada l){
        float costoLlamada = 0;
        if(l.tiempoEnEspera() < 60){
           costoLlamada = l.costoFijoDeLlamada();
        }
        else{
            costoLlamada =l.costoFijoDeLlamada()/2;
        }
        return costoLlamada < 0 ? 0 : costoLlamada;
    }
}
