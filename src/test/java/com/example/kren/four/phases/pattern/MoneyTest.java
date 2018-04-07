
package com.example.kren.four.phases.pattern;

import static com.example.kren.four.phases.pattern.Currency.DOLLAR;
import static com.example.kren.four.phases.pattern.Currency.FRANC;
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
    void initialStateWithIllegalArgument() {
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
	Money rezultDollar = fiveDollar.minus(fourFranc);

	assertEquals(new Money(3, DOLLAR), rezultDollar);
    }

    @Test
    void multiply() {
	Money rezultDollar = fiveDollar.multiply(fourFranc);

	assertEquals(new Money(10, DOLLAR), rezultDollar);
    }

    @Test
    void divide() {
	Money rezultDollar = fiveDollar.divide(fourFranc);

	assertEquals(new Money(2.5, DOLLAR), rezultDollar);
    }

    @Test
    void divideToZero() {
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
