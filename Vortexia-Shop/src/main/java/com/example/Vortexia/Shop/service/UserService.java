package com.example.Vortexia.Shop.service;

import org.springframework.http.ResponseEntity;

import com.example.Vortexia.Shop.model.User;
import com.example.Vortexia.Shop.response.Output;

public interface UserService {

	ResponseEntity<Output> saveUser(User user);
	
	ResponseEntity<Output> listAll();
	
	ResponseEntity<Output> deleteById(Long id);
	
	ResponseEntity<Output> editUser(Long id, User user);
	
	ResponseEntity<Output> listByName(String nome);
	
	ResponseEntity<Output> getUserById(Long id);
	
	ResponseEntity<Output> listAllClients();
	
	ResponseEntity<Output> listAllAdmins();
	
	ResponseEntity<Output> listByBairro();
	
	ResponseEntity<Output> listByEndereco();
	
}
