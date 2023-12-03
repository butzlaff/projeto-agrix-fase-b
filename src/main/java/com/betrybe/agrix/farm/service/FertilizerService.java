package com.betrybe.agrix.farm.service;

import com.betrybe.agrix.farm.entity.Fertilizer;
import com.betrybe.agrix.farm.repository.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for Fertilizar.
 */
@Service
public class FertilizerService {
  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Save a fertilizer.
   */
  public Fertilizer saveFertilizer(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }
}
