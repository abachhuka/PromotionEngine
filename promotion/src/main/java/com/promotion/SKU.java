package com.promotion;
/*
 * Describes a product
 */
public class SKU {

	private static String name;
	// integer for simplicity
	private int basePrice;

	public SKU(String name, int price) {
		this.name = name;
		this.basePrice = price;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		SKU.name = name;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

}
