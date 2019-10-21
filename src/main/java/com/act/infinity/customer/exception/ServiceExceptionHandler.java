package com.act.infinity.customer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
@Slf4j
public class ServiceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public final ResponseEntity handleNotFountExceptions(Exception ex) {

    log.error("Exception: {}", ex.getMessage());
    return new ResponseEntity("", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(GrpcException.class)
  public final ResponseEntity handleGrpcExceptions(Exception ex) {

    log.error("Exception: {}", ex.getMessage());
    return new ResponseEntity("", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
