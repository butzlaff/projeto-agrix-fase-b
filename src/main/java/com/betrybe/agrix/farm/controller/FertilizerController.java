package com.betrybe.agrix.farm.controller;

import com.betrybe.agrix.farm.controller.dto.FertilizerDto;
import com.betrybe.agrix.farm.entity.Fertilizer;
import com.betrybe.agrix.farm.service.FertilizerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for Fertilizer.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {
  private final FertilizerService fertilizerService;

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto saveFertilizer(@RequestBody FertilizerDto fertilizerDto) {
    Fertilizer entity = this.fertilizerService.saveFertilizer(fertilizerDto.toEntity());
    return FertilizerDto.fromEntity(entity);
  }

}
