package com.example.chapter7;

public class Money {
	protected int amount;

	@Override
	public boolean equals(Object object) {
		boolean isAmount = (amount == ((Money) object).amount);
		boolean isClass = (getClass().equals(object.getClass()));

		return isAmount && isClass;
	}
}
