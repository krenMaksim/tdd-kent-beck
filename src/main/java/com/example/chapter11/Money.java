package com.example.chapter11;

public class Money {
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	@Override
	public boolean equals(Object object) {
		boolean isAmount = (amount == ((Money) object).amount);
		boolean isCurrency = (currency == ((Money) object).currency);

		return isAmount && isCurrency;
	}

	public String currency() {
		return currency;
	}

	public Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}

	public String toString() {
		return amount + "	" + currency;
	}

}
