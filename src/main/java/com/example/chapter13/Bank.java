package com.example.chapter13;

public class Bank {

	public Money reduce(Expression source, String currency) {
		return source.reduce(currency);
	}

}
