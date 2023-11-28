package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Crops;

/**
 * Record CropsDto.
 */
public record CropsDto(Long id, String name, Double plantedArea, Long farmId) {
  /**
   * Transform a Crops into a CropsDto.
   */
  public static CropsDto fromEntity(Crops crops) {
    return new CropsDto(
      crops.getId(),
      crops.getName(),
      crops.getPlantedArea(),
      crops.getFarm().getId()
    );
  }

  /**
   * Transform a CropsDto into a Crops.
   * 
  */
  public Crops toEntity() {
    Crops crops = new Crops();
    crops.setName(name);
    crops.setPlantedArea(plantedArea);
    return crops;
  }

}