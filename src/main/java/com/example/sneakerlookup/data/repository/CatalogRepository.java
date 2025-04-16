package com.example.sneakerlookup.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sneakerlookup.data.entity.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    List<Catalog> findBySneakerId(int sneakerId);
}
