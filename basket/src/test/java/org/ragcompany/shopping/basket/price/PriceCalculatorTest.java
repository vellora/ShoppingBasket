package org.ragcompany.shopping.basket.price;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.ragcompany.shopping.basket.enums.Fruits;
import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.model.Book;
import org.ragcompany.shopping.basket.model.Fruit;
import org.ragcompany.shopping.basket.model.Item;

/**
 * Unit test for PriceCalculator class
 *
 */
public class PriceCalculatorTest {

	private List<Item> items = new ArrayList<Item>();

	@Before
	public void setUp() throws ShoppingBasketException{
		Fruit apple = new Fruit(Fruits.Apple,new BigDecimal(2.5));
		items.add(apple);
		Fruit banana = new Fruit(Fruits.Banana,new BigDecimal(1));
		items.add(banana);
	}

	@Test
	public void testCalculatePriceForListOfFruits() throws ShoppingBasketException {
		assertEquals(new BigDecimal("6.90"), PriceCalculator.calculatePrice(items));
	}
	
	@Test
	public void testCalculatePriceForListOfFruitsAndBook() throws ShoppingBasketException {
		Book harryPotter = new Book("ISBN12345",new BigDecimal(9.99),2);
    	items.add(harryPotter);
		assertEquals(new BigDecimal("26.88"), PriceCalculator.calculatePrice(items));
	}

	@Test
	public void testCalculatePriceForItemRemovedFromList() throws ShoppingBasketException {
		items.remove(0);
		assertEquals(new BigDecimal("1.65"), PriceCalculator.calculatePrice(items));
	}
	
	@Test
	public void testCalculatePriceForEmptyList() throws ShoppingBasketException {
		items.clear();
		assertEquals(new BigDecimal(0), PriceCalculator.calculatePrice(items));
	}
	
	@Test (expected = ShoppingBasketException.class)
	public void testCalculatePriceForNullList() throws ShoppingBasketException {
		PriceCalculator.calculatePrice(null);
	}
	
}
