package com.qdb.dms.integration.postintegrationservice.controllers;

import com.qdb.dms.integration.postintegrationservice.entities.Post;
import com.qdb.dms.integration.postintegrationservice.services.IntegrationService;
import com.qdb.dms.integration.postintegrationservice.services.PostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private static final Logger logger = LogManager.getLogger(PostController.class);

    @Autowired
    PostService postService;

    @Autowired
    IntegrationService integrationService;

    @PostMapping("/createPost")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<?> updatePost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
    }

    @DeleteMapping("/deletePost")
    public ResponseEntity<?> deletePost(@RequestParam Long id) {
        String result = postService.deletePost(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("viewPostByJsonClientId/{id}")
    public ResponseEntity<?> viewPost(@PathVariable String id) {
        return new ResponseEntity<>(postService.viewPostByJsonClientId(Long.parseLong(id)),HttpStatus.OK);
    }

    @GetMapping("viewAllPostsByDocumentId/{id}")
    public ResponseEntity<?> viewAllPostsByDocumentId(@PathVariable String id) {
        return new ResponseEntity<>(postService.viewPostByDocumentId(Long.parseLong(id)),HttpStatus.OK);
    }

    @GetMapping("/viewAllPosts")
    public ResponseEntity<?> viewAllPosts() {
        return new ResponseEntity<>(postService.viewAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/viewAllPostsByUserId/{id}")
    public ResponseEntity<?> viewAllPostsByUserId(@PathVariable String id) {
        return new ResponseEntity<>(postService.viewAllPostsByUserId(Long.parseLong(id)), HttpStatus.OK);
    }

    @GetMapping("/getDocument/{documentId}")
    public ResponseEntity<?> viewDocument(@PathVariable String documentId) {
        return new ResponseEntity<>(integrationService.viewDocument(Long.parseLong(documentId)), HttpStatus.OK);
    }

    @GetMapping("/getAllDocuments")
    public ResponseEntity<?> viewAllDocuments() {
        return new ResponseEntity<>(integrationService.viewAllDocuments(), HttpStatus.OK);
    }
}
