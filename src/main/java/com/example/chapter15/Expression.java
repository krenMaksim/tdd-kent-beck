package com.example.chapter15;

public interface Expression {
	public Money reduce(Bank bank, String currency);

	public Expression times(int multiplier);

	public Expression plus(Expression addend);
}
