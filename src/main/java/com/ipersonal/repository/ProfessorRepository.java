package com.ipersonal.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.ipersonal.model.Professor;

@RepositoryRestController
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Long> {
	
	Optional<Professor> findByUsuarioEmail(String email);

	boolean existsByUsuarioEmail(String email);

}
