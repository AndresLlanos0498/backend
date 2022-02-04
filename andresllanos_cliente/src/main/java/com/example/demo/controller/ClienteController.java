package com.example.demo.controller;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll(){
		List<Cliente> clientes = clienteService.getAll();
		if(clientes.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable("id") int id){
		Cliente clientes = clienteService.getClienteById(id);
		if(clientes == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(clientes);
	}
	
	@PostMapping()
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		Cliente clientes = clienteService.save(cliente);
		return ResponseEntity.ok(clientes);
	}
}
