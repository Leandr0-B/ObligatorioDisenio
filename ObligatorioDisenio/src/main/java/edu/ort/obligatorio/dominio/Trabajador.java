/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;

/**
 *
 * @author leand
 */
public class Trabajador extends Usuario{
    private EstadoTrabajador estado;
    private Puesto puestoTrabajo;
    private String password;
    private Sector sector;

    public Trabajador(String ci, String password) {
        super(ci);
        this.password = password;
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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    
    public void cambiarEstado() {
        this.estado.next(this);
    }

    void asignarPuesto(Puesto auxPuestolibre) {
        this.setPuestoTrabajo(auxPuestolibre);
        this.cambiarEstado();
    }
    
    
    
}
