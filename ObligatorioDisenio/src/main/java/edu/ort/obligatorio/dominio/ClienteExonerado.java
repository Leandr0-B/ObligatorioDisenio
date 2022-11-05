/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class ClienteExonerado extends TipoCliente{
    
    @Override
    public void cambiarAClienteExonerado(Cliente c) throws Exception{
        throw new Exception("Cliente Exonerado no puede cambiarse a Cliente Exonerado");
    }

    @Override
    public float costoLlamada(Llamada l) {
        return 0;
    }
    
    
}
