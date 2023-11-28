package com.betrybe.agrix.service.exceptions;

/**
 * Throws exception when farm is not found.
 */
public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
