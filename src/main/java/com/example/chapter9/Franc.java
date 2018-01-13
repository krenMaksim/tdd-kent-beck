package com.example.chapter9;

public class Franc extends Money {

	public Franc(int amount, String currency) {
		super(amount, currency);
	}

	public Money times(int multiplier) {
		return Money.franc(amount * multiplier);
	}

}
