package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pizza;
import com.example.demo.service.PizzaService;

@RestController
@RequestMapping("/pizza")
public class PizzaController {
	
	@Autowired
	PizzaService pizzaService;
	
	@GetMapping
	public ResponseEntity<List<Pizza>> getAll(){
		List<Pizza> pizzas = pizzaService.getAll();
		if(pizzas.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(pizzas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pizza> getById(@PathVariable("id") int id){
		Pizza pizzas = pizzaService.getPizzaById(id);
		if(pizzas==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pizzas);
	}
	
	@PostMapping
	public ResponseEntity<Pizza> save(@RequestBody Pizza pizza){
		Pizza pizzas = pizzaService.save(pizza);
		return ResponseEntity.ok(pizzas);
	}
	
	@GetMapping("/bycliente/{clienteId}")
	public ResponseEntity<List<Pizza>> getByClienteId(@PathVariable("clienteId") int clienteId){
		List<Pizza> pizzas = pizzaService.byClientId(clienteId);
		if(pizzas.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(pizzas);
	}

}
