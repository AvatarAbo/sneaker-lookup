package com.example.sneakerlookup.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sneakerlookup.data.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findBySneakerId(Integer sneakerId);
    Optional<Product> findByStoreIdAndSneakerIdAndShoeSize(int storeId, int sneakerId, String shoeSize);
}