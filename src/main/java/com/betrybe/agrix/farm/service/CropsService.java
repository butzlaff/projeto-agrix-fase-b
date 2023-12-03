package com.betrybe.agrix.farm.service;

import com.betrybe.agrix.farm.entity.Crops;
import com.betrybe.agrix.farm.entity.Farm;
import com.betrybe.agrix.farm.repository.CropsRepository;
import com.betrybe.agrix.farm.service.exceptions.CropsNotFoundException;
import com.betrybe.agrix.farm.service.exceptions.FarmNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for Crops.
 */
@Service
public class CropsService {
  private final CropsRepository cropsRepository;
  private final FarmService farmService;

  @Autowired
  public CropsService(CropsRepository cropsRepository, FarmService farmService) {
    this.cropsRepository = cropsRepository;
    this.farmService = farmService;
  }

  public Crops create(Crops crops) {
    return cropsRepository.save(crops);
  }

  /**
   * Creates a new crops object for a given farm.
   *
   * @param  crops   the crops object to be created.
   * @param  farmId  the ID of the farm.
   * @return         the created crops object.
   * @throws FarmNotFoundException  if the farm with the given ID is not found.
   */
  public Crops createCrops(Crops crops, Long farmId) throws FarmNotFoundException {
    Farm farm = farmService.findById(farmId);
    crops.setFarm(farm);
    return create(crops);
  }

  public Crops findCrops(Long id) throws CropsNotFoundException {
    return cropsRepository.findById(id)
      .orElseThrow(CropsNotFoundException::new);
  }

  public List<Crops> findAll() {
    return cropsRepository.findAll();
  }

  public List<Crops> findByHarvestDateBetween(LocalDate start, LocalDate end) {
    return cropsRepository.findByHarvestDateBetween(start, end);
  }
}
