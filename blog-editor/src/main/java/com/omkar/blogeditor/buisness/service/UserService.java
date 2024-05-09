package com.omkar.blogeditor.buisness.service;

import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.request.ChangePasswordRequest;
import com.omkar.blogeditor.infra.model.response.ProfileResponse;

public interface UserService {
    ProfileResponse getProfile(String authorizationHeader);

    BaseResponse changePassword(String authorizationHeader, ChangePasswordRequest request);
}
