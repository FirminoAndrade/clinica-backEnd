package br.com.clinicaapi.dto;

import br.com.clinicaapi.entities.Agenda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaDto {

	private Long id;
	private String nome;
	private String cpf;
	private String data;
	private String fone;
	private String especialidade;
	private String nomeAluno;
	private boolean presenca;
	
	public AgendaDto(Agenda agenda) {
		this.id = agenda.getId();
		this.nome = agenda.getNome();
		this.cpf = agenda.getCpf();
		this.data = agenda.getData();
		this.fone = agenda.getFone();
		this.especialidade = agenda.getEspecialidade();
		this.nomeAluno = agenda.getNomeAluno();
		this.presenca = agenda.isPresenca();
	}
}
