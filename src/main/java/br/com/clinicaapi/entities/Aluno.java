package br.com.clinicaapi.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Aluno extends Usuario{

	private static final long serialVersionUID = 1L;
	
	private String curso;

	public Aluno(Long id, String matricula, String nome, String tipoPerfil, String cpf, String endereco, String email,
			String senha, String curso) {
		super(id, matricula, nome, tipoPerfil, cpf, endereco, email, senha);
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	
}