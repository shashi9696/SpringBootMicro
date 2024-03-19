package com.example.exception;

public class InventoryNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7900151748603550730L;

	public InventoryNotFoundException() {
		super("resource not found on server !!");
	}
	
	public InventoryNotFoundException(String message) {
		super(message);
	}

}
