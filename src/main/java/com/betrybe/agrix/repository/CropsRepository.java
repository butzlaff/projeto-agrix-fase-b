package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Crops;
import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 * Repository for Crops.
 */
@Repository
public interface CropsRepository extends JpaRepository<Crops, Long> {
  List<Crops> findByHarvestDateBetween(LocalDate start, LocalDate end);
}
