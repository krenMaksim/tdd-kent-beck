package com.example.kren.part4;

public class Money {

	private double amount;
	private Currency currency;

	public Money(double amount, Currency currency) {
		if (amount < 0.0) {
			throw new IllegalArgumentException();
		}

		this.amount = Math.round(amount * 100.0) / 100.0;
		this.currency = currency;
	}

	public Money plus(Money money) {
		return newInstance(this.amount + convertedAmount(money));
	}

	public Money minus(Money money) {
		return newInstance(this.amount - convertedAmount(money));
	}

	public Money multiply(Money money) {
		return newInstance(this.amount * convertedAmount(money));
	}

	public Money divide(Money money) {
		if (money.amount == 0.0) {
			throw new ArithmeticException();
		}

		return newInstance(this.amount / convertedAmount(money));
	}

	public Money setTargetCurrency(Currency currency) {
		double amount = currency.convert(this.currency, this.amount);
		return new Money(amount, currency);
	}

	private Money newInstance(double amount) {
		return new Money(amount, this.currency);
	}

	private double convertedAmount(Money money) {
		return this.currency.convert(money.currency, money.amount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (currency != other.currency)
			return false;
		return true;
	}
}
