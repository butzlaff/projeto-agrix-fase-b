package com.betrybe.agrix.service.exceptions;

/**
 * Throws exception when farm is not found.
 */
public abstract class NotFoundException extends Exception {
  public NotFoundException(String message) {
    super(message);
  }
}
