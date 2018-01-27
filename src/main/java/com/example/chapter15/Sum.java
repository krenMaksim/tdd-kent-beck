package com.example.chapter15;

public class Sum implements Expression {
	Expression augend;
	Expression addend;

	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	@Override
	public Money reduce(Bank bank, String currency) {
		int amount = augend.reduce(bank, currency).amount + addend.reduce(bank, currency).amount;

		return new Money(amount, currency);
	}

	@Override
	public Expression times(int multiplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression plus(Expression addend) {
		// TODO Auto-generated method stub
		return null;
	}
}
