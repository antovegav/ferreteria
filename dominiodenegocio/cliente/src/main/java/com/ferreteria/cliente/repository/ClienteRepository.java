/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.ferreteria.cliente.repository;

import com.ferreteria.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Soporte
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    @Query("SELECT c FROM Cliente c WHERE c.codigo = ?1")
    public Cliente findByCodigo(String codigo);

}
