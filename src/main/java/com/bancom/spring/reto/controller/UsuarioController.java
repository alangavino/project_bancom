package  com.bancom.spring.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancom.spring.reto.dto.UsuarioRequestDTO;
import com.bancom.spring.reto.model.Usuario;
import com.bancom.spring.reto.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getAllUsuarios() {

		List<Usuario> usuarios = usuarioService.findAllUsuarios();

		if (usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(usuarios, HttpStatus.OK);

	}
	 
	  @GetMapping("/usuarios/{id}")
	  public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") long id) {
		  Usuario usuario=usuarioService.findUsuarioById(id);
		  
		    return new ResponseEntity<>(usuario, HttpStatus.OK);
	  }
	
	  @PostMapping("/usuarios")
	  public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioRequestDTO usuario) {
	
	    return new ResponseEntity<>(usuarioService.createUsuario(usuario), HttpStatus.CREATED);
	  }

	  @PutMapping("/usuarios/{id}")
	  public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") long id,@RequestBody UsuarioRequestDTO usuario) {
		  
		  return new ResponseEntity<>(usuarioService.updateUsuario(id,usuario), HttpStatus.OK);	  
		}
	 
	  @DeleteMapping("/usuarios/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
	   
		  usuarioService.deleteUsuarioById(id); 
		  
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
}
