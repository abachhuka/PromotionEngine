package com.promotion;

import java.util.Map;
/**
 * Represents a shoping cart
 * @author ANBC
 *
 */
public class Cart {
	private Map<SKU,Integer> products;

	public Map<SKU, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<SKU, Integer> products) {
		this.products = products;
	}
	
}
