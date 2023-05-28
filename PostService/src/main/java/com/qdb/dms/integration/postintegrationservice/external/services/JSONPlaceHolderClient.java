package com.qdb.dms.integration.postintegrationservice.external.services;

import com.qdb.dms.integration.postintegrationservice.entities.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "http://jsonplaceholder.typicode.com/")
public interface JSONPlaceHolderClient {

    @RequestMapping(method = RequestMethod.POST, value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    Post createPost(@RequestBody Post post);

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Post updatePost(@RequestBody Post post, @PathVariable("postId") Long postId);

    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/{postId}")
    String deletePost(@PathVariable("postId") Long postId);


    @RequestMapping(method = RequestMethod.GET, value = "/posts", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Post> getPosts();

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    Post getPostById(@PathVariable("postId") Long postId);
}
