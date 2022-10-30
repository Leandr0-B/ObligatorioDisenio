/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ort.obligatorio.observador;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Nadia
 */
public abstract class Observable {
    
    public Set<Observador> observadores = new HashSet<>();
    
    public void agregarObservador(Observador o){
        observadores.add(o);
    }
    
    public void eliminarObservador(Observador o){
        observadores.remove(o);
    }
    
    public void avisar(Object event){
        for (Iterator<Observador> iterator = observadores.iterator(); iterator.hasNext();) {
            Observador o = iterator.next();
            o.actualizar(this, event);
        }
    }
}
