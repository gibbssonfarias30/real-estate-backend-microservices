package com.backfcdev.apigateway.exception.handler;

import com.backfcdev.apigateway.exception.ExistsUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;


@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ExistsUsernameException.class)
    ProblemDetail handleExistsUsernameException(ExistsUsernameException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, null);
        problemDetail.setTitle("That username already exists");
        problemDetail.setType(URI.create("/conflict"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
