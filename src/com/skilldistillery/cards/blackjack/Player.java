package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	
	public BlackjackHand hand;
	
	//No list of cards instance. access cards through hand.
	
	public Player () {
		hand = new BlackjackHand();
		}
	public void hit(Card card) {
		hand.addCard(card);
	}
	@Override
	public String toString() {
		return  "Your cards are: "+ hand + " with a value of: " + hand.getHandValue();
	}

	public int handValue() {
		return hand.getHandValue();
	}
}
