package com.ipersonal.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipersonal.model.Professor;

public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Long> {
	
	List<Professor> findAllByPerfilPrimeiroNomeStartingWithAndEnabledIsTrue(String nome);

}
