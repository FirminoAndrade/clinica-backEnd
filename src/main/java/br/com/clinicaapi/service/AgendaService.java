package br.com.clinicaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.dto.AgendaDto;
import br.com.clinicaapi.entities.Agenda;
import br.com.clinicaapi.repository.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository agendaRepository;

	// buscar por id
	public Agenda findById(Long id) {
		Optional<Agenda> cliente = agendaRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Agendamento não encontrado! ID:" + id + " Tipo: " + Agenda.class.getName(), null));
	}

	// listar
	public static List<AgendaDto> listarAgendas(List<Agenda> agenda) {
		return agenda.stream().map(AgendaDto::new).collect(Collectors.toList());
	}

	// criar
	public Agenda criarAgenda(Agenda agenda) {
		agenda.setId(null);
		return agendaRepository.save(agenda);
	}

	// atualizar
	public Agenda atualizarAgenda(Long id, AgendaDto agendaDto) {
		Agenda agenda = findById(id);
		agenda.setNome(agendaDto.getNome());
		agenda.setCpf(agendaDto.getCpf());
		agenda.setData(agendaDto.getData());
		agenda.setFone(agendaDto.getFone());
		agenda.setEspecialidade(agendaDto.getEspecialidade());
		agenda.setNomeAluno(agendaDto.getNomeAluno());

		return agendaRepository.save(agenda);
	}

	// deletar
	public void deleteAgenda(Long id) {
		findById(id);
		agendaRepository.deleteById(id);
	}
}
