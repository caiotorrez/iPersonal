package com.ipersonal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.ipersonal.model.Usuario;

@RepositoryRestController
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	Usuario findByEmail(String email);

}
