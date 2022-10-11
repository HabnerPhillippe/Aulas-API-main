package br.com.serratec.pizzariaosferas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.pizzariaosferas.model.Funcionario;
import br.com.serratec.pizzariaosferas.model.exception.ResourceNotFoundException;
import br.com.serratec.pizzariaosferas.repository.FuncionarioRepository;

@Service // pizzaiolo
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repositorio;
	
	
	public List<Funcionario> obterTodos(){
		//Aqui pego todos os funcionarios do banco.
		return repositorio.findAll();
	}
	
	public Optional<Funcionario> obterPorId(Long id){

		var funcionarioBanco = repositorio.findById(id);
		
		if(funcionarioBanco.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar um funcionario com id: " + id);
		}
		
		return funcionarioBanco;
	}
	
	public Optional<Funcionario> obterPorEmail(String email){
		//Aqui pego o funcionario pelo id
		return repositorio.findByEmail(email);
	}
	
	public Funcionario cadastrar(Funcionario funcionario) {
		//Aqui salvo o funcionario no banco.
		//Aqui eu cuidaria da regra de negocio caso existir.
		
		funcionario.setId(null);
		return repositorio.save(funcionario);
	}
	
	public Funcionario atualizar(Long id, Funcionario funcionario) {
			
		// Aqui eu chamo o obter por id para saber se o funcionario existe, se não existir ja vai dar erro tratado.		
		obterPorId(id);
		
		funcionario.setId(id);
		return repositorio.save(funcionario);
	}
	
	public void deletar(Long id) {
		//Aqui deleto o usuario do banco pelo seu ID.
		repositorio.deleteById(id);
	}
}
