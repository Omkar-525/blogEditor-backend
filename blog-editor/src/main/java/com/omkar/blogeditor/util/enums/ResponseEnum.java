package com.omkar.blogeditor.util.enums;

public enum ResponseEnum {
    SUCCESS("200","SUCCESS"),

    FAILURE("400","FAILURE")
    ;

    private final String code;

    private final String message;

    ResponseEnum(String code,String message){
        this.code=code;
        this.message=message;
    }
    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }


}
