package com.example.chapter15;

import java.util.HashMap;

public class Bank {
	private HashMap<Pair, Integer> rates = new HashMap<>();

	public Money reduce(Expression source, String currency) {
		return source.reduce(this, currency);
	}

	public void addRate(String currencyFrom, String currencyTo, int rate) {
		rates.put(new Pair(currencyFrom, currencyTo), rate);
	}

	public int rate(String from, String to) {
		if (from.equals(to)) {
			return 1;
		}

		return rates.get(new Pair(from, to));
	}

	private class Pair {
		private String from;
		private String to;

		public Pair(String from, String to) {
			this.from = from;
			this.to = to;
		}

		public boolean equals(Object object) {
			Pair pair = (Pair) object;
			return from.equals(pair.from) && to.equals(pair.to);
		}

		public int hashCode() {
			return 0;
		}
	}
}
