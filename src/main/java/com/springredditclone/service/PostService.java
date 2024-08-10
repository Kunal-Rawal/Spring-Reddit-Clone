package com.springredditclone.service;

import java.util.List;

import com.springredditclone.model.PostRequest;

public interface PostService {

	PostRequest createPost(PostRequest postRequest);
	List<PostRequest> getAllPosts();
	PostRequest getPost(long id);
	List<PostRequest> getPostBySubreddit(String subRedditName);
	void getPostByUsername();
	PostRequest updatePost(long id, PostRequest postRequest);
	PostRequest deletePost(long id);
}
