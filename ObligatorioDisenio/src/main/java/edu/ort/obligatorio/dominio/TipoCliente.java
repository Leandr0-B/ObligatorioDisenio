/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public abstract class TipoCliente {

    public void cambiarAClienteGestor(Cliente c) throws Exception {
        c.setTipo(new ClienteGestor());
    }

    public void cambiarAClienteConCosto(Cliente c) throws Exception {
        c.setTipo(new ClienteConCosto());
    }

    public void cambiarAClienteExonerado(Cliente c) throws Exception {
        c.setTipo(new ClienteExonerado());
    }
    
    public abstract float costoLlamada(Llamada l);
}
