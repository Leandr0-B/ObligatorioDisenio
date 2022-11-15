/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.utilidades;

import edu.ort.obligatorio.logica.Fachada;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author leand
 */
public class ArchivoDeConfiguracion {
    private HashMap<String,Integer> configuracion;
    private static ArchivoDeConfiguracion instancia;
    
    
    private ArchivoDeConfiguracion() {
        configuracion = new HashMap<String,Integer>();
        this.cargarConfiguracion();
    } 
    public synchronized static ArchivoDeConfiguracion getInstancia() {
        if (instancia == null) {
            instancia = new ArchivoDeConfiguracion();
        }
        return instancia;
    }
    
    private void cargarConfiguracion() {
        File file = new File("./file.txt");
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split("=");
                    String nombreDeConfiguracion = values[0];
                    Integer valorDeConfiguracion = Integer.parseInt(values[1]);
                    configuracion.put(nombreDeConfiguracion,valorDeConfiguracion);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Integer obtenerConfiguracion(String config) {
        return configuracion.get(config);
    }
}
