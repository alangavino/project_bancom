package com.bancom.spring.reto.service.impl;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bancom.spring.reto.dto.UsuarioRequestDTO;
import com.bancom.spring.reto.exception.ResourceNotFoundException;
import com.bancom.spring.reto.model.Usuario;
import com.bancom.spring.reto.repository.UsuarioRepository;
import com.bancom.spring.reto.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder   passwordEncoder;
	@Override
	public List<Usuario> findAllUsuarios() {

			return usuarioRepository.findAll();
	}

	@Override
	public Usuario findUsuarioById(long id) {
		
		return usuarioRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Usuario with id = " + id));
		
	}
	@Override
	public Usuario createUsuario(UsuarioRequestDTO usuario) {

		Usuario usuarioEntity= new Usuario();

		usuarioEntity.setCellphone(usuario.getCellphone());
		usuarioEntity.setName(usuario.getName());
		usuarioEntity.setLastName(usuario.getLastName());
		usuarioEntity.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioEntity.setCreationDate(Instant.now());	
		
		return usuarioRepository.save(usuarioEntity);
	}

	@Override
	public Usuario updateUsuario(long id, UsuarioRequestDTO usuario) {
		
		Usuario usuarioEntity=usuarioRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Usuario with id = " + id));
		
		usuarioEntity.setCellphone(usuario.getCellphone());
		usuarioEntity.setName(usuario.getName());
		usuarioEntity.setLastName(usuario.getLastName());
		usuarioEntity.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioEntity.setModificationDate(Instant.now());	
		
		return  usuarioRepository.save(usuarioEntity);
	}

	@Override
	public void deleteUsuarioById(long id) {
		
	
		 if (!usuarioRepository.existsById(id)) {
		      throw new ResourceNotFoundException("Not found Usuario with id = " + id);
		    }
		
		
		usuarioRepository.deleteById(id);
		
	}



}
