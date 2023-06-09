package br.com.clinicaapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Campo MATRÍCULA é requerido!")
	@Column(unique = true)
	private String matricula;

	@NotEmpty(message = "Campo NOME é requerido!")
	@Length(min = 3, max = 50, message = "O Campo NOME deve ter entre 3 e 50 caracteres.")
	private String nome;

	@NotEmpty(message = "Campo TIPO DE PERFIL é requerido!")
	private String tipoPerfil;

	@NotEmpty(message = "Campo CPF é requerido!")
	private String cpf;

	private String endereco;
	
	@NotEmpty(message = "Campo TELEFONE é requerido!")
	private String telefone;
	
	@NotEmpty(message = "Campo EMAIL é requerido!")
	@Column(unique = true)
	private String email;

	@NotEmpty(message = "Campo SENHA é requerido!")
	private String senha;

}
