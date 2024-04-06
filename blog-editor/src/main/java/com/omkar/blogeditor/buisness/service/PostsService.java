package com.omkar.blogeditor.buisness.service;

import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.request.SetPostRequest;
import com.omkar.blogeditor.infra.model.response.GetPostResponse;

public interface PostsService {
    BaseResponse setPost(String authorizationHeader, SetPostRequest request);

    GetPostResponse getPosts(String authorizationHeader);

    GetPostResponse getAllPosts();

    GetPostResponse getPostId(Long postId);
}
