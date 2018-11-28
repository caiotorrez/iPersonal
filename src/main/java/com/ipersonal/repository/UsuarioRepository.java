package com.ipersonal.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.ipersonal.model.Usuario;

@RepositoryRestController
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
	boolean existsByEmail(String email);
	boolean existsByEmailAndEnabledTrue(String email);

	Usuario findByIdToEnable(String idToEnable);

	boolean existsByChangePasswordId(String changePasswordId);

	Optional<Usuario> findByChangePasswordId(String changePasswordId);

}
