package com.example.kren.part2;

import static com.example.kren.part2.Currency.DOLLAR;
import static com.example.kren.part2.Currency.FRANC;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CurrencyTest {

	@Test
	void to() {
		assertEquals(2, DOLLAR.to(FRANC));
		assertEquals(1, FRANC.to(FRANC));
	}

}
