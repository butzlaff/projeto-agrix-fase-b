package com.betrybe.agrix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Crops Entity.
 */
@Entity
@Table(name = "crops")
public class Crops {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String name;
  private Double plantedArea;
  
  /**
   * Construtor vazio.
   */
  public Crops() { }

  /**
   * Construtor do Crops.
   */
  public Crops(Long id, String name, Double plantedArea, Farm farm) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
  }

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }
}