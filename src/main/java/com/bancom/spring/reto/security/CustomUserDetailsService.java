package com.bancom.spring.reto.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bancom.spring.reto.model.Usuario;
import com.bancom.spring.reto.repository.UsuarioRepository;




@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByName(username).orElseThrow(
				() -> new UsernameNotFoundException("Usuario no encontrado con ese username :" + username));		
		
		
		return new User(usuario.getName(),usuario.getPassword(),getRolesDefault());
	}
		private List<GrantedAuthority> getRolesDefault(){
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			return authorities;
			 		
		
	}	
}
