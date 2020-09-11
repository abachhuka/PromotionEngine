package com.promotion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceCalculator {
	/**
	 * Calculate price of a cart by applying rule
	 * @param cart
	 * @param rules
	 * @return
	 */
	public  int calculatePrice(Cart cart, List<Rule> rules) {
		int price = 0;
		/**
		 * Apply promotion
		 */
		for (Rule rule : rules) {
			if (rule.isRuleApplicable(cart))
				price += rule.calculate(cart);
		}
		/**
		 * Calculate for remaining stuff
		 */
		for (SKU p : cart.getProducts().keySet()) {
			price += p.getBasePrice() * (cart.getProducts().get(p));
		}
		return price;
	}


	public static void main(String args[]) {
		PriceCalculator tester = new PriceCalculator(); 
		SKU a = new SKU("A", 50);
		SKU b = new SKU("B", 30);
		SKU c = new SKU("C", 20);
		SKU d = new SKU("D", 15);
		
		Fact factA = new Fact(a, 3);
		Fact factB = new Fact(b, 2);
		Fact factc = new Fact(c, 1);
		Fact factd = new Fact(d, 1);
		
		
		Rule ruleA = new Rule();
		ruleA.setFacts(Collections.singletonList(factA));
		FixedPrice fp  = new FixedPrice();
		fp.setPrice(130);
		FixedPrice fpB  = new FixedPrice();
		fpB.setPrice(45);
		FixedPrice fpC  = new FixedPrice();
		fpC.setPrice(15);
		ruleA.setScheme(fp);
		Rule ruleB = new Rule();
		
		ruleB.setFacts(Collections.singletonList(factB));
		ruleB.setScheme(fpB);
		Rule rulec = new Rule();
		List<Fact> newList = new ArrayList<Fact>();
		newList.add(factc);
		newList.add(factd);
		rulec.setFacts(newList);
		rulec.setScheme(fpC);
		Cart cart = new Cart();
		Map<SKU,Integer> pmap= new HashMap();
		pmap.put(a, 5);
		pmap.put(b, 5);
		pmap.put(c, 1);
		cart.setProducts(pmap);
		List<Rule> rules= new ArrayList();
		rules.add(ruleA);
		rules.add(ruleB);
		rules.add(rulec);
		System.out.println("-------Start Executing Scenario B------------");
		System.out.println("");
		System.out.println("ScenaroB 5A SB & 1C -- Total is "+tester.calculatePrice(cart, rules));
		System.out.println("");
		System.out.println("-------End------------");
		
		
	}


}
