package com.example.chapter.oldVariant;

public class Money implements Expression {
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	private int amount;
	private String currency;

	public Money(int amount, String currency) {
		this.currency = currency;
		this.amount = amount;
	}

	// public Money(Money money) {
	// this.currency = money.currency;
	// this.amount = money.amount;
	// }

	@Override
	public Money reduce(Bank bank, String currency) {
		int rate = bank.rate(this.currency, currency);

		return new Money(amount / rate, currency);
	}

	@Override
	public Expression plus(Money money) {
		return new Sum(this, money);
	}

	@Override
	public Expression times(int multiplier) {
		return new Money(amount * multiplier, currency);
	};

	public String getCurrency() {
		return currency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		return result;
	}

	// @Override
	// public boolean equals(Object object) {
	// Money money = (Money) object;
	// return (amount == money.amount) && currency.equals(money.currency);
	// }

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
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		return true;
	}
}

// public Expression plus(Money money) {
// if (this.equals(money)) {
// return new Money(amount + money.amount, currency);
// } else {
// throw new IllegalArgumentException("can't sum money with different currency");
// }
// }
