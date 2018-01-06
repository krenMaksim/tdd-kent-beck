package com.example.chapter.one;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	public static final String USD = "USD";
	public static final String CHF = "CHF";

	private Map<Pair, Integer> rates;

	public Bank() {
		this.rates = new HashMap<Pair, Integer>();
	}

	public Money reduce(Expression source, String currency) {
		return source.reduce(this, currency);
	}

	public void addRate(String currencyFrom, String currencyTo, int rate) {
		rates.put(new Pair(currencyFrom, currencyTo), rate);
	}

	int rate(String currencyFrom, String currencyTo) {
		if (currencyFrom.equals(currencyTo)) {
			return 1;
		}

		return rates.get(new Pair(currencyFrom, currencyTo));
	}

	// change on polimorfizm
	// public Money reduce(Expression source, String currency) {
	// if (source instanceof Money) {
	// return (Money) source;
	// }
	//
	// Sum sum = (Sum) source;
	// return sum.reduce(currency);
	// }

	private class Pair {
		private String from;
		private String to;

		public Pair(String from, String to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((from == null) ? 0 : from.hashCode());
			result = prime * result + ((to == null) ? 0 : to.hashCode());
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
			Pair other = (Pair) obj;
			if (from == null) {
				if (other.from != null)
					return false;
			} else if (!from.equals(other.from))
				return false;
			if (to == null) {
				if (other.to != null)
					return false;
			} else if (!to.equals(other.to))
				return false;
			return true;
		}
	}
}
