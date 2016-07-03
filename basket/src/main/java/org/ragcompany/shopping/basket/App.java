package org.ragcompany.shopping.basket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.ragcompany.shopping.basket.enums.Fruits;
import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.model.Book;
import org.ragcompany.shopping.basket.model.Fruit;
import org.ragcompany.shopping.basket.model.Item;
import org.ragcompany.shopping.basket.price.PriceCalculator;

/**
 * Main program to launch the shopping basket application.
 *
 */
public class App 
{
	
	public static void main( String[] args )
    {
    	try {
			BigDecimal cost = PriceCalculator.calculatePrice(getItems());
			System.out.println( "Total Cost: "+cost );
		} catch (ShoppingBasketException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
    }
    
    private static List<Item> getItems() throws ShoppingBasketException{
    	List<Item> items = new ArrayList<Item>();
    	Fruit apple = new Fruit(Fruits.Apple,new BigDecimal(2.5));
    	items.add(apple);
    	Fruit banana = new Fruit(Fruits.Banana,new BigDecimal(1.20));
    	items.add(banana);
    	Book harryPotter = new Book("ISBN12345",new BigDecimal(9.99),2);
    	items.add(harryPotter);
		return items;
    }
    
}
