package com.ipersonal.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.ipersonal.model.Perfil;

@RepositoryRestController
public interface PerfilRepository extends PagingAndSortingRepository<Perfil, Long> {
	
	Optional<Perfil> findByUsuarioEmail(String email);
	
}
