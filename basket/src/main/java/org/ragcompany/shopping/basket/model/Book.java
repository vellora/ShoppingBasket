package org.ragcompany.shopping.basket.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.visitor.Visitor;

/**
 * Domain class representing a book item.
 * @author vellora
 *
 */
public final class Book implements Item{

	@NotNull
	private final String isbn;
	@NotNull
	private final BigDecimal pricePerUnit;
	@NotNull
	private final int quantity;
	
	public Book(String isbn, BigDecimal pricePerUnit, int quantity) throws ShoppingBasketException{
		if(!isInputParamsValid(isbn, pricePerUnit, quantity)){
			throw new ShoppingBasketException("Null parameters or negative price/quantity value not allowed.");
		}
		this.isbn = isbn;
		this.pricePerUnit = pricePerUnit;
		this.quantity = quantity;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal accept(Visitor visitor) throws ShoppingBasketException {
		return visitor.visit(this);
	}
	
	/*
	 * Null or Negative value not allowed for input parameters isbn, price or quantity
	 */
	private boolean isInputParamsValid(String isbn, BigDecimal pricePerUnit, int quantity) {
		if(isbn == null || pricePerUnit == null || pricePerUnit.signum() < 0 || quantity < 0){
			return false;
		}
		return true;
	}

}
