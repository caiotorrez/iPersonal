package com.ipersonal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.ipersonal.model.Credenciais;

@RepositoryRestController
public interface CredenciaisRepository extends PagingAndSortingRepository<Credenciais, Long> {
	
	
	
}
