package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropsDto;
import com.betrybe.agrix.entity.Crops;
import com.betrybe.agrix.service.CropsService;
import com.betrybe.agrix.service.exceptions.CropsNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Rest controller for /crops.
 */
@RestController
@RequestMapping("/crops")
public class CropController {
  private final CropsService cropsService;

  @Autowired
  public CropController(CropsService cropsService) {
    this.cropsService = cropsService;
  }

  /**
   * Return ok and all Crops.
  */
  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<CropsDto> findAll() {
    List<Crops> crops = cropsService.findAll();
    return crops.stream()
      .map(CropsDto::fromEntity)
      .toList();
  }

  /**
   * Return ok and Crop by id.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CropsDto findById(@PathVariable("id") Long id) throws CropsNotFoundException {
    Crops crops = cropsService.findCrops(id);
    return CropsDto.fromEntity(crops);
  }

  /**
   * Find crops by StartDate and End.
   */
  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public List<CropsDto> findByHarvestDateBetween(
      @RequestParam("start") LocalDate start, @RequestParam("end") LocalDate end) {
    List<Crops> crops = cropsService.findByHarvestDateBetween(start, end);
    return crops.stream()
      .map(CropsDto::fromEntity)
      .toList();
  }
}
