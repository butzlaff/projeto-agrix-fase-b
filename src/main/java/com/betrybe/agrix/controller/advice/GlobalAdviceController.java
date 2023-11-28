package com.betrybe.agrix.controller.advice;

import com.betrybe.agrix.service.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller adivce.
 */
@ControllerAdvice
public class GlobalAdviceController {
  /**
  * Generate errors with status 404.
  */
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handleNotFound(NotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(
            exception.getMessage()
        );
  }
}
