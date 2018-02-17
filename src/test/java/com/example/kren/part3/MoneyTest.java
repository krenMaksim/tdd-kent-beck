
package com.example.kren.part3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MoneyTest {

	private static Money fiveDollar = new Money(5, Currency.DOLLAR);
	private static Money threeDollar = new Money(3, Currency.DOLLAR);

	private static Money fourFranc = new Money(4, Currency.FRANC);

	@Test
	void creatingObject() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Money(-1, Currency.DOLLAR);
		});
	}

	@Test
	void plus() {
		Money sevenDollar = fiveDollar.plus(fourFranc);
		assertEquals(new Money(7, Currency.DOLLAR), sevenDollar);
	}

	@Test
	void minus() {
		Money minus = fiveDollar.minus(fourFranc);
		assertEquals(new Money(3, Currency.DOLLAR), minus);
	}

	@Test
	void multiply() {
		Money multiply = fiveDollar.multiply(fourFranc);
		assertEquals(new Money(10, Currency.DOLLAR), multiply);
	}

	@Test
	void divide() {
		Money divide = fiveDollar.divide(fourFranc);

		Money mon = new Money(2.5, Currency.DOLLAR);
		assertEquals(mon, divide);

		assertThrows(ArithmeticException.class, () -> {
			fiveDollar.divide(new Money(0, Currency.DOLLAR));
		});
	}

	@Test
	void equals() {
		assertTrue(fiveDollar.equals(new Money(5, Currency.DOLLAR)));
		assertFalse(fiveDollar.equals(threeDollar));
	}

}
