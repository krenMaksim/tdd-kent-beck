package com.example.kren.part2;

import java.util.HashMap;
import java.util.Map;

public enum Currency {
	DOLLAR, FRANC;

	private Currency() {
	}

	private static final double SAME_CURRENCY_COURSE = 1.0;

	public double to(Currency currency) {

		if (this.equals(currency)) {
			return SAME_CURRENCY_COURSE;
		} else {
			return Pair.courses.get(new Pair(this, currency));
		}

	}

	private static class Pair {
		public static Map<Pair, Double> courses = new HashMap<>();

		static {
			courses.put(new Pair(Currency.FRANC, Currency.DOLLAR), 0.5);
			courses.put(new Pair(Currency.DOLLAR, Currency.FRANC), 2.0);
		}

		private Currency one;
		private Currency two;

		public Pair(Currency one, Currency two) {
			this.one = one;
			this.two = two;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((one == null) ? 0 : one.hashCode());
			result = prime * result + ((two == null) ? 0 : two.hashCode());
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
			if (one != other.one)
				return false;
			if (two != other.two)
				return false;
			return true;
		}
	}
}
