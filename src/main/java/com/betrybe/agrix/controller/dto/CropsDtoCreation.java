package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Crops;

/**
 * Crops Dto to creation.
 */
public record CropsDtoCreation(String name, Double plantedArea) {
  /**
   * Generates an instance of the Crops entity without the associated Farm.
   *
   * @return          an instance of the Crops entity without the associated Farm.
   */
  public Crops toEntityWithoutFarm() {
    Crops crops = new Crops();
    crops.setName(name);
    crops.setPlantedArea(plantedArea);
    return crops;
  }
} 