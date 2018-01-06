package com.example.chapter6;

public class Money {
	protected int amount;

	@Override
	public boolean equals(Object object) {
		return amount == ((Money) object).amount;
	}
}
