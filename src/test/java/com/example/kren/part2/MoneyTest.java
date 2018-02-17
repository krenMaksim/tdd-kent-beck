
package com.example.kren.part2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MoneyTest {

	private static Money fiveDollar = new Money(5, Currency.DOLLAR);
	private static Money threeDollar = new Money(3, Currency.DOLLAR);

	@Test
	void newInstatnce() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Money(-1, Currency.DOLLAR);
		});
	}

	@Test
	void plus() {
		Money sum = fiveDollar.plus(threeDollar);
		assertEquals(new Money(8, Currency.DOLLAR), sum);
	}

	@Test
	void minus() {
		Money minus = fiveDollar.minus(threeDollar);
		assertEquals(new Money(2, Currency.DOLLAR), minus);
	}

	@Test
	void multiply() {
		Money multiply = fiveDollar.multiply(threeDollar);
		assertEquals(new Money(15, Currency.DOLLAR), multiply);
	}

	@Test
	void divide() {
		Money divide = fiveDollar.divide(threeDollar);
		assertEquals(new Money(1, Currency.DOLLAR), divide);

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
