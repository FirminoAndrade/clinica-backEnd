package br.com.clinicaapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.entities.Aluno;
import br.com.clinicaapi.entities.Consulta;
import br.com.clinicaapi.entities.Especialidade;
import br.com.clinicaapi.entities.Paciente;
import br.com.clinicaapi.entities.Usuario;
import br.com.clinicaapi.repository.AlunoRepository;
import br.com.clinicaapi.repository.ConsultaRepository;
import br.com.clinicaapi.repository.EspecialidadeRepository;
import br.com.clinicaapi.repository.PacienteRepository;
import br.com.clinicaapi.repository.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private ConsultaRepository consultaRepository;

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	

	public void instaciaBaseDeDados() {

//	for(int i =0; i<10 ; i++) {	

		Paciente paciente1 = new Paciente(null, "José Ferreira Andrade da Silva Santos", "1989/01/13", "81984661549", "andrade@yahoo.com", "11111111111","Masculino", "Joana Francisca Andrade", "Recife", "Av. Abdias de Carvalho", "Recife","Centro");
		Paciente paciente2 = new Paciente(null, "João da Silva", "2000/05/20", "1173569857", "joao@gmail.com", "22222222222","Masculino", "Maria Helena", "São Paulo", "Av. Paulista", "São Paulo", "Centro");
		pacienteRepository.saveAll(Arrays.asList(paciente1, paciente2));
		
		Consulta consulta1 = new Consulta(null, "1111", "Wesker Medeiros", "", "", "", "", "","11/06/2023","", paciente1);
		Consulta consulta2 = new Consulta(null,"2222", "Barry Batton de Souza", "", "", "", "", "","10/06/2023","", paciente2);
		consultaRepository.saveAll(Arrays.asList(consulta1, consulta2));
		
		paciente1.getConsultas().addAll(Arrays.asList(consulta1));
		paciente2.getConsultas().addAll(Arrays.asList(consulta2));

		Usuario usuario = new Usuario(null, "0000", "admin", "ADMIN", "00000000000", "admin","00000000000","admin","admin");
		Usuario professor1 = new Usuario(null, "1111", "Wesker Medeiros", "PROFESSOR", "12365478952", "rua 01","8185696524","professor", "professor");
		Usuario recepcionista = new Usuario(null, "3333", "Ada Wong de Mendes", "RECEPCIONISTA", "12387965236", "Av. Recon City","81736589858", "recepcao","recepcao");
		usuarioRepository.saveAll(Arrays.asList(usuario,professor1,recepcionista));
		
		Aluno aluno1 = new Aluno(null, "2222", "Barry Batton de Souza", "ALUNO", "12547896521", "rua 20", "8178456955","aluno","aluno","Enfermagem");
		Aluno aluno2 = new Aluno(null, "5555", "Maria de Souza Xavier", "ALUNO", "12547896522", "rua 20", "8178456955","aluno1","aluno1","Enfermagem");
		Aluno aluno3 = new Aluno(null, "4444", "João da silva Souza", "ALUNO", "12547896523", "rua 20", "8178456955","aluno2","aluno2","Fisioterapia");
		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
		
		Especialidade especialidade1 = new Especialidade(null, "Enfermagem", "Enfermagem");
		Especialidade especialidade2 = new Especialidade(null, "Nutrição", "Nutrição");
		Especialidade especialidade3 = new Especialidade(null, "Fisioterapia", "Fisioterapia");
	    especialidadeRepository.saveAll(Arrays.asList(especialidade1,especialidade2,especialidade3));
		// i = i+1;
		// }

	}
}
