/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.dominio;
import edu.ort.obligatorio.logica.Fachada;
import edu.ort.obligatorio.observador.Observable;
import edu.ort.obligatorio.observador.Observador;
import edu.ort.obligatorio.utilidades.ArchivoDeConfiguracion;
import java.time.ZonedDateTime;
import java.time.Duration;


/**
 *
 * @author leand
 */
public class Llamada extends Observable {
    private static ArchivoDeConfiguracion ac = ArchivoDeConfiguracion.getInstancia();
    private int numeroLlamada;
    private ZonedDateTime fechaHoraInicio;
    private ZonedDateTime fechaHoraInicioAtencion;
    private ZonedDateTime fechaHoraFin;
    private String descripcion;
    private EstadoLlamada estado;
    private Puesto puesto;
    private Trabajador trabajador;
    private Cliente cliente;
    private Sector sector;
    private float costoLlamada;
    private float saldoDelCliente;
    private static float costoFijoLlamadaPorSegundo = ac.obtenerConfiguracion("costoFijoLlamadaPorSegundo");
    private static int numeralDeLlamada = 0;

    
    public Llamada() {
        this.fechaHoraInicio = ZonedDateTime.now();
        this.estado = new LlamadaEnInicio();
        this.siguienteNumeroDeLlamada();
    }

    public Llamada(Cliente cliente, Sector sector) {
        this.fechaHoraInicio = ZonedDateTime.now();
        this.sector= sector;
        this.cliente= cliente;
        this.estado = new LlamadaEnInicio();
        this.siguienteNumeroDeLlamada();
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    } 

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public EstadoLlamada getEstado() {
        return estado;
    }

    public void setEstado(EstadoLlamada estado) {
        this.estado = estado;
    }

    public ZonedDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(ZonedDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public ZonedDateTime getFechaHoraInicioAtencion() {
        return fechaHoraInicioAtencion;
    }

    public void setFechaHoraInicioAtencion(ZonedDateTime fechaHoraInicioAtencion) {
        this.fechaHoraInicioAtencion = fechaHoraInicioAtencion;
    }

    public ZonedDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(ZonedDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
       
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public long duracionLlamada(){
        long duracion = 0;
        if(fechaHoraFin != null &&  fechaHoraInicioAtencion != null) {
            duracion = Duration.between(fechaHoraInicioAtencion, fechaHoraFin).toSeconds();
        }
        return duracion;
    }
    
    public long tiempoEnEspera(){
        return Duration.between(fechaHoraInicio, fechaHoraInicioAtencion).toSeconds();
    }
    
    public void cambiarALLamadaEnCurso() throws Exception {
        this.estado.llamadaEnCurso(this);
        setFechaHoraInicioAtencion(ZonedDateTime.now());
        this.saldoDelCliente = cliente.getSaldo();
        this.avisar(Observador.Eventos.LLAMADA_EN_CURSO);
        Fachada.getInstancia().avisar(Observador.Eventos.LLAMADA_EN_CURSO);
    }
    public void cambiarALLamadaFinalizada() throws Exception {
        this.estado.llamadaFinalizada(this);
        setFechaHoraFin(ZonedDateTime.now());
        // seteo el costo de la llamada;
        this.setCostoLlamada(this.costoLlamada());
        cliente.actualizarSaldo(this.getCostoLlamada());
        this.saldoDelCliente = this.cliente.getSaldo();
        this.avisar(Observador.Eventos.LLAMADA_FINALIZADA);
        Fachada.getInstancia().avisar(Observador.Eventos.LLAMADA_FINALIZADA);
    }
    public void cambiarALlamadaEnEspera() throws Exception {
        this.estado.llamadaEnEspera(this);
    }
    public boolean esLlamadaFinalizada() {
        return this.estado.finalizada();
    }
    
    public boolean esLlamadaEnEspera() {
        return this.estado.enEspera();
    }
    
    public boolean esLlamadaEnCurso() {
        return this.estado.enCurso();
    }
    
    public boolean esLlamadaAtendida() {
        return this.fechaHoraInicioAtencion != null && this.puesto != null;
    }
    
    public String getNombreDelCliente() {
        return this.getCliente().getNombreCompleto();
    }
    
    public float costoFijoDeLlamada(){
        return costoFijoLlamadaPorSegundo * duracionLlamada();
    }
    
    private float costoLlamada() {
        float costoLlamada = 0f;
        if(this.esLlamadaAtendida()) {
            costoLlamada = costoFijoDeLlamada() * this.cliente.factorDeAjuste(this);
            costoLlamada = costoLlamada - this.cliente.descuento(this);
        }
        return costoLlamada < 0 ? 0 : costoLlamada;
    }
    
    public float getCostoLlamada() {
        return costoLlamada;
    }
    
    private void setCostoLlamada(float costo) {
        this.costoLlamada = costo;
    }
    
    private void siguienteNumeroDeLlamada() {
        Llamada.numeralDeLlamada += 1;
        this.numeroLlamada = Llamada.numeralDeLlamada;
    }

    public int getNumeroLlamada() {
        return numeroLlamada;
    }

    public static float getCostoFijoLlamadaPorSegundo() {
        return costoFijoLlamadaPorSegundo;
    }
    
    public int getNumeroPuesto() {
        return getPuesto().getNumeroPuesto();
    }

    public String getNombreDelTrabajador() {
        return getTrabajador().getNombreCompleto();
    }

    public float getSaldoDelCliente() {
        return saldoDelCliente;
    }

    private void setSaldoDelCliente(float saldoDelCliente) {
        this.saldoDelCliente = saldoDelCliente;
    }
    
    public String getNombreSector() {
        return this.getSector().getNombre();
    }

    
}
