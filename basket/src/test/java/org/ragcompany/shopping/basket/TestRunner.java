package org.ragcompany.shopping.basket;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Central test runner to run all tests of the test suite 
 * and print success/failure boolean result. 
 */
public class TestRunner {
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(AllTestsSuite.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	   }
}
