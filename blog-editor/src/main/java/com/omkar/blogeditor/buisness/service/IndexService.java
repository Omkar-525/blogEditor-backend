package com.omkar.blogeditor.buisness.service;

import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.request.RegisterRequest;

public interface IndexService {
    BaseResponse register(RegisterRequest request);
}
