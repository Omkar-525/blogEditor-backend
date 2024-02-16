package com.omkar.blogeditor.buisness.service;

import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.request.LoginRequest;
import com.omkar.blogeditor.infra.model.request.RegisterRequest;
import com.omkar.blogeditor.infra.model.response.LoginResponse;

public interface IndexService {
    BaseResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
