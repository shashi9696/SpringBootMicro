package com.example.service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="PRODUCT-SERVICE/api/product")
public interface ProductService {
	
	//@PutMapping("/updateQuantity/{id}")
	//public ResponseEntity<Void> updateQuantity(@PathVariable("id") Long productId, @RequestParam int quantity);
	
	//@GetMapping("/{id}")
	//public ResponseEntity<ProductResponse> getSingleProduct(@PathVariable("id") Long productId);

}
