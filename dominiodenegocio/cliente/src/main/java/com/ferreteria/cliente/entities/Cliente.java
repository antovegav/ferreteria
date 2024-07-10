/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferreteria.cliente.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.util.List;




import lombok.Data;

/**
 *
 * @author Soporte
 */
@Data
@Entity
public class Cliente {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String cuenta;
    private String codigo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCuenta() {
        return cuenta;
    }

    public void setCuent(String cuenta) {
        this.cuenta = cuenta;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClienteProducto> producto;
    @Transient
    private List<?> transacciones;

 
}
