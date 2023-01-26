package com.security.demo.controller;

import com.security.demo.model.Post;
import com.security.demo.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public Iterable<Post> findAll() {
        return this.postRepository.findAll();
    }

    @PostMapping("/{id}")
    public Post findById(@PathVariable("id") Long postId) {
        Optional<Post> postOptional = this.postRepository.findById(postId);
        return postOptional.orElseThrow(() -> new RuntimeException());
    }


}
