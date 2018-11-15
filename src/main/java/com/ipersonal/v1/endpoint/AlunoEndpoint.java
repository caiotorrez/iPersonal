package com.ipersonal.v1.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ipersonal.model.Aluno;
import com.ipersonal.model.Perfil;
import com.ipersonal.model.Usuario;
import com.ipersonal.repository.AlunoRepository;
import com.ipersonal.repository.UsuarioRepository;
import com.ipersonal.v1.endpoint.dto.AlunoDTO;
import com.ipersonal.v1.endpoint.service.AlunoService;

@RestController
@RequestMapping("v1/aluno")
public class AlunoEndpoint {

	private final AlunoRepository alunoRepository;
	private final UsuarioRepository usuarioRepository;
	private AlunoService alunoService;
	
	@Autowired
	public AlunoEndpoint(AlunoRepository alunoRepository, UsuarioRepository usuarioRepository) {
		this.alunoRepository = alunoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping
	public ResponseEntity<Page<AlunoDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer size,
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@RequestParam(value="orderBy", defaultValue="Perfil.nome") String propiedades) {
		Pageable pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), propiedades);
		Page<AlunoDTO> pageAlunoPerfil = this.alunoRepository.findAll(pageRequest).map(aluno -> new AlunoDTO(aluno));
		return ResponseEntity.ok(pageAlunoPerfil);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
		Aluno aluno = this.alunoRepository.findById(id).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não Encontrado"));
		return ResponseEntity.ok(aluno);
	}
	
	@GetMapping(path = "{id}/perfil")
	public ResponseEntity<Aluno> getPerfil(@PathVariable Long id) {
		Aluno aluno = this.alunoRepository.findById(id).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não Encontrado"));
		return ResponseEntity.ok(aluno);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid Perfil perfil, Usuario usuario, Errors errors) {
		if (errors.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Corpo da requisição inválido.");
		}
		if (this.usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado");
		}
		Aluno aluno = this.alunoService.register(usuario, perfil);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(aluno.getId()).toUri()).build();
	}
	
	@PutMapping(path = "{id}")
	public ResponseEntity<Void> put(@RequestBody @Valid Aluno aluno, Errors errors, @PathVariable Long id) {
		if (errors.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Corpo da requisição inválido.");
		}
		if (!this.alunoRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não cadastrado", new NullPointerException());
		}
		this.alunoRepository.save(aluno);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (this.alunoRepository.existsById(id)) {
			Aluno aluno = this.alunoRepository.findById(id).get();
			if (aluno.isEnabled()) {
				aluno.setEnabled(false);
				this.alunoRepository.save(aluno);
				return ResponseEntity.noContent().build();
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
	}
}