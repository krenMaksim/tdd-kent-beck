package com.example.chapter9;

public abstract class Money {
	public static Dollar dollar(int amount) {
		return new Dollar(amount, "USD");
	}

	public static Franc franc(int amount) {
		return new Franc(amount, "CHF");
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
		boolean isClass = (getClass().equals(object.getClass()));

		return isAmount && isClass;
	}

	public String currency() {
		return currency;
	}

	public abstract Money times(int multiplier);

}
