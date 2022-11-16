/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

import edu.ort.obligatorio.dominio.Exceptions.PasswordException;

/**
 *
 * @author leand
 */
public class Trabajador extends Persona{
    private EstadoTrabajador estado;
    private Puesto puestoTrabajo;
    private String password;
    private Sector sector;
    private static final String PASSWORD_INVALIDA = "Acesso Denegado";

    public Trabajador(String ci, String password, String nombreCompleto) {
        super(ci, nombreCompleto);
        this.password = password;
        this.estado = new TrabajadorDisponible();
    }
    
    private String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EstadoTrabajador getEstado() {
        return estado;
    }

    public void setEstado(EstadoTrabajador estado) {
        this.estado = estado;
    }

    public Puesto getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(Puesto puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

   
    public boolean esPasswordValido(String password) {
        return this.password.equals(password);
    }
    
    public static boolean passwordValida(String password) throws PasswordException{
        boolean valida = true;
        if(password.length() < 4 || password.length() > 50) {
            valida = false;
            throw new PasswordException(PASSWORD_INVALIDA);
        }   
        return valida;
    }
    

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    
    public void cambiarEstadoADisponble() throws Exception{
        this.estado.trabajadorDisponible(this);
    }
    
    public void cambiarEstadoANoDisponble() throws Exception{
        this.estado.trabajadorNoDisponible(this);
    }

    public void asignarPuesto(Puesto auxPuestolibre) throws Exception{
        this.setPuestoTrabajo(auxPuestolibre);
    }

    public boolean estaDisponible() {
        return this.estado.estaDisponible();
    }

  
    
    
}
