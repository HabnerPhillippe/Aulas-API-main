package br.com.serratec.pizzariaosferas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.pizzariaosferas.model.Funcionario;
import br.com.serratec.pizzariaosferas.service.FuncionarioService;

@RestController // Esse cara será o garçon
@RequestMapping("/api/funcionarios") //Sempre colocar a rota cokm o nome da entidade no plural, é um padrão REST.
public class FuncionarioController { 

	@Autowired
	private FuncionarioService servico; // Pizzaiolo
	
	@GetMapping
	public List<Funcionario> obterTodos(){
		return servico.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<Funcionario> obterPorId(@PathVariable Long id){
		return servico.obterPorId(id);
	}
	
	@PostMapping
	public Funcionario cadastrar(@RequestBody Funcionario funcionario) {
		return servico.cadastrar(funcionario);
	}
	
	@PutMapping("/{id}")
	public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		return servico.atualizar(id, funcionario);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		servico.deletar(id);
	}
}
