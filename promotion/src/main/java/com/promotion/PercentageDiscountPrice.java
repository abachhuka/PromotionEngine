package com.promotion;

/**
 * Discount Percent pricing scheme to add campaign where percentage can be put
 * as a discounted price
 * 
 * @author ANBC
 *
 */
public class PercentageDiscountPrice implements PricingScheme {
	private int price;
	private int discountPercentage;

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public int calculate() {
		return (this.price - ((this.price * this.discountPercentage) / 100));
	}
}
