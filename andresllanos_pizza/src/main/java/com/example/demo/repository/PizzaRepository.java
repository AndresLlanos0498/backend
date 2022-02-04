package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	
	List<Pizza> findByClienteId(int clienteId);

}
