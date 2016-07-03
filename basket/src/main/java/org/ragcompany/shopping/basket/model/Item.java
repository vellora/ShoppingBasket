package org.ragcompany.shopping.basket.model;

import java.math.BigDecimal;

import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.visitor.Visitor;

/**
 * Interface for shopping items such as Fruit, Book, MobilePhone and Beverage etc.
 * 
 * @author vellora
 *
 */
public interface Item {
	/**
	 * This function accepts an object of any class derived from Visitor and 
	 * must be implemented in all derived classes.
	 * @param visitor
	 * @return BigDecimal
	 * @throws ShoppingBasketException
	 */
	BigDecimal accept(Visitor visitor) throws ShoppingBasketException;
}
