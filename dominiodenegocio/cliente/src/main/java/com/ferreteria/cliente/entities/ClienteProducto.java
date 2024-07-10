/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferreteria.cliente.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author Soporte
 */

@Data
@Entity
public class ClienteProducto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long productId;
    @Transient
    private String nombreproducto;
  
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Cliente.class)
    @JoinColumn(name = "clienteId",nullable = true)
    private Cliente cliente;
    
    
}
