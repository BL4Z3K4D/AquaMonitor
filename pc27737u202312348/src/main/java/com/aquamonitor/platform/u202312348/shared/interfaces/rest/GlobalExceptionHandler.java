package com.aquamonitor.platform.u202312348.shared.interfaces.rest;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.resources.ErrorResource;

/** Converts request and unexpected failures to the API error contract. @author Yazid Said */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final LocalizedMessages messages;

    public GlobalExceptionHandler(LocalizedMessages messages) {
        this.messages = messages;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResource> invalidArgument(IllegalArgumentException exception, Locale locale) {
        return ResponseEntity.badRequest()
            .body(new ErrorResource(messages.get("request.invalid", locale)));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResource> unreadableRequest(HttpMessageNotReadableException exception, Locale locale) {
        return ResponseEntity.badRequest()
            .body(new ErrorResource(messages.get("request.invalid", locale)));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResource> unexpected(Exception exception, Locale locale) {
        LOGGER.error("Unexpected API error", exception);
        return ResponseEntity.internalServerError()
            .body(new ErrorResource(messages.get("error.internal", locale)));
    }
}
