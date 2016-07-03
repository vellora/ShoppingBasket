package org.ragcompany.shopping.basket.visitor;

import java.math.BigDecimal;

import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.model.Book;
import org.ragcompany.shopping.basket.model.Fruit;

public interface Visitor {
	
	BigDecimal visit(Fruit fruit) throws ShoppingBasketException;
	
	BigDecimal visit(Book book) throws ShoppingBasketException;

}
