/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;


/**
 *
 * @author leand
 */
public class ClienteGestor extends TipoCliente{
    
    @Override
    public void cambiarAClienteGestor(Cliente c) throws Exception{
        throw new Exception("Cliente Gestor no puede cambiarse a Cliente Gestor");
    }

    @Override
    public float factorDeAjuste(Llamada l) {
        float factorDeAjuste = 1f;
        if(l.duracionLlamada() > 180){
                factorDeAjuste = factorDeAjuste;
        }
        else{
            factorDeAjuste = (factorDeAjuste/2f);
        }
        return factorDeAjuste;
    }
    
    @Override
    public float descuento(Llamada l) {
        float descuento  = 0f;
        if(l.duracionLlamada() <= 180){
            descuento = (float)Llamada.getCostoFijoLlamadaPorSegundo() * (float)l.tiempoEnEspera();
        }
        return descuento;
    }
}
