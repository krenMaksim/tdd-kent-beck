package com.example.chapter.oldVariant;

public interface Expression {
	public Money reduce(Bank bank, String currency);

	public Expression times(int multiplier);

	public Expression plus(Money money);
}
