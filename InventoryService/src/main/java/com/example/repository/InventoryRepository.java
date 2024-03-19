package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	// Get Inventory by productId
	Optional<Inventory> findByProductId(Long productId);

}
