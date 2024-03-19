package com.example.model;

import com.example.model.client.PaymentResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlacedOrderResponse {
	
	private Long orderId;
	private Long productId;
	private int quantity;
	private Double amount;
	private ProductResponse productResponse;
	private PaymentResponse paymentResponse;

}
