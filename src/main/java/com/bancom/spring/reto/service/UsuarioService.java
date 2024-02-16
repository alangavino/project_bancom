package com.bancom.spring.reto.service;

import java.util.List;

import com.bancom.spring.reto.dto.UsuarioRequestDTO;
import com.bancom.spring.reto.model.Usuario;

public interface UsuarioService {

	List<Usuario> findAllUsuarios();
	
	Usuario  findUsuarioById(long id);
	
	Usuario  createUsuario(UsuarioRequestDTO usuario);
	
	Usuario  updateUsuario(long id,UsuarioRequestDTO usuario);
	
	void  deleteUsuarioById(long id);
}
