package com.bancom.spring.reto.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancom.spring.reto.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUsuarioId(Long usuarioId);

	@Transactional
	void deletePostsByUsuarioId(Long usuarioId);
}
