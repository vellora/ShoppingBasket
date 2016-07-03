package org.ragcompany.shopping.basket.price;

import java.math.BigDecimal;

import java.util.List;

import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.model.Item;
import org.ragcompany.shopping.basket.visitor.ShoppingBasketVisitor;
import org.ragcompany.shopping.basket.visitor.Visitor;

/**
 * The PriceCalculator class calculates total cost associated to a basket by 
 * iterating over the supplied list and summing individual item cost.
 *
 * Unless otherwise noted, passing a null argument to a method in this class 
 * will cause a ShoppingBasketException to be thrown. 
 * 
 * @author vellora
 *
 */
public class PriceCalculator {
	
	public static BigDecimal calculatePrice(List<Item> items) throws ShoppingBasketException{
		if(items == null){
			throw new ShoppingBasketException("Null items not allowed.");
		}
		Visitor visitor = new ShoppingBasketVisitor();
		BigDecimal sum = BigDecimal.ZERO;
		for(Item item: items){
			sum = sum.add(item.accept(visitor));
		}
		return sum;
	}

}
