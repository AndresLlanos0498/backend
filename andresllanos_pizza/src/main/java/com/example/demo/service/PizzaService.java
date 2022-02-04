package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pizza;
import com.example.demo.repository.PizzaRepository;

@Service
public class PizzaService {
	
	@Autowired
	PizzaRepository pizzaRepository;
	
	public List<Pizza> getAll() {
		return pizzaRepository.findAll();
	}
	
	public Pizza getPizzaById(int id) {
		return pizzaRepository.findById(id).orElse(null);
	}
	
	public Pizza save(Pizza pizza) {
		Pizza pizzaNew = pizzaRepository.save(pizza);
		return pizzaNew;
	}
	
	public List<Pizza> byClientId(int clienteId) {
		return pizzaRepository.findByClienteId(clienteId);
	}

}
