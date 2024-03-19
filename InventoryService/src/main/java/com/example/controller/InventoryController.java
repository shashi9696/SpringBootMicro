package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.InventoryNotFoundException;
import com.example.model.InventoryRequest;
import com.example.model.InventoryResponse;
import com.example.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	// Create Inventory
	@PostMapping
	public ResponseEntity<InventoryResponse> createInventory(@RequestBody InventoryRequest inventoryRequest) {
		InventoryResponse createdInventory = inventoryService.createInventory(inventoryRequest);
		return ResponseEntity.status(HttpStatus.OK).body(createdInventory);
	}
	
	// Update Invenroty's Quantity When Place the Order
	@PutMapping("/updateInventory/{id}")
	public ResponseEntity<Void> updateInventoryQuantity(@PathVariable("id") Long productId, @RequestParam int quantity) throws InventoryNotFoundException {
		inventoryService.updateInventoryQuantity(productId, quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
