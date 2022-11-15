package com.harsha.learn.simpleBlog.rest;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.harsha.learn.simpleBlog.domain.Post;

@RequestMapping("/v1")
public interface BlogApis {

	@GetMapping(value = "/read/{postId}")
	ResponseEntity<Object> getBlog(@PathVariable("postId") Long postId);
	
	@PostMapping(value = "/write/create", consumes = "application/json")
	ResponseEntity<Object> createBlog(@RequestBody Post posts);

	@GetMapping(value = "/read")
	ResponseEntity<Page<Post>> getCatalogue(Pageable pageable);
	
	@DeleteMapping(value = "/delete/{postId}")
	ResponseEntity<Object> deletePost(@PathVariable Long postId);

	@PutMapping(value = "write/{postId}")
	ResponseEntity<Object> updatePost(@RequestBody Post post,@PathVariable Long postId);
}
