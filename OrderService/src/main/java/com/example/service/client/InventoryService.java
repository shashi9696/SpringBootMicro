package com.example.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="INVENTORY-SERVICE/api/inventory")
public interface InventoryService {
	
	@PutMapping("/updateInventory/{id}")
	public ResponseEntity<Void> updateInventoryQuantity(@PathVariable("id") Long productId, @RequestParam int quantity);

}
