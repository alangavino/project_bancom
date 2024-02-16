package com.bancom.spring.reto.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.bancom.spring.reto.model.Usuario;
import com.bancom.spring.reto.service.UsuarioService;


@SpringBootTest 
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired 
    private MockMvc mockMvc;
    @MockBean
    private UsuarioService usuarioService;
    @Test
    public void getAllUsuariosError() throws Exception {
    	
    	 ResultActions actions =this.mockMvc.perform(get("/api/usuarios") 
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(StringUtils.EMPTY));

        actions.andExpect(status().is(204));
    }
    
    @Test
    public void getAllUsuarios_ok() throws Exception {
    	List<Usuario> usuarios= new ArrayList<Usuario>();
    	
    	Usuario usuario= new Usuario();
    	Mockito.when(usuarioService.findAllUsuarios()).thenReturn(usuarios);
    	usuarios.add(usuario);
    	 ResultActions actions =this.mockMvc.perform(get("/api/usuarios") 
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(StringUtils.EMPTY));

        actions.andExpect(status().is(200));
    }
}
