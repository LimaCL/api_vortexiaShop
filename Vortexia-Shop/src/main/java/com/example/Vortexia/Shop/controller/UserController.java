package com.example.Vortexia.Shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vortexia.Shop.model.User;
import com.example.Vortexia.Shop.response.Output;
import com.example.Vortexia.Shop.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<Output> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<Output> listAll(){
		return service.listAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Output> getUserById(@PathVariable Long id){
		return service.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Output> deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Output> editUser(@PathVariable Long id, @RequestBody User user){
		return service.editUser(id, user);
	}
	
	@GetMapping("/listAllClients")
	public ResponseEntity<Output> listAllClients(){
		return service.listAllClients();
	}
	
	@GetMapping("/listAllAdmins")
	public ResponseEntity<Output> listAllAdmins(){
		return service.listAllAdmins();
	}
}
