package com.example.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.client.ProductResponse;

@FeignClient(name="PRODUCT-SERVICE/api/product")
public interface ProductService {
		
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getSingleProduct(@PathVariable("id") Long productId);

}
