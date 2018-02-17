
package com.example.kren.part1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestSimple {

	private static Money fiveDollar = new Money(5);
	private static Money threeDollar = new Money(3);

	@Test
	void newInstatnce() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Money(-1);
		});
	}

	@Test
	void plus() {
		Money sum = fiveDollar.plus(threeDollar);
		assertEquals(new Money(8), sum);
	}

	@Test
	void minus() {
		Money minus = fiveDollar.minus(threeDollar);
		assertEquals(new Money(2), minus);
	}

	@Test
	void multiply() {
		Money multiply = fiveDollar.multiply(threeDollar);
		assertEquals(new Money(15), multiply);
	}

	@Test
	void divide() {
		Money divide = fiveDollar.divide(threeDollar);
		assertEquals(new Money(1), divide);

		assertThrows(ArithmeticException.class, () -> {
			fiveDollar.divide(new Money(0));
		});
	}

	@Test
	void equals() {
		assertTrue(fiveDollar.equals(new Money(5)));
		assertFalse(fiveDollar.equals(threeDollar));
	}

}
