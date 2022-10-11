package br.com.serratec.pizzariaosferas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.pizzariaosferas.model.Cliente;
import br.com.serratec.pizzariaosferas.model.Funcionario;

@Repository // ajudante de cozinha
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByEmail(String email);

}
