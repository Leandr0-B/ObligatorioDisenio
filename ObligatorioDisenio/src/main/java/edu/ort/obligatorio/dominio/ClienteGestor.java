/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import edu.ort.obligatorio.logica.ServicioLlamada;

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
    public float costoLlamada(Llamada l) {
        float costoLlamada = 0;
        float costoFijoLlamada = l.costoFijoDeLlamada();
        
        if(l.duracionLlamada()>180){
            costoLlamada = costoFijoLlamada;
        }
        else{
            costoLlamada = costoFijoLlamada/2;
            costoLlamada -= ServicioLlamada.costoFijoLlamadaPorSegundo * l.tiempoEnEspera();
        }
        return costoLlamada < 0 ? 0 : costoLlamada;
    }
}
