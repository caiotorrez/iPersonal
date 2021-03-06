package com.ipersonal.v1.endpoint;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ipersonal.model.Aluno;
import com.ipersonal.model.Usuario;
import com.ipersonal.repository.UsuarioRepository;
import com.ipersonal.v1.endpoint.dto.CadastroDTO;
import com.ipersonal.v1.endpoint.dto.ChangePasswordDTO;
import com.ipersonal.v1.endpoint.dto.EmailDTO;
import com.ipersonal.v1.endpoint.dto.UsuarioDTO;
import com.ipersonal.v1.endpoint.dto.ValidationRegisterDTO;
import com.ipersonal.v1.endpoint.service.CadastroService;

@RequestMapping
@RestController
public class CadastroEndpoint implements Serializable {
	private static final long serialVersionUID = 1L;

	private CadastroService alunoService;
	private UsuarioRepository usuarioRepository;

	@Autowired
	public CadastroEndpoint(CadastroService alunoService, UsuarioRepository usuarioRepository) {
		this.alunoService = alunoService;
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping("checkout/email")
	public ResponseEntity<EmailDTO> checkoutEmail(@RequestBody @Valid EmailDTO email, Errors errors) {
		if (email == null || email.getEmail() == null || !this.usuarioRepository.existsByEmail(email.getEmail())
				|| errors.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok(email);
	}

	@PostMapping("cadastro")
	public ResponseEntity<Void> save(@RequestBody @Valid CadastroDTO cadastro, Errors errors) {
		if (errors.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Corpo da requisição inválido.");
		}
		if (this.usuarioRepository.existsByEmail(cadastro.getUsuario().getEmail())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado");
		}
		Aluno aluno = this.alunoService.register(cadastro);
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(aluno.getId()).toUri())
				.build();
	}

	@PostMapping("validation")
	public ResponseEntity<ValidationRegisterDTO> validationRegister(@RequestBody @Valid
			ValidationRegisterDTO validation, Errors errors) {
		if (errors.hasErrors() || validation == null || validation.getIdToEnable() == null || !this.usuarioRepository.existsByIdToEnable(validation.getIdToEnable())) {
			ResponseEntity.ok(null);
		}
		Usuario user = this.usuarioRepository.findByIdToEnable(validation.getIdToEnable());
		if (user != null) {
			user.setEnabled(true);
			user.setIdToEnable(null);
			this.usuarioRepository.save(user);
			return ResponseEntity.ok(validation);
		}
		return ResponseEntity.ok(null);
	}

	@PostMapping("forgot-password")
	public ResponseEntity<UsuarioDTO> forgotenPassword(@RequestBody @Valid UsuarioDTO usuario, Errors errors) {
		if (!this.usuarioRepository.existsByEmailAndEnabledTrue(usuario.getEmail())) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok(this.alunoService.recoveryPassword(usuario));
	}

	@PostMapping("checkout/password")
	public ResponseEntity<@Valid ChangePasswordDTO> checkoutPassword(@RequestBody @Valid ChangePasswordDTO validation, Errors errors) {
		if (errors.hasErrors() || validation == null || validation.getChangePasswordId() == null || 
				!this.usuarioRepository.existsByChangePasswordId(validation.getChangePasswordId())) {
			return ResponseEntity.ok(null);
		}
		// Se por opção quiser invalidar a URL o lugar é aqui
		return ResponseEntity.ok(validation);
	}

	@PostMapping("change-password")
	public ResponseEntity<ChangePasswordDTO> changePassword(@RequestBody @Valid ChangePasswordDTO validation, Errors errors) {
		if (errors.hasErrors() || validation == null || validation.getChangePasswordId() == null || 
				!this.usuarioRepository.existsByChangePasswordId(validation.getChangePasswordId())) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok(this.alunoService.changePassword(validation));
	}

}
