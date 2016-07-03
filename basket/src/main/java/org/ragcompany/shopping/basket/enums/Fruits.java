package org.ragcompany.shopping.basket.enums;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * The FruitName enum provides set of fruit name constants and respective prices. 
 * It restricts input parameter in client classes (eg. while building a basket of fruits)
 * 
 * @author vellora
 *
 */
public enum Fruits {
	Banana(1.65), Orange(1.75), Apple(2.10), Lemon(2.40),
	Peach(2.20), Blueberry(3.10), Strawberry(2.70);
	
	private final BigDecimal pricePerKg;

	Fruits(double pricePerKg) {
        this.pricePerKg = new BigDecimal(pricePerKg, MathContext.DECIMAL64);;
    }
    
	public BigDecimal price() {
        return this.pricePerKg;
    }
}
