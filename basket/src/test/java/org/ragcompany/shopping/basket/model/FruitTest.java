package org.ragcompany.shopping.basket.model;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.ragcompany.shopping.basket.enums.Fruits;
import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.visitor.ShoppingBasketVisitor;

/**
 * Unit test for Fruit class
 *
 */
public class FruitTest {
	
	@Mock
	private ShoppingBasketVisitor visitor;
	private Fruit fruit;
	
	@Before
	public void setUp() throws ShoppingBasketException{
		MockitoAnnotations.initMocks(this);
		fruit = new Fruit(Fruits.Blueberry,new BigDecimal(0.5));
	}
	
	/*
	 * Verify visit method call while invoking accept method
	 */
	@Test
	public void verifyVisitCallWhileInvokingAcceptMethod() throws ShoppingBasketException{
		fruit.accept(visitor);
		Mockito.verify(visitor).visit(fruit);
	}
	
	/*
	 * Fruit construction should fail for null parameters
	 */
	@Test (expected = ShoppingBasketException.class)
	public void testFruitConstructionForNullName() throws ShoppingBasketException{
		fruit = new Fruit(null,new BigDecimal(0.5));
	}
		
	@Test (expected = ShoppingBasketException.class)
	public void testFruitConstructionForNullWeight() throws ShoppingBasketException{
		fruit = new Fruit(Fruits.Blueberry,null);
	}
	
	/*
	 * Fruit construction should fail for negative weight
	 */
	@Test (expected = ShoppingBasketException.class)
	public void testFruitConstructionForNegativeWeight() throws ShoppingBasketException{
		fruit = new Fruit(Fruits.Blueberry,new BigDecimal(-0.5));
	}

}
