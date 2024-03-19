package com.example.service;

import com.example.exception.InventoryNotFoundException;
import com.example.model.InventoryRequest;
import com.example.model.InventoryResponse;

public interface InventoryService {

	// Create Inventory
	public InventoryResponse createInventory(InventoryRequest inventoryRequest);

	// Update Invenroty's Quantity When Place the Order
	public void updateInventoryQuantity(Long productId, int quantity) throws InventoryNotFoundException;

}
