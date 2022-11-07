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
    private float saldo;

    public Cliente(String ci, String nombreCompleto, TipoCliente tipo, float saldo) {
        super(ci, nombreCompleto);
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Cliente(TipoCliente tipo, float saldo, String ci) {
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
       
    public void actualizarSaldo(float costoLlamada) {
        this.saldo -= costoLlamada;
    }
    
    public float factorDeAjuste(Llamada l) {
        return this.tipo.factorDeAjuste(l);
    }
    
}
