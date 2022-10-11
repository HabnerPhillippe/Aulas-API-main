package br.com.residencia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Documento {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Pessoa pessoa;

    private String cpf;
    private String ci;
    private String orgaoExpedidor;
    private String tituloEleitor;
    private String certificadoReservista;


}
