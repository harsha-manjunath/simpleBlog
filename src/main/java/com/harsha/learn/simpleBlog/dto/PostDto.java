package com.harsha.learn.simpleBlog.dto;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.harsha.learn.simpleBlog.domain.Post;

/**
@Author: Harsha.K.M
@EMail: harshakm66@gmail.com
*/

public interface PostDto extends JpaRepository<Post, Long>{

	Optional<Post> findById(Long Id);
	
	Page<Post> findAllByOrderByCreationTimeStampDesc(Pageable pageable);
	
	void deleteById(Long postId);
	
}

