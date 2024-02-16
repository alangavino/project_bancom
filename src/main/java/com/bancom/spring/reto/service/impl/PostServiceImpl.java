package com.bancom.spring.reto.service.impl;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancom.spring.reto.dto.PostRequestDTO;
import com.bancom.spring.reto.exception.ResourceNotFoundException;
import com.bancom.spring.reto.model.Post;
import com.bancom.spring.reto.model.Usuario;
import com.bancom.spring.reto.repository.PostRepository;
import com.bancom.spring.reto.repository.UsuarioRepository;
import com.bancom.spring.reto.service.PostService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository postRepository;	

	@Autowired
	UsuarioRepository usuarioRepository;


	@Override
	public Post findPostById(long id) {
	
		return postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Post with id = " + id));
	}
	
	
	@Override
	public List<Post> findPostsByUsuarioId(long usuarioId) {
		
		 if (!usuarioRepository.existsById(usuarioId)) {
		      throw new ResourceNotFoundException("Not found Usuario with id = " + usuarioId);
		    }
		
		 
		return postRepository.findByUsuarioId(usuarioId);
	}
	
	
	
	@Override
	public Post createPost(long usuarioId, PostRequestDTO postRequestDTO) {
		Post post= new Post();
		post.setText(postRequestDTO.getText());
		post.setCreationDate(Instant.now());
		
		return usuarioRepository.findById(usuarioId).map(usuario ->{			
			post.setUsuario(usuario);
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("Not found Usuario with id = " + usuarioId));
			
		
	}


	@Override
	public Post updatePost(long id, PostRequestDTO postRequestDTO) {
		
		
		Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
	
		
		Usuario usuario=usuarioRepository.findByName(authentication.getName())
		.orElseThrow(() -> new ResourceNotFoundException("Not found Usuario with name= " + authentication.getName()));
		
		List<Post> postsUsuario=postRepository.findByUsuarioId(usuario.getId());

			for(Post postEntity:postsUsuario) {
			
				if(postEntity.getId().equals(id)) {
							
					postEntity.setText(postRequestDTO.getText());
					postEntity.setModificationDate(Instant.now());
					return postRepository.save(postEntity);
				}
			}		
				
		return null;
	}


	@Override
	public void deletePostById(long id) {

		 if (!postRepository.existsById(id)) {
		      throw new ResourceNotFoundException("Not found Post with id = " + id);
		    }
		
		 postRepository.deleteById(id);
	}


	@Override
	public void deleteAllPostByUsuarioId(long usuarioId) {
	
		 if (!usuarioRepository.existsById(usuarioId)) {
		      throw new ResourceNotFoundException("Not found Usuario with id = " + usuarioId);
		    }

		 postRepository.deletePostsByUsuarioId(usuarioId);
		 
	}








}
