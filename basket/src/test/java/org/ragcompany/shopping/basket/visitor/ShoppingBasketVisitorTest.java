package org.ragcompany.shopping.basket.visitor;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.ragcompany.shopping.basket.enums.Fruits;
import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.model.Fruit;

/**
 * Unit test for ShoppingBasketVisitor class
 *
 */
public class ShoppingBasketVisitorTest {

	private Visitor visitor = new ShoppingBasketVisitor();
	private Fruit fruit;
	
	/*
	 * Null test
	 */
	@Test (expected = ShoppingBasketException.class)
	public void testVisitMethodForNullItem() throws ShoppingBasketException {
		visitor.visit(fruit);
	}
	
	/*
	 * Test accuracy of calculated/returned cost 
	 */
	@Test
	public void testVisitMethodToVerifyReturnedCost() throws ShoppingBasketException {
		fruit = new Fruit(Fruits.Blueberry,new BigDecimal(0.5));
		assertEquals(new BigDecimal("1.55"), visitor.visit(fruit));
	}
	
	
}
