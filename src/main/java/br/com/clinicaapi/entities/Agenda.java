package br.com.clinicaapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Campo NOME é requerido!")
	private String nome;

	@NotEmpty(message = "Campo CPF é requerido!")
	private String cpf;

	@NotEmpty(message = "Campo DATA é requerido!")
	private String data;

	@NotEmpty(message = "Campo TELEFONE é requerido!")
	private String fone;

	@NotEmpty(message = "Campo ESPECIALIDADE é requerido!")
	private String especialidade;

	private String nomeAluno;
	
	private boolean presenca;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
}
