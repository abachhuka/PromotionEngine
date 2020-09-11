package com.promotion;
/**
 * Fixed price pricing scheme
 * @author ANBC
 *
 */
public class FixedPrice implements PricingScheme{
	private int price;
	public void setPrice(int price) {
		this.price = price;
	}
	public int calculate() {
		return this.price;
	}
}
