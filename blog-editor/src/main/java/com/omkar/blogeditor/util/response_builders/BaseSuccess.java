package com.omkar.blogeditor.util.response_builders;

import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.util.enums.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BaseSuccess {

    public BaseResponse baseSuccessResponse(String description){
        var baseResponse = new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setResponseCode(ResponseEnum.SUCCESS.getCode());
        baseResponse.setStatus(ResponseEnum.SUCCESS.getMessage());
        baseResponse.setResponseDescription(description);
        return baseResponse;
    }
}
