package com.example.kren.four.phases.pattern;

import static com.example.kren.part3.Currency.DOLLAR;
import static com.example.kren.part3.Currency.FRANC;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CurrencyTest {

    @Test
    void to() {
	assertEquals(2, DOLLAR.to(FRANC));
	assertEquals(1, FRANC.to(FRANC));
    }

    @Test
    void convert() {
	double fourDollar = DOLLAR.convert(FRANC, 8);

	assertEquals(4, fourDollar);
    }
}
