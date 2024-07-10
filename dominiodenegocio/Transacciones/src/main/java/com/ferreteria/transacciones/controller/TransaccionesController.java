/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferreteria.transacciones.controller;

import com.ferreteria.transacciones.entities.Transacciones;
import com.ferreteria.transacciones.service.TransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacciones")
public class TransaccionesController {

    @Autowired
    private TransaccionesService transaccionService;

    @GetMapping("/cliente/{clienteId}")
    public List<Transacciones> obtenerTransaccionesPorCliente(@PathVariable Long clienteId) {
        return transaccionService.obtenerTransaccionesPorCliente(clienteId);
    }

    @GetMapping
    public List<Transacciones> obtenerTodasLasTransacciones() {
        return transaccionService.obtenerTodasLasTransacciones();
    }

    @GetMapping("/{id}")
    public Optional<Transacciones> obtenerTransaccionPorId(@PathVariable Long id) {
        return transaccionService.obtenerTransaccionPorId(id);
    }

    @PostMapping
    public Transacciones crearTransaccion(@RequestBody Transacciones transaccion) {
        return transaccionService.crearTransaccion(transaccion);
    }

    @PutMapping("/{id}")
    public Transacciones actualizarTransaccion(@PathVariable Long id, @RequestBody Transacciones transaccion) {
        return transaccionService.actualizarTransaccion(id, transaccion);
    }

    @DeleteMapping("/{id}")
    public void eliminarTransaccion(@PathVariable Long id) {
        transaccionService.eliminarTransaccion(id);
    }
}



