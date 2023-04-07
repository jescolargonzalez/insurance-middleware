package com.tfm.aseguradora.backend.middle.controller;

import com.tfm.aseguradora.backend.middle.service.exception.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.context.request.*;

import java.time.*;

import com.tfm.aseguradora.backend.generated.middle.controller.ErrorMessageControllerDto;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessageControllerDto resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessageControllerDto message = new ErrorMessageControllerDto();
        message.setStatusCode(HttpStatus.NOT_FOUND.value());
        message.setTimestamp(OffsetDateTime.now());
        message.setMessage("Entity not found");
        message.setDescription("Entity " + ex.getResourceClass() + "  with id " + ex.getResourceIdentifier() + " not found");
        return message;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessageControllerDto badRequestException(BadRequestException ex, WebRequest request) {
        ErrorMessageControllerDto message = new ErrorMessageControllerDto();
        message.setStatusCode(HttpStatus.BAD_REQUEST.value());
        message.setTimestamp(OffsetDateTime.now());
        message.setMessage("Bad Request: some parameter are wrong");
        message.setDescription(ex.getMessage());
        return message;
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessageControllerDto httpClientException(HttpClientErrorException.Forbidden ex, WebRequest request) {
        ErrorMessageControllerDto message = new ErrorMessageControllerDto();
        message.setStatusCode(HttpStatus.FORBIDDEN.value());
        message.setTimestamp(OffsetDateTime.now());
        message.setMessage("Forbidden call to external endpoint");
        message.setDescription(ex.getMessage());
        return message;
    }

}