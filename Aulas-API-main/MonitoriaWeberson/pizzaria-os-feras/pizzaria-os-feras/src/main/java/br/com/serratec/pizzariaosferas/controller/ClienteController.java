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

import br.com.serratec.pizzariaosferas.model.Cliente;
import br.com.serratec.pizzariaosferas.model.Funcionario;
import br.com.serratec.pizzariaosferas.service.ClienteService;
import br.com.serratec.pizzariaosferas.service.FuncionarioService;

@RestController // Esse cara será o garçon
@RequestMapping("/api/clientes") //Sempre colocar a rota cokm o nome da entidade no plural, é um padrão REST.
public class ClienteController { 

	@Autowired //new ClienteService();
	private ClienteService servico; // Pizzaiolo
	
	@GetMapping
	public List<Cliente> obterTodos(){
		return servico.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> obterPorId(@PathVariable Long id){
		return servico.obterPorId(id);
	}
	
	@PostMapping
	public Cliente cadastrar(@RequestBody Cliente cliente) {
		return servico.cadastrar(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return servico.atualizar(id, cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		servico.deletar(id);
	}
}
