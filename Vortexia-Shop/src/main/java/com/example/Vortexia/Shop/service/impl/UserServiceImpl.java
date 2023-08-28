package com.example.Vortexia.Shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Vortexia.Shop.model.User;
import com.example.Vortexia.Shop.repository.UserRepository;
import com.example.Vortexia.Shop.response.Output;
import com.example.Vortexia.Shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	Output output = new Output();

	@Override
	public ResponseEntity<Output> saveUser(User user) {
		
		try {
			User userSave = repository.save(user);
			output.setResult(userSave);
			output.setStatus(HttpStatus.CREATED);
		} 
		catch(Exception e){
			output.setResult("Usuário não foi criado");
			output.setStatus(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(output, output.getStatus());
	}

	@Override
	public ResponseEntity<Output> listAll() {
		try {
			List<User> userListAll = repository.findAll();
			output.setResult(userListAll);
			output.setStatus(HttpStatus.OK);
		} catch(Exception e) {
			output.setResult("Falha ao pesquisar");
			output.setStatus(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(output, output.getStatus());
	}

	@Override
	public ResponseEntity<Output> deleteById(Long id) {
		try {
			User userExistente = repository.findById(id).get();
			if(userExistente != null) {
			repository.deleteById(id);
			output.setResult("Usuário Deletado");
			output.setStatus(HttpStatus.OK); 
		}}
		catch(Exception e) {
			output.setResult("Não foi possivel realizar a exclusão");
			output.setStatus(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(output, output.getStatus());	
	}
	
	@Override
	public ResponseEntity<Output> getUserById(Long id){
		try{
			User userGetById = repository.findById(id).get();
			output.setResult(userGetById);
			output.setStatus(HttpStatus.FOUND);
		} catch (Exception e) {
			output.setResult("Usuário não encontrado");
			output.setStatus(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(output, output.getStatus());
	}
 
	@Override
	public ResponseEntity<Output> editUser(Long id, User user) {
		try {
			User userExistente = repository.findById(id).get();
			if(userExistente != null) {
			userExistente.setEmail(user.getEmail());
			userExistente.setNome(user.getNome());
			userExistente.setPassword(user.getPassword());
			userExistente.setEndereco(user.getEndereco());
			userExistente.setBairro(user.getBairro());
			userExistente.setTelefone(user.getTelefone());
			userExistente.setNumResidencial(user.getNumResidencial());
			repository.save(userExistente);
			
			output.setResult(userExistente);
			output.setStatus(HttpStatus.OK);
			}
			}catch (Exception e) {
				output.setResult("Não foi possivel alterar");
				output.setStatus(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(output, output.getStatus());
	}

	@Override
	public ResponseEntity<Output> listByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Output> listAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Output> listAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Output> listByBairro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Output> listByEndereco() {
		// TODO Auto-generated method stub
		return null;
	}

}
