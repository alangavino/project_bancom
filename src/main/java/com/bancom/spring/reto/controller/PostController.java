package com.bancom.spring.reto.controller;

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

import com.bancom.spring.reto.dto.PostRequestDTO;
import com.bancom.spring.reto.model.Post;
import com.bancom.spring.reto.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	PostService postService;

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long id) {

		return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
	}

	@GetMapping("/usuarios/{usuarioId}/posts")
	public ResponseEntity<List<Post>> getPostsByUsuarioId(@PathVariable(value = "usuarioId") Long usuarioId) {

		return new ResponseEntity<>(postService.findPostsByUsuarioId(usuarioId), HttpStatus.OK);
	}

	@PostMapping("/usuarios/{usuarioId}/posts")
	public ResponseEntity<Post> createPost(@PathVariable(value = "usuarioId") long usuarioId,
			@RequestBody PostRequestDTO postRequestDTO) {

		return new ResponseEntity<>(postService.createPost(usuarioId, postRequestDTO), HttpStatus.CREATED);

	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable(value = "id") long id,
			@RequestBody PostRequestDTO postRequestDTO) {

		if (postService.updatePost(id, postRequestDTO) == null) {

			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<>(postService.updatePost(id, postRequestDTO), HttpStatus.OK);

	}

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {

		postService.deletePostById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/usuarios/{usuarioId}/posts")
	public ResponseEntity<HttpStatus> deleteAllPostByUsuarioId(@PathVariable(value = "usuarioId") long usuarioId) {

		postService.deleteAllPostByUsuarioId(usuarioId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}