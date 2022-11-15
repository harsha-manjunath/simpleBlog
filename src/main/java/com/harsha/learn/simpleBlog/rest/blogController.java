package com.harsha.learn.simpleBlog.rest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.harsha.learn.simpleBlog.domain.Post;
import com.harsha.learn.simpleBlog.dto.PostDto;

@RestController


public class blogController implements BlogApis{

	@Autowired
	PostDto postDto;
	
	@Override
		 public ResponseEntity<Page<Post>> getCatalogue(Pageable pageable) {
		
		        Page<Post> posts = postDto.findAllByOrderByCreationTimeStampDesc(pageable);
		        //Page<PostDto> postDto = posts.map(post -> new PostDto((post)));
		        return ResponseEntity.ok().body(posts); //(posts.getContent(), HttpStatus.OK);
		    }

	@Override
	public ResponseEntity<Object> getBlog(Long blogId) {
		// TODO Auto-generated method stub
		Optional<Post> post = postDto.findById(blogId);
		return ResponseEntity.ok().body(post);
	}

	@Override
	public ResponseEntity<Object> createBlog(Post post) {
		
		//post.setPostId((long) 1);
		//post.set
		Post post1 = new Post();
		
		post1.setBody(post.getBody());
		post1.setTitle(post.getTitle());
		Post response = postDto.save(post1);
		// TODO Auto-generated method stub
		 return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Object> deletePost(Long postId) {
		
		System.out.println("postId for delete is "+postId);
		postDto.deleteById(postId);
		// TODO Auto-generated method stub
		return ResponseEntity.ok("Post successfully deleted");
	}
	
	@Override
	public ResponseEntity<Object> updatePost(Post post, Long postId){
		
		Optional<Post> postFromDb = postDto.findById(postId);
		
		postFromDb.get().setBody(post.getBody());
		postFromDb.get().setTitle(post.getTitle());
		postFromDb.get().setUpdatedTimeStamp(LocalDateTime.now());
		
		Post response = postDto.save(postFromDb.get());	
		
		return ResponseEntity.ok().body(response);
		
	}

  
	
}
