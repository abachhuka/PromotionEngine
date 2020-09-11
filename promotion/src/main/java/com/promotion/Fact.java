package com.promotion;
/**
 * Fact represent a logical unit for a rule
 * if all fact in a rule satisfies then only rule passes
 * @author ANBC
 *
 */
public class Fact {

	SKU item;
	int quantity;
	public Fact(SKU item, int quantity) {
		this.item = item ;
		this.quantity=quantity;
	}
	public SKU getItem() {
		return item;
	}
	public void setItem(SKU item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
