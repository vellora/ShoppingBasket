package org.ragcompany.shopping.basket.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.ragcompany.shopping.basket.enums.Fruits;
import org.ragcompany.shopping.basket.exception.ShoppingBasketException;
import org.ragcompany.shopping.basket.visitor.Visitor;

/**
 * Domain class representing a fruit item.
 * 
 * @author vellora
 *
 */
public final class Fruit implements Item {

	@NotNull
	private final Fruits name;
	@NotNull
	private final BigDecimal pricePerKg;
	@NotNull
	private final BigDecimal weightInKg;

	/*
	 * Fruit constructor takes 2 parameters - Fruit and WeightInKg
	 * FruitName and PricePerKg are derived from an enum to restrict inputs.
	 */
	public Fruit(Fruits name, BigDecimal weightInKg) throws ShoppingBasketException {
		if(!isInputParamsValid(name, weightInKg)){
			throw new ShoppingBasketException("Null parameters or negative weight value not allowed.");
		}
		this.name = name;
		this.pricePerKg = name.price();
		this.weightInKg = weightInKg;
	}

	public Fruits getName() {
		return name;
	}

	public BigDecimal getPricePerKg() {
		return pricePerKg;
	}

	public BigDecimal getWeightInKg() {
		return weightInKg;
	}

	public BigDecimal accept(Visitor visitor) throws ShoppingBasketException {
		return visitor.visit(this);
	}

	/*
	 * Null or Negative value not allowed for input parameters Name or Weight
	 */
	private boolean isInputParamsValid(Fruits name, BigDecimal weightInKg) {
		if(name == null || weightInKg == null || weightInKg.signum() < 0){
			return false;
		}
		return true;
	}

}
