package com.ferreteria.producto.controller;

import com.ferreteria.producto.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.ferreteria.producto.repository.ProductoRepository;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

    @Autowired
    ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto get(@PathVariable long id){
        return productoRepository.findById(id).get();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Producto input){
        Producto find = productoRepository.findById(id).get();
            if(find != null){
                find.setCodigo(input.getCodigo());
                find.setNombre(input.getNombre());
            }
            Producto save = productoRepository.save(find);
            return ResponseEntity.ok(save);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Producto input) {
        Producto save = productoRepository.save(input);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        productoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}