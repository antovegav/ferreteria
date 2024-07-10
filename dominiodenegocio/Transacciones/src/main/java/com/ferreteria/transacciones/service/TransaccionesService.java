/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferreteria.transacciones.service;

import com.ferreteria.transacciones.entities.Transacciones;
import com.ferreteria.transacciones.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionesService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    public List<Transacciones> obtenerTransaccionesPorCliente(Long clienteId) {
        return transaccionRepository.findByClienteId(clienteId);
    }

    public List<Transacciones> obtenerTodasLasTransacciones() {
        return transaccionRepository.findAll();
    }

    public Optional<Transacciones> obtenerTransaccionPorId(Long id) {
        return transaccionRepository.findById(id);
    }

    public Transacciones crearTransaccion(Transacciones transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public Transacciones actualizarTransaccion(Long id, Transacciones transacciones) {
        if (transaccionRepository.existsById(id)) {
            transacciones.setId(id);
            return transaccionRepository.save(transacciones);
        } else {
            throw new RuntimeException("Transaccion no encontrada con id " + id);
        }
    }

    public void eliminarTransaccion(Long id) {
        if (transaccionRepository.existsById(id)) {
            transaccionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Transaccion no encontrada con id " + id);
        }
    }
}

