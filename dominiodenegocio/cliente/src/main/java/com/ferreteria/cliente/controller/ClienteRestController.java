package com.ferreteria.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.ferreteria.cliente.entities.Cliente;
import com.ferreteria.cliente.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    private ClienteRepository clienteRepository;

    public final RestTemplate restTemplate;

    public ClienteRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Cliente input) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        return optionalCliente.map(cliente -> {
            cliente.setNombre(input.getNombre());
            cliente.setTelefono(input.getTelefono());
            Cliente savedCliente = clienteRepository.save(cliente);
            return new ResponseEntity<>(savedCliente, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Cliente input) {
        Cliente savedCliente = clienteRepository.save(input);
        return ResponseEntity.ok(savedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Optional<Cliente> findById = clienteRepository.findById(id);
        findById.ifPresent(clienteRepository::delete);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/full")
    public ResponseEntity<?> getByCodigo(@RequestParam String codigo) {
        Cliente cliente = clienteRepository.findByCodigo(codigo);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ;

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    /**
     * @param id
     * @return
     */
    // private String getProductId(long productId) {
    //     String url = "http://localhost:8083/producto/" + getProductId(this.id);
    //     ResponseEntity<JsonNode> response = restTemplate.getForEntity(url, JsonNode.class);
    //     JsonNode block = response.getBody();
    //     if (block != null) {
    //         return block.get("name").asText();
    //     }
    //     return null;
    // }
}