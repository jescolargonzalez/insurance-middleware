package com.tfm.aseguradora.backend.middle.service.exception;

import lombok.*;

@Data
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}