package com.example.chapter3;

public class Dollar {
	int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int multiplier) {
		return new Dollar(amount * multiplier);
	}

	@Override
	public boolean equals(Object object) {
		return amount == ((Dollar) object).amount;
	}

}
