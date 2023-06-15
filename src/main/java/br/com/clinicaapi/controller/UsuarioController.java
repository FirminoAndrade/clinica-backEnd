package br.com.clinicaapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaapi.dto.UsuarioDto;
import br.com.clinicaapi.entities.Usuario;
import br.com.clinicaapi.repository.UsuarioRepository;
import br.com.clinicaapi.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Usuário")
	public ResponseEntity<Optional<Usuario>> buscarUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return ResponseEntity.ok().body(usuario);
	}

	@GetMapping("/email/{email}")
	@Operation(summary = "Buscar Usuário por Email")
	public ResponseEntity<Optional<Usuario>> buscarUsuarioPorEmail(@PathVariable String email) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		return ResponseEntity.ok().body(usuario);
	}

	@GetMapping("/curso/{curso}")
	@Operation(summary = "Buscar Aluno por Curso")
	public ResponseEntity<Optional<Usuario>> listarNomesAlunosPorCurso(@PathVariable String curso) {
		Optional<Usuario> alunos = usuarioRepository.findByNomeAlunoPorCurso(curso);
		return ResponseEntity.ok().body(alunos);
	}

	@GetMapping
	@Operation(summary = "Listar Usuários")
	public List<UsuarioDto> listarUsuario() {
		List<Usuario> usuarios = usuarioRepository.findAllDesc();
		return UsuarioService.listarUsuarios(usuarios);
	}

	@PostMapping
	@Operation(summary = "Cadastrar Usuário")
	public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
		usuario = usuarioService.criarUsuario(usuario);
		return ResponseEntity.ok().body(usuario);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar Usuário")
	public ResponseEntity<UsuarioDto> atualizarUsuario(@Valid @PathVariable Long id,
			@RequestBody UsuarioDto usuarioDto) {
		Usuario usuario = usuarioService.atualizarUsuario(id, usuarioDto);
		return ResponseEntity.ok(new UsuarioDto(usuario));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Usuário")
	public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
		usuarioService.deleteUsuario(id);
		return ResponseEntity.ok().build();
	}
}
