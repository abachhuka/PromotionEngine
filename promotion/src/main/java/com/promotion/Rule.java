package com.promotion;

import java.util.List;
import java.util.Map;
/**
 * A rule describes a promotional campaign
 * Example ; 3 A's for 130, 2 A's for 45
 *
 * @author ANBC
 *
 */
public class Rule {

	List<Fact> facts;
	PricingScheme scheme;

	public List<Fact> getFacts() {
		return facts;
	}

	public void setFacts(List<Fact> facts) {
		this.facts = facts;
	}

	public PricingScheme getScheme() {
		return scheme;
	}

	public void setScheme(PricingScheme scheme) {
		this.scheme = scheme;
	}

	public boolean isRuleApplicable(Cart cart) {
		boolean applied = true;
		Map<SKU, Integer> products = cart.getProducts();
		for (Fact fact : this.facts) {
			SKU p = fact.getItem();
			int quantity = fact.getQuantity();
			if (!products.containsKey(p) || products.get(p) < quantity)
				applied = false;
		}
		return applied;
	}
	/**
	 * Calculate the cart price for a rule
	 * remove item from the once a rule has completed it's calculation
	 * @param cart
	 * @return
	 */
	public int calculate(Cart cart) {
		int price = 0;
		for (Fact fact : this.facts) {
			SKU p = fact.getItem();
			int quantity = fact.getQuantity();
			if (cart.getProducts().get(p) - quantity == 0) {
				cart.getProducts().remove(p);
				 price = this.scheme.calculate();
			}

				
			else {
				int temp =cart.getProducts().get(p) - quantity; 
				while(temp>=0) {
					price += this.scheme.calculate();
					temp =temp - quantity;
				}
				if((temp+quantity)==0)
					cart.getProducts().remove(p);
				else
					cart.getProducts().put(p,temp+quantity);
			}
				
		}
		return price;
	}

}
