package com.omkar.blogeditor.buisness.service;

import com.omkar.blogeditor.infra.model.response.ProfileResponse;

public interface UserService {
    ProfileResponse getProfile(String authorizationHeader);
}
