/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class Cliente extends Persona{
    private TipoCliente tipo;
    private Float saldo;

    public Cliente(String ci, String nombreCompleto, TipoCliente tipo, Float saldo) {
        super(ci, nombreCompleto);
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Cliente(TipoCliente tipo, Float saldo, String ci) {
        super(ci);
        this.tipo = tipo;
        this.saldo = saldo;
    }

    
    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
    
    
}
