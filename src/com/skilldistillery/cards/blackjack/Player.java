package com.skilldistillery.cards.blackjack;

public class Player {
	
	protected BlackjackHand hand;
	
	//No list of cards instance. access cards through hand.
	
	public Player () {
		hand = new BlackjackHand();
		}
	
	//No getHand
}
