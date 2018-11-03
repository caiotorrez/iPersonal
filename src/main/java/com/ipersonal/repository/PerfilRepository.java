package com.ipersonal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.ipersonal.model.Perfil;

@RepositoryRestController
public interface PerfilRepository extends PagingAndSortingRepository<Perfil, Long> {
	
	
	
}
