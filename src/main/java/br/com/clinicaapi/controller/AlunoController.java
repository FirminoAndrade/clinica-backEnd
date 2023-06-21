package br.com.clinicaapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaapi.dto.AlunoDto;
import br.com.clinicaapi.entities.Aluno;
import br.com.clinicaapi.repository.AlunoRepository;
import br.com.clinicaapi.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private PasswordEncoder encoder;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Aluno")
	public ResponseEntity<Optional<Aluno>> buscarAluno(@PathVariable Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return ResponseEntity.ok().body(aluno);
	}

	@GetMapping
	@Operation(summary = "Listar Aluno")
	public List<AlunoDto> listarAluno() {
		List<Aluno> alunos = alunoRepository.findAll();
		return AlunoService.listarAlunos(alunos);
	}

	@GetMapping("/curso/{curso}")
	@Operation(summary = "Buscar Aluno por Curso")
	public  List<AlunoDto> listarNomesAlunosPorCurso(@PathVariable String curso) {
		List<Aluno> alunos = alunoRepository.findByNomeAlunoPorCurso(curso);
		return AlunoService.listarAlunos(alunos);
	}

	@PostMapping
	@Operation(summary = "Cadastrar Aluno")
	public ResponseEntity<Aluno> cadastrarAluno(@Valid @RequestBody Aluno aluno) {
		aluno.setSenha(encoder.encode(aluno.getSenha()));
		aluno = alunoService.criarAluno(aluno);
		return ResponseEntity.ok().body(aluno);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar Aluno")
	public ResponseEntity<AlunoDto> atualizarAluno(@Valid @PathVariable Long id, @RequestBody AlunoDto alunoDto) {
		alunoDto.setSenha(encoder.encode(alunoDto.getSenha()));
		Aluno aluno = alunoService.atualizarAluno(id, alunoDto);
		return ResponseEntity.ok(new AlunoDto(aluno));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Aluno")
	public ResponseEntity<?> deletarAluno(@PathVariable Long id) {
		alunoService.deleteAluno(id);
		return ResponseEntity.ok().build();
	}
}
