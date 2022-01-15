package com.udemy.minhasfinancas.service;

import java.util.Optional;

import com.udemy.minhasfinancas.model.entity.Usuario;

public interface UsuarioService {

	void validarEmail(String email);

	Usuario autenticar(String email, String senha);

	Usuario salvarUsuario(Usuario usuario);

	Optional<Usuario> obterPeloId(Long id);
	
}
