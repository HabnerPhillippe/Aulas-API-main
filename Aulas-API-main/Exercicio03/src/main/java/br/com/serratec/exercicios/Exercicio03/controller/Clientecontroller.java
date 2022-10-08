package br.com.serratec.exercicios.Exercicio03.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.exercicios.Exercicio03.model.Cliente;
import br.com.serratec.exercicios.Exercicio03.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class Clientecontroller {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

@GetMapping("{id}")
public ResponseEntity<Cliente> buscar(@PathVariable Long id){
   Optional<Cliente> cliente= clienteRepository.findById(id);
   if (cliente.isPresent()){
    return ResponseEntity.ok(cliente.get());
   }
   return ResponseEntity.notFound().build();
}

@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}


 @DeleteMapping("{id}")
 public ResponseEntity<Void> remover(@PathVariable Long id) {
     if (!clienteRepository.existsById(id)) {
         return ResponseEntity.notFound().build();
     }
     clienteRepository.deleteById(id);
     return ResponseEntity.noContent().build();
 }

 @PutMapping("{id}")
 public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id,@RequestBody Cliente produto){
    if (!clienteRepository.existsById(id)){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(clienteRepository.save(produto));
 }

}
