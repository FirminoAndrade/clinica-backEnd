package br.com.clinicaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.dto.UsuarioDto;
import br.com.clinicaapi.entities.Usuario;
import br.com.clinicaapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// buscar por id
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Usuário não encontrado! ID:" + id + " Tipo: " + Usuario.class.getName(), null));
	}

	// listar
	public static List<UsuarioDto> listarUsuarios(List<Usuario> usuario) {
		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

	// criar
	public Usuario criarUsuario(Usuario usuario) {
		usuario.setId(null);
		return usuarioRepository.save(usuario);
	}

	// atualizar
	public Usuario atualizarUsuario(Long id, UsuarioDto usuarioDto) {
		Usuario usuario = findById(id);
		usuario.setMatricula(usuarioDto.getMatricula());
		usuario.setNome(usuarioDto.getNome());
		usuario.setTipoPerfil(usuarioDto.getTipoPerfil());
		usuario.setCpf(usuarioDto.getCpf());
		usuario.setEndereco(usuarioDto.getEndereco());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setSenha(usuarioDto.getSenha());
		usuario.setTelefone(usuarioDto.getTelefone());

		return usuarioRepository.save(usuario);
	}

	// deletar
	public void deleteUsuario(Long id) {
		findById(id);
		usuarioRepository.deleteById(id);
	}
}
