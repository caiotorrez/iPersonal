package com.ipersonal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.ipersonal.model.Aluno;

@RepositoryRestController
public interface AlunoRepository extends PagingAndSortingRepository<Aluno, Long> {
	
}
