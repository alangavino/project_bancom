package com.bancom.spring.reto.service;

import com.bancom.spring.reto.dto.LoginRequestDTO;
import com.bancom.spring.reto.dto.LoginResponseDTO;

public interface LoginService {

	LoginResponseDTO authToken(LoginRequestDTO request);
}
