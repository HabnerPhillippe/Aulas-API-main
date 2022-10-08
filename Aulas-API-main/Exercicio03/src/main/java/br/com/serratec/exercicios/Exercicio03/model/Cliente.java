package br.com.serratec.exercicios.Exercicio03.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "cliente", schema = "public")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotBlank(message = "Preencha o nome!")
    @Size(max = 60, message = "Tamanho do campo inválido")
    @Column(nullable = false)
    private String nome;


    @Email(message = "Preencha o Email!")
    @Column
    private String email;
    
    @CPF(message = "Preencha o CPF!")
    @Size(max = 60, message = "Tamanho do campo inválido")
    @Column
    private String cpf;
    
    @NotNull(message = "Preencha a data de nascimento!")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
 
    @Embedded
    @Column
    private Endereco endereco;  
    
    public Cliente(Long id,
            @NotBlank(message = "Preencha o nome!") @Size(max = 60, message = "Tamanho do campo inválido") String nome,
            @Email(message = "Preencha o Email!") String email,
            @CPF(message = "Preencha o CPF!") @Size(max = 60, message = "Tamanho do campo inválido") String cpf,
            @NotNull(message = "Preencha a data de nascimento!") LocalDate dataNascimento, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", dataNascimento="
                + dataNascimento + "]";
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
