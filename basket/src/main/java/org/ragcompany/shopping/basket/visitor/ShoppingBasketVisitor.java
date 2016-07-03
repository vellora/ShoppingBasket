package org.ragcompany.shopping.basket.visitor;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.model.Book;
import org.ragcompany.shopping.basket.model.Fruit;
import org.ragcompany.shopping.basket.util.DecimalRounder;

/**
 * The ShoppingBasketVisitor class implements visit method of all kind of items.
 * This facilitate extensibility by allowing addition of virtual function (visit) 
 * to a new Item classes without modifying the classes themselves.
 * 
 * @author vellora
 *
 */
public class ShoppingBasketVisitor implements Visitor {

	public BigDecimal visit(@NotNull Fruit fruit) throws ShoppingBasketException {
		if(fruit == null){
			throw new ShoppingBasketException("Null fruit not allowed.");
		}
		BigDecimal cost = DecimalRounder.round(fruit.getPricePerKg().multiply(fruit.getWeightInKg()));
		System.out.println(fruit.getName()+", cost: "+cost);
		return cost;
	}

	public BigDecimal visit(@NotNull Book book) throws ShoppingBasketException {
		if(book == null){
			throw new ShoppingBasketException("Null book not allowed.");
		}
		BigDecimal cost = DecimalRounder.round(book.getPricePerUnit().multiply(new BigDecimal(book.getQuantity())));
		System.out.println(book.getIsbn()+", cost: "+cost);
		return cost;
	}

}
