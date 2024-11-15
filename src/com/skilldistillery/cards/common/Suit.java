package com.skilldistillery.cards.common;

public enum Suit {
	SPADES ("Spades"),
	HEARTS ("Hearts"),
	CLUBS ("Clubs"),
	DIAMONDS ("Diamonds");
	
	final private String name;
	
	Suit(String n){
		name = n;
	}
	@Override
 public String toString() {
	 
	 return name;
 }
	
}