package com.bancom.spring.reto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancom.spring.reto.dto.LoginRequestDTO;
import com.bancom.spring.reto.dto.LoginResponseDTO;
import com.bancom.spring.reto.service.LoginService;


@RestController
@RequestMapping("/api/auth")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/iniciarSesion")
	public ResponseEntity<LoginResponseDTO> authToken(@RequestBody LoginRequestDTO request){

		return ResponseEntity.ok(loginService.authToken(request));
}
}