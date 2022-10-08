package br.com.serratec.exercicios.Exercicio03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.exercicios.Exercicio03.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}