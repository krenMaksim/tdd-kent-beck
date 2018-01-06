package com.example.chapter.one;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	public void testSumPlus() {
		Sum sum = new Sum(Money.dollar(5), Money.franc(10));

		Money fiveDollar = Money.dollar(5);
		Expression exp = sum.plus(fiveDollar);

		assertEquals(new Sum(Money.dollar(10), Money.franc(10)), exp);
	}

	@Test
	public void testSumTimes() {
		Sum sum = new Sum(Money.dollar(5), Money.franc(10));
		Expression exp = sum.times(2);

		assertEquals(new Sum(Money.dollar(10), Money.franc(20)), exp);
	}

	@Test
	public void testMixedAddition() {
		Money fiveBucks = Money.dollar(5);
		Money tenFrancs = Money.franc(10);

		Bank bank = new Bank();
		bank.addRate(Bank.CHF, Bank.USD, 2);

		Expression sum = fiveBucks.plus(tenFrancs);
		Money result = bank.reduce(sum, Bank.USD);

		assertEquals(Money.dollar(10), result);
	}

	@Test
	public void testReduceMoneyDifferentCurrency() {
		Bank bank = new Bank();
		bank.addRate(Bank.CHF, Bank.USD, 2);
		Money result = bank.reduce(Money.franc(2), Bank.USD);
		assertEquals(Money.dollar(1), result);
	}

	@Test
	public void testReduceMoney() {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), Bank.USD);
		assertEquals(Money.dollar(1), result);
	}

	@Test
	public void testIdentityRate() {
		Bank bank = new Bank();
		bank.addRate(Bank.USD, Bank.CHF, 1);
		assertEquals(1, bank.rate(Bank.USD, Bank.CHF));
	}

	@Test
	public void testPlusReturnsSum() {
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		assertEquals(five, sum.getAugend());
		assertEquals(five, sum.getAugend());
	}

	@Test
	public void testAddition() {
		Expression sum = new Sum(Money.dollar(101), Money.dollar(99));

		Bank bank = new Bank();

		Money reduced = bank.reduce(sum, Bank.USD);
		assertEquals(Money.dollar(200), reduced);
	}

	@Test
	public void testDollarMultiplication() {
		Money fiveDollar = Money.dollar(5);
		assertEquals(Money.dollar(10), fiveDollar.times(2));
		assertEquals(Money.dollar(15), fiveDollar.times(3));
	}

	@Test
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));

		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}

	@Test
	public void testCurrency() {
		assertEquals(Bank.USD, Money.dollar(1).getCurrency());
		assertEquals(Bank.CHF, Money.franc(1).getCurrency());
	}
}

// @Test
// public void testAddition() {
// Money fiveDollars = Money.dollar(5);
//
// Expression sum = fiveDollars.plus(fiveDollars);
//
// Bank bank = new Bank();
//
// Money reduced = bank.reduce(sum, "USD");
// assertEquals(Money.dollar(10), reduced);
// }

// @Test
// public void testSimpleAddition() {
// Money fiveDollars = Money.dollar(5);
// Money sum = fiveDollars.plus(Money.dollar(5));
// assertEquals(Money.dollar(10), sum);
// }

// @Test()
// public void testSimpleAdditionExeption() {
// Money fiveFrancs = Money.franc(5);
//
// Executable codeToTest = () -> {
// @SuppressWarnings("unused")
// Money sum = fiveFrancs.plus(Money.dollar(5));
// };
//
// Assertions.assertThrows(IllegalArgumentException.class, codeToTest);
// }
