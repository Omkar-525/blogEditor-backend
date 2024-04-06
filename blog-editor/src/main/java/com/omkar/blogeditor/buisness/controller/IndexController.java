package com.omkar.blogeditor.buisness.controller;

import com.omkar.blogeditor.buisness.service.IndexService;
import com.omkar.blogeditor.buisness.service.PostsService;
import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.request.LoginRequest;
import com.omkar.blogeditor.infra.model.request.RegisterRequest;
import com.omkar.blogeditor.infra.model.response.GetPostResponse;
import com.omkar.blogeditor.infra.model.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class IndexController {
    @Autowired
    private IndexService indexService;

    @Autowired
    private PostsService postsService;

    @PostMapping("/register")
    public BaseResponse register(@RequestBody RegisterRequest request) {return indexService.register(request);}

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {return indexService.login(request);}

    @GetMapping("/all_post")
    public GetPostResponse getAllPosts() {
        return postsService.getAllPosts();
    }
    @GetMapping("/{postId}")
    public GetPostResponse getPostId(@PathVariable Long postId){
        return postsService.getPostId(postId);
    }
}
