
package com.example.kren.part4;

import static com.example.kren.part4.Currency.DOLLAR;
import static com.example.kren.part4.Currency.FRANC;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MoneyTest {

	private static Money fiveDollar = new Money(5, DOLLAR);
	private static Money threeDollar = new Money(3, DOLLAR);

	private static Money fourFranc = new Money(4, FRANC);

	@Test
	void creatingObject() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Money(-1, DOLLAR);
		});
	}

	@Test
	void plus() {
		Money sevenDollar = fiveDollar.plus(fourFranc);
		assertEquals(new Money(7, DOLLAR), sevenDollar);
	}

	@Test
	void minus() {
		Money minus = fiveDollar.minus(fourFranc);
		assertEquals(new Money(3, DOLLAR), minus);
	}

	@Test
	void multiply() {
		Money multiply = fiveDollar.multiply(fourFranc);
		assertEquals(new Money(10, DOLLAR), multiply);
	}

	@Test
	void divide() {
		Money divide = fiveDollar.divide(fourFranc);

		Money mon = new Money(2.5, DOLLAR);
		assertEquals(mon, divide);

		assertThrows(ArithmeticException.class, () -> {
			fiveDollar.divide(new Money(0, DOLLAR));
		});
	}

	@Test
	void finalCurrency() {
		Money forteenFranks = fiveDollar.plus(fourFranc).setTargetCurrency(FRANC);
		assertEquals(new Money(14, FRANC), forteenFranks);
	}

	@Test
	void equals() {
		assertTrue(fiveDollar.equals(new Money(5, DOLLAR)));
		assertFalse(fiveDollar.equals(threeDollar));
	}
}
