/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ort.obligatorio.logica;

import edu.ort.obligatorio.dominio.Cliente;
import edu.ort.obligatorio.dominio.Exceptions.ClienteNoRegistradoException;
import java.util.HashMap;

/**
 *
 * @author leand
 */
public class ServicioCliente {
    private HashMap<String, Cliente> clientes = new HashMap<>();
    private static final String CLIENTE_NO_REGISTRADO = "Cliente No Registrado";

    public Boolean agregar(Cliente cliente) {
        Boolean usuarioAgregado = false;
        try {
            clientes.put(cliente.getCi(), cliente);
            usuarioAgregado = true;
        } finally {
            // TO DO
        }
        return usuarioAgregado;
    }
    
    public Cliente buscarCliente(String ci) throws ClienteNoRegistradoException{
        Cliente c = clientes.get(ci);
        if(c != null) {
            return c;
        } else {
            throw new ClienteNoRegistradoException(CLIENTE_NO_REGISTRADO);
        }
    }
}
