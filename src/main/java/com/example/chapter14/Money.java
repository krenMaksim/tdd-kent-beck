package com.example.chapter14;

public class Money implements Expression {
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	int amount;
	String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public String currency() {
		return currency;
	}

	public Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}

	public Expression plus(Money addend) {
		return new Sum(this, addend);
	}

	public Money reduce(Bank bank, String currency) {
		int rate = bank.rate(this.currency, currency);

		return new Money(amount / rate, currency);
	}

	@Override
	public boolean equals(Object object) {
		boolean isAmount = (amount == ((Money) object).amount);
		boolean isCurrency = (currency == ((Money) object).currency);

		return isAmount && isCurrency;
	}

	public String toString() {
		return amount + "	" + currency;
	}

}
