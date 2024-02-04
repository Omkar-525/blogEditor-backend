package com.omkar.blogeditor.util.response_builders;

import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.util.enums.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BaseFailure {

    public BaseResponse baseFailResponse(String description){
        var baseResponse= new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        baseResponse.setResponseCode(ResponseEnum.FAILURE.getCode());
        baseResponse.setStatus(ResponseEnum.FAILURE.getMessage());
        baseResponse.setResponseDescription(description);
        return baseResponse;
    }
}
