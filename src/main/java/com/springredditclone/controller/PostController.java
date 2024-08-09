package com.springredditclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springredditclone.model.PostRequest;
import com.springredditclone.serviceImpl.PostServiceImpl;

@RestController
@RequestMapping("/api/posts")
	// i am editing this file to commit changes
public class PostController {

	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@GetMapping("/getAllPosts")
	public List<PostRequest> getAllPosts(){
		return postServiceImpl.getAllPosts();
	}
	
	@PostMapping("/createPost")
	public PostRequest createPost(@RequestBody PostRequest postRequest){
		return postServiceImpl.createPost(postRequest);
	}
	
	@GetMapping(params = "subRedditName")
	public List<PostRequest> getPostsBySubRedditName(@RequestParam String subRedditName) {
		return postServiceImpl.getPostBySubreddit(subRedditName);
	}
	
	@GetMapping("/{id}")
	public PostRequest getPost(@PathVariable long id) {
		return postServiceImpl.getPost(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public PostRequest deletePost(@PathVariable long id) {
		return postServiceImpl.deletePost(id);
	}
	
	@PutMapping("/{id}")
	public PostRequest updatePost(@PathVariable long id, @RequestBody PostRequest postRequest) {
		return postServiceImpl.updatePost(id,postRequest);
	}
}
