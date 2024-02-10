package com.omkar.blogeditor.infra.exception;

public class InvalidJwtException extends RuntimeException{
    public InvalidJwtException(String message) {super(message);}
}
