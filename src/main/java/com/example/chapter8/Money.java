package com.example.chapter8;

public abstract class Money {
	public static Dollar dollar(int amount) {
		return new Dollar(amount);
	}

	protected int amount;

	@Override
	public boolean equals(Object object) {
		boolean isAmount = (amount == ((Money) object).amount);
		boolean isClass = (getClass().equals(object.getClass()));

		return isAmount && isClass;
	}

	public abstract Money times(int multiplier);
}
