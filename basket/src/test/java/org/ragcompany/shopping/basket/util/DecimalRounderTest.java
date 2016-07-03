package org.ragcompany.shopping.basket.util;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class DecimalRounderTest {

	@Test
	public void testRoundMethod() {
		assertEquals(new BigDecimal("1.55"), DecimalRounder.round(new BigDecimal("1.549023")));
	}

}
