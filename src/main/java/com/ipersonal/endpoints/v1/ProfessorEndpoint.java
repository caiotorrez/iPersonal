package com.ipersonal.endpoints.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ipersonal.model.Professor;
import com.ipersonal.repository.ProfessorRepository;

@RestController
@RequestMapping("/v1/admin/professor")
public class ProfessorEndpoint {
	
	private final ProfessorRepository professorRepository;
	
	@Autowired
	public ProfessorEndpoint(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	@GetMapping
	public ResponseEntity<List<Professor>> getList(@RequestParam(value = "nome", defaultValue = "") String nome) {
		List<Professor> lista = this.professorRepository
				.findAllByPerfilPrimeiroNomeStartingWithAndEnabledIsTrue(nome);
		return ResponseEntity.ok(lista);			
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Professor> get(@PathVariable Long id) {
		Professor professor = this.professorRepository.findById(id).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não Encontrado"));
		return ResponseEntity.ok(professor);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid Professor professor, Errors errors) {
		if (errors.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Corpo da requisição inválido.");
		}
		if (this.professorRepository.existsById(professor.getId())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Usuário já cadastrado");
		}
		this.professorRepository.save(professor);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(professor.getId()).toUri()).build();
	}
	
	@PutMapping(path = "{id}")
	public ResponseEntity<Void> put(@RequestBody @Valid Professor professor, Errors errors, @PathVariable Long id) {
		if (errors.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Corpo da requisição inválido.");
		}
		if (!this.professorRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não cadastrado");
		}
		this.professorRepository.save(professor);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (this.professorRepository.existsById(id)) {
			Professor professor = this.professorRepository.findById(id).get();
			if (professor.isEnabled()) {
				professor.setEnabled(false);
				this.professorRepository.save(professor);
				return ResponseEntity.noContent().build();
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
	}
}
