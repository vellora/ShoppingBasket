package org.ragcompany.shopping.basket.exception;

/**
 * Custom exception class to wrap java exceptions like 
 * NullPointerException and IllegalArgumentException and
 * provide a brief application specific validation message.
 * 
 * @author vellora
 *
 */
public class ShoppingBasketException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ShoppingBasketException(){
		super();
	}
	
	public ShoppingBasketException(String msg){
		super(msg);
	}
	
	public ShoppingBasketException(String msg, Throwable cause){
		super(msg,cause);
	}
	
	public ShoppingBasketException(Throwable cause){
		super(cause);
	}
	
}
