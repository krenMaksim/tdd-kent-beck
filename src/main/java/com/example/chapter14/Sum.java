package com.example.chapter14;

public class Sum implements Expression {
	Money augend;
	Money addend;

	public Sum(Money augend, Money addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Money reduce(Bank bank, String currency) {
		int amount = augend.amount + addend.amount;
		return new Money(amount, currency);
	}
}
