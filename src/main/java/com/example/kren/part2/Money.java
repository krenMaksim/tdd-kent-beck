package com.example.kren.part2;

public class Money {

	private int amount;
	private Currency currency;

	public Money(int amount, Currency currency) {
		if (amount < 0) {
			throw new IllegalArgumentException();
		}

		this.amount = amount;
		this.currency = currency;
	}

	// public Money(int amount) {
	// if (amount < 0) {
	// throw new IllegalArgumentException();
	// }
	//
	// this.amount = amount;
	// }

	public Money plus(Money money) {
		return new Money(this.amount + money.amount, this.currency);
	}

	public Money minus(Money money) {
		return new Money(this.amount - money.amount, this.currency);
	}

	public Money multiply(Money money) {
		return new Money(this.amount * money.amount, this.currency);
	}

	public Money divide(Money money) {
		return new Money(this.amount / money.amount, this.currency);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
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
		if (amount != other.amount)
			return false;
		return true;
	}

}
