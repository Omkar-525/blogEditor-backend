package com.omkar.blogeditor.buisness.controller;

import com.omkar.blogeditor.buisness.service.PostsService;
import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.request.SetPostRequest;
import com.omkar.blogeditor.infra.model.response.GetPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @PostMapping
    public BaseResponse setPost(@RequestHeader(value = "Authorization") String authorizationHeader,
                                @RequestBody SetPostRequest request){
        return postsService.setPost(authorizationHeader, request);
    }

    @GetMapping("/allposts")
    public GetPostResponse getPosts(@RequestHeader(value = "Authorization") String authorizationHeader) {
        return postsService.getPosts(authorizationHeader);
    }
}
