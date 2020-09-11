package promotion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.promotion.Cart;
import com.promotion.Fact;
import com.promotion.FixedPrice;
import com.promotion.PriceCalculator;
import com.promotion.Rule;
import com.promotion.SKU;

public class TestCampaign {

	
	PriceCalculator tester = new PriceCalculator(); // MyClass is tested
	SKU a = new SKU("A", 50);
	SKU b = new SKU("B", 30);
	SKU c = new SKU("C", 20);
	SKU d = new SKU("D", 15);
	List<Rule> rules;
	@Before
	public void  createRule() {
		rules= new ArrayList();
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
		fpC.setPrice(30);
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
		rules.add(ruleA);
		rules.add(ruleB);
		rules.add(rulec);
	}
	
	@Test
	public void calulatePriceScenarioA() {
	
		Cart cart = new Cart();
		Map<SKU,Integer> pmap= new HashMap();
		pmap.put(a, 1);
		pmap.put(b, 1);
		pmap.put(c, 1);
		cart.setProducts(pmap);
		
		assertEquals("100 ScenarioA 1A, 1B, 1C",100, tester.calculatePrice(cart,rules));
		
	}
	@Test
	public void calulatePriceScenarioB() {
		Cart cart = new Cart();
		Map<SKU,Integer> pmap= new HashMap();
		pmap.put(a, 5);
		pmap.put(b, 5);
		pmap.put(c, 1);
		cart.setProducts(pmap);
		assertEquals("370 ScenarioB 5A, 5B, 1C",370, tester.calculatePrice(cart,rules));
		
	}
	@Test
	public void calulatePriceScenarioC() {
		Cart cart = new Cart();
		Map<SKU,Integer> pmap= new HashMap();
		pmap.put(a, 3);
		pmap.put(b, 5);
		pmap.put(c, 1);
		pmap.put(d, 1);
		cart.setProducts(pmap);
		assertEquals("280 ScenarioC 3A, 5B, 1C, 1D",280, tester.calculatePrice(cart,rules));
	}
}
