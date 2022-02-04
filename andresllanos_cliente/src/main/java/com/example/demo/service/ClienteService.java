package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;

import com.example.demo.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente getClienteById(int id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public Cliente save(Cliente cliente) {
		Cliente clienteNew= clienteRepository.save(cliente);
		return clienteNew;
				
	}
	
}
