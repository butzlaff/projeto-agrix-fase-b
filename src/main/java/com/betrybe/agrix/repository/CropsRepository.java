package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Crops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Crops.
 */
@Repository
public interface CropsRepository extends JpaRepository<Crops, Long> {
}
