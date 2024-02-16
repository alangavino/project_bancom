package com.bancom.spring.reto.service;

import java.util.List;

import com.bancom.spring.reto.dto.PostRequestDTO;
import com.bancom.spring.reto.model.Post;

public interface PostService {


	Post  findPostById(long id);	
	
	List<Post> findPostsByUsuarioId(long usuarioId);
	
	Post createPost(long usuarioId, PostRequestDTO postRequestDTO);
	
	Post updatePost(long id, PostRequestDTO postRequestDTO);
	
	void  deletePostById(long id);
	
	void  deleteAllPostByUsuarioId(long usuarioId);


}
