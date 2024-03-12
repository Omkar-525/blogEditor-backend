package com.omkar.blogeditor.util.response_builders.success;

import com.omkar.blogeditor.infra.entity.Posts;
import com.omkar.blogeditor.infra.entity.User;
import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.PostDTO;
import com.omkar.blogeditor.infra.model.response.GetPostResponse;
import com.omkar.blogeditor.infra.model.response.LoginResponse;
import com.omkar.blogeditor.infra.model.response.ProfileResponse;
import com.omkar.blogeditor.util.response_builders.BaseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SuccessResponseBuilder {

    @Autowired
    private BaseSuccess baseSuccess;

    public LoginResponse loginSuccess(String jwt, User user) {
        BaseResponse baseResponse =baseSuccess.baseSuccessResponse("Login Successful");
            return LoginResponse.builder()
                    .status(baseResponse.getStatus())
                    .responseDescription(baseResponse.getResponseDescription())
                    .responseCode(baseResponse.getResponseCode())
                    .httpStatus(baseResponse.getHttpStatus())
                    .jwt(jwt)
                    .user(user)
                    .build();
        }

    public GetPostResponse getPosts(List<Posts> posts) {
        BaseResponse baseResponse = baseSuccess.baseSuccessResponse("Post Success");
        return GetPostResponse.builder()
                .status(baseResponse.getStatus())
                .responseDescription(baseResponse.getResponseDescription())
                .responseCode(baseResponse.getResponseCode())
                .httpStatus(baseResponse.getHttpStatus())
                .posts(posts.stream().map(PostDTO:: new).collect(Collectors.toList()))
                .build();

    }

    public ProfileResponse getUser(User user) {
        BaseResponse baseResponse = baseSuccess.baseSuccessResponse("User found");
        return ProfileResponse.builder()
                .status(baseResponse.getStatus())
                .responseDescription(baseResponse.getResponseDescription())
                .responseCode(baseResponse.getResponseCode())
                .httpStatus(baseResponse.getHttpStatus())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
