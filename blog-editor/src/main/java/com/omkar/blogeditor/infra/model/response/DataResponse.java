package com.omkar.blogeditor.infra.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omkar.blogeditor.infra.model.BaseResponse;
import org.springframework.http.HttpStatus;

public class DataResponse<T> extends BaseResponse {

    @JsonProperty("data")
    private T data;

    public DataResponse(HttpStatus httpStatus, String status, String responseCode, String responseDescription, T data){
        super(httpStatus, status, responseCode, responseDescription);
        this.data = data;
    }
}
