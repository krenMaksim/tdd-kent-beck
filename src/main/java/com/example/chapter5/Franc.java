package com.example.chapter5;

public class Franc {
	private int amount;

	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc times(int multiplier) {
		return new Franc(amount * multiplier);
	}

	@Override
	public boolean equals(Object object) {
		return amount == ((Franc) object).amount;
	}

}
