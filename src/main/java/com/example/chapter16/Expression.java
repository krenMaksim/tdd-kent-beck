package com.example.chapter16;

public interface Expression {
	public Money reduce(Bank bank, String currency);

	public Expression times(int multiplier);

	public Expression plus(Expression addend);
}
