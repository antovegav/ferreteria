/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.ferreteria.transacciones.repository;

import com.ferreteria.transacciones.entities.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transacciones, Long> {
    List<Transacciones> findByClienteId(Long clienteId);
}

