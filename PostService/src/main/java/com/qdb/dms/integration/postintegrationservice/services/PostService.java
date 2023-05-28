package com.qdb.dms.integration.postintegrationservice.services;

import com.qdb.dms.integration.postintegrationservice.entities.Post;
import com.qdb.dms.integration.postintegrationservice.external.services.JSONPlaceHolderClient;
import com.qdb.dms.integration.postintegrationservice.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {

    @Autowired
    JSONPlaceHolderClient jsonPlaceHolderClient;

    @Autowired
    PostRepo postRepo;

    public Post createPost(Post post) {
        if(jsonPlaceHolderClient.createPost(post) != null) {
            postRepo.save(post);
            return post;
        } else{
            return new Post();
        }
    }

    public Post updatePost(Post post) {
        if(jsonPlaceHolderClient.updatePost(post, post.getId()) != null) {
            return post;
        } else{
            return new Post();
        }
    }

    public String deletePost(Long id) {
        if(jsonPlaceHolderClient.deletePost(id) != null) {
            return "Post has been created!";
        } else{
            return "Error while creating Post!";
        }
    }

    public Post viewPost(Long id) {
        return jsonPlaceHolderClient.getPostById(id);
    }

    public List<Post> viewAllPosts() {
        return jsonPlaceHolderClient.getPosts();
    }

    public List<Post> viewAllPostsByUserId(long id) {
        return postRepo.findAllByUserId(id);
    }
}
