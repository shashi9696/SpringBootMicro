package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Inventory;
import com.example.exception.InventoryNotFoundException;
import com.example.model.InventoryRequest;
import com.example.model.InventoryResponse;
import com.example.repository.InventoryRepository;
import com.example.service.InventoryService;
import com.example.service.client.ProductService;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private ProductService productService;

	// Create Inventory
	@Override
	public InventoryResponse createInventory(InventoryRequest inventoryRequest) {
		productService.getSingleProduct(inventoryRequest.getProductId());
		Inventory inventory = Inventory.builder()
				.productId(inventoryRequest.getProductId())
				.price(inventoryRequest.getPrice())
				.quantity(inventoryRequest.getQuantity())
				.build();
		inventoryRepository.save(inventory);
		
		InventoryResponse inventoryResponse = InventoryResponse.builder()
				.productId(inventory.getProductId())
				.price(inventory.getPrice())
				.quantity(inventory.getQuantity())
				.build();
		return inventoryResponse;
	}

	// Update Invenroty's Quantity When Place the Order
	@Override
	public void updateInventoryQuantity(Long productId, int quantity) throws InventoryNotFoundException {
		Inventory inventory = inventoryRepository.findByProductId(productId).orElseThrow(() -> new InventoryNotFoundException("Product not found with id : "+productId));
		if(inventory instanceof Inventory) {
			if(inventory.getQuantity() < quantity) {
				throw new InventoryNotFoundException("Not having enough quantity of products : "+productId);
			}
			inventory.setQuantity(inventory.getQuantity() - quantity);
			inventoryRepository.save(inventory);
		}
	}
	
	

}
