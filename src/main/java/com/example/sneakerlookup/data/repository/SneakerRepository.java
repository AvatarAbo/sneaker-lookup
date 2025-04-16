package com.example.sneakerlookup.data.repository;

import java.util.List;
import java.util.Optional;

import com.example.sneakerlookup.data.entity.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SneakerRepository extends JpaRepository<Sneaker, Integer> {
    List<Sneaker> findByBrand(String brand);
    List<Sneaker> findByBrandAndModel(String brand, String model);
    List<Sneaker> findByBrandAndModelAndColorWay(String brand, String model, String colorWay);
    Optional<Sneaker> findByYearAndBrandAndModelAndColorWay(Integer year, String brand, String model, String colorWay);
}