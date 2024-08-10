package com.springredditclone.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springredditclone.model.PostRequest;
import com.springredditclone.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	static List<PostRequest> postRequests = new ArrayList<PostRequest>();
	static {
		postRequests.add(new PostRequest(123l,"developersIndia","First Post","https://developersIndia","this is my first post"));
		postRequests.add(new PostRequest(124l,"Gaming","Gaming related Post","https://Gaming","this is gaming post"));
		postRequests.add(new PostRequest(125l,"TechTrends","Trending Post","https://TechTrends","this is trending post"));
		
	}
	
	public List<PostRequest> getAllPosts() {
		// TODO Auto-generated method stub
		return postRequests;
	}

	@Override
	public PostRequest createPost(PostRequest newPostRequest) {
		// TODO Auto-generated method stub
		postRequests.add(newPostRequest);
		return newPostRequest;
	}

	@Override
	public PostRequest getPost(long id) {
		// TODO Auto-generated method stub
		for(int i=0;i<postRequests.size();i++) {
			if(postRequests.get(i).getPostId() == id) {
				return postRequests.get(i);
			}
		}
		return null;
	}

	@Override
	public List<PostRequest> getPostBySubreddit(String subRedditName) {
		// TODO Auto-generated method stub
		List<PostRequest> newPostResponseBysubreddit = new ArrayList<PostRequest>();
		for(int i=0;i<postRequests.size();i++) {
			if(postRequests.get(i).getSubRedditName().equals(subRedditName)) {
				newPostResponseBysubreddit.add(postRequests.get(i));
			}
		}
		return newPostResponseBysubreddit;
	}

	@Override
	public void getPostByUsername() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PostRequest updatePost(long id,PostRequest updatedPostRequest) {
		// TODO Auto-generated method stub
		for(int i = 0;i<postRequests.size(); i++) {
			if(postRequests.get(i).getPostId() == id) {
				postRequests.remove(i);
				postRequests.add(updatedPostRequest);
			}
		}
		return updatedPostRequest;
	}

	@Override
	public PostRequest deletePost(long id) { // 127
		// TODO Auto-generated method stub
		PostRequest deletedPostRequest = new PostRequest();
		for(int i=0;i<postRequests.size();i++) {
			if(postRequests.get(i).getPostId() == id) {  
				deletedPostRequest = postRequests.get(i); 
				postRequests.remove(i);
			}
		}
		return deletedPostRequest; 
	}

}
