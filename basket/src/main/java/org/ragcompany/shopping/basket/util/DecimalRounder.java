package org.ragcompany.shopping.basket.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class to centrally set rounding scale for Bigdecimals.
 * @author vellora
 *
 */
public class DecimalRounder {

	public static BigDecimal round(BigDecimal value) { 
		return value.setScale(2, RoundingMode.HALF_UP); 
	} 

}
