package br.com.serratec.pizzariaosferas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.pizzariaosferas.model.Cliente;
import br.com.serratec.pizzariaosferas.model.Funcionario;
import br.com.serratec.pizzariaosferas.model.exception.ResourceBadRequestException;
import br.com.serratec.pizzariaosferas.model.exception.ResourceNotFoundException;
import br.com.serratec.pizzariaosferas.repository.ClienteRepository;
import br.com.serratec.pizzariaosferas.repository.FuncionarioRepository;

@Service // pizzaiolo
public class ClienteService {

	@Autowired
	private ClienteRepository repositorio;
	
	
	public List<Cliente> obterTodos(){
		//Aqui pego todos os funcionarios do banco.
		return repositorio.findAll();
	}
	
	public Optional<Cliente> obterPorId(Long id){
		
		var clienteBanco = repositorio.findById(id);
		
		if(clienteBanco.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar um cliente com id: " + id);
		}
		
		
		return repositorio.findById(id);
	}
	
	public Optional<Cliente> obterPorEmail(String email){
		//Aqui pego o funcionario pelo id
		return repositorio.findByEmail(email);
	}
	
	public Cliente cadastrar(Cliente cliente) {
		//Aqui salvo o funcionario no banco.
		//Aqui eu cuidaria da regra de negocio caso existir.
		
		if(cliente.getEmail() == null) {
			throw new ResourceBadRequestException("Deu ruim mano, esqueceu de passar o e-mail.");
		}
		
		cliente.setId(null);
		return repositorio.save(cliente);
	}
	
	public Cliente atualizar(Long id, Cliente cliente) {
		//Aqui salvo o funcionario no banco.
		
		obterPorId(id);
		
		cliente.setId(id);
		return repositorio.save(cliente);
	}
	
	public void deletar(Long id) {
		//Aqui deleto o usuario do banco pelo seu ID.
		repositorio.deleteById(id);
	}
}
