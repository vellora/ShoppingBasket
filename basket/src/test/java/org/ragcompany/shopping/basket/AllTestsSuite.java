package org.ragcompany.shopping.basket;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.ragcompany.shopping.basket.model.FruitTest;
import org.ragcompany.shopping.basket.price.PriceCalculatorTest;
import org.ragcompany.shopping.basket.util.DecimalRounderTest;
import org.ragcompany.shopping.basket.visitor.ShoppingBasketVisitorTest;

/**
 * Central test suite to run all unit tests together
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	FruitTest.class, 
	ShoppingBasketVisitorTest.class, 
	PriceCalculatorTest.class,
	DecimalRounderTest.class} )
public class AllTestsSuite 
{

}
