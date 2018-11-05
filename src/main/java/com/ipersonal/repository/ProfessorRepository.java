package com.ipersonal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.ipersonal.model.Professor;

@RepositoryRestController
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Long> {
	
	List<Professor> findAllByUsuarioPerfilPrimeiroNomeStartingWithAndEnabledIsTrue(String nome);

	Optional<Professor> findByUsuarioEmail(String email);
}
