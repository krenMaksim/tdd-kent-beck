
package com.example.chapter4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DollarTest {

	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);

		assertEquals(new Dollar(10), five.times(2));

		assertEquals(new Dollar(15), five.times(3));
	}

}
