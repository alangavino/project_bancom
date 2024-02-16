package com.bancom.spring.reto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bancom.spring.reto.dto.LoginRequestDTO;
import com.bancom.spring.reto.dto.LoginResponseDTO;
import com.bancom.spring.reto.security.JwtTokenProvider;
import com.bancom.spring.reto.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider   jwtTokenProvider;
	
	@Override
	public LoginResponseDTO authToken(LoginRequestDTO request) {
		
		Authentication authenticaion= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authenticaion);
		
		String token=jwtTokenProvider.generarToken(authenticaion);
		
		return new LoginResponseDTO(token);
	}

}
