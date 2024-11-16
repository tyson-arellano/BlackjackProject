package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	
	protected BlackjackHand hand;
	
	//No list of cards instance. access cards through hand.
	
	public Player () {
		hand = new BlackjackHand();
		}
	public void hit(Card card) {
		hand.addCard(card);
	}
	//No getHand
}
