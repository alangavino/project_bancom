package  com.bancom.spring.reto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancom.spring.reto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByName(String username);


}
