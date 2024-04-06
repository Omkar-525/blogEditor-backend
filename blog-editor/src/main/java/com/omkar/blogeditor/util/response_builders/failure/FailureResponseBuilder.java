package com.omkar.blogeditor.util.response_builders.failure;

import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.response.GetPostResponse;
import com.omkar.blogeditor.infra.model.response.LoginResponse;
import com.omkar.blogeditor.infra.model.response.ProfileResponse;
import com.omkar.blogeditor.util.response_builders.BaseFailure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FailureResponseBuilder {

    @Autowired
    private BaseFailure baseFailure;

    public LoginResponse loginFailed(String description) {
        BaseResponse baseResponse = baseFailure.baseFailResponse(description);
        return LoginResponse.builder()
                .status(baseResponse.getStatus())
                .responseDescription(baseResponse.getResponseDescription())
                .responseCode(baseResponse.getResponseCode())
                .httpStatus(baseResponse.getHttpStatus())
                .build();
    }

    public GetPostResponse getPosts(String description) {
        BaseResponse baseResponse = baseFailure.baseFailResponse(description);
        return  GetPostResponse.builder()
                .status(baseResponse.getStatus())
                .responseDescription(baseResponse.getResponseDescription())
                .responseCode(baseResponse.getResponseCode())
                .httpStatus(baseResponse.getHttpStatus())
                .build();
    }

    public ProfileResponse getUser(String description) {
        BaseResponse baseResponse = baseFailure.baseFailResponse(description);
        return ProfileResponse.builder()
                .status(baseResponse.getStatus())
                .responseDescription(baseResponse.getResponseDescription())
                .responseCode(baseResponse.getResponseCode())
                .httpStatus(baseResponse.getHttpStatus())
                .build();
    }
}
