package com.example.chapter.one;

public class Sum implements Expression {
	private Money augend;
	private Money addend;

	public Sum(Money augend, Money addend) {
		this.augend = augend;
		this.addend = addend;
	}

	private Sum(Expression augend, Expression addend) {
		if (augend instanceof Money && addend instanceof Money) {
			this.augend = (Money) augend;
			this.addend = (Money) addend;
		} else {
			throw new RuntimeException("can't create object Sum");
		}
	}

	@Override
	public Money reduce(Bank bank, String currency) {
		augend = augend.reduce(bank, currency);
		addend = addend.reduce(bank, currency);

		return new Money(this.augend.getAmount() + this.addend.getAmount(), currency);
	}

	@Override
	public Expression times(int multiplier) {
		return new Sum(augend.times(multiplier), addend.times(multiplier));
	}

	@Override
	public Expression plus(Money money) {
		Sum sum = new Sum(augend, addend);
		int sumAmmount = 0;

		if (money.getCurrency().equals(augend.getCurrency())) {
			sumAmmount = augend.getAmount() + money.getAmount();
			sum.augend.setAmount(sumAmmount);

		} else if (money.getCurrency().equals(addend.getCurrency())) {
			sumAmmount = addend.getAmount() + money.getAmount();
			sum.addend.setAmount(sumAmmount);
		} else {
			throw new RuntimeException("can't define tupe currency");
		}

		return sum;
	}

	public Money getAugend() {
		return augend;
	}

	public Money getAddend() {
		return addend;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addend == null) ? 0 : addend.hashCode());
		result = prime * result + ((augend == null) ? 0 : augend.hashCode());
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
		Sum other = (Sum) obj;
		if (addend == null) {
			if (other.addend != null)
				return false;
		} else if (!addend.equals(other.addend))
			return false;
		if (augend == null) {
			if (other.augend != null)
				return false;
		} else if (!augend.equals(other.augend))
			return false;
		return true;
	}
}
