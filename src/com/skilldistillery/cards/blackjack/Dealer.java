package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player {
	
	private Deck deck;
	
	
	public Dealer() {
		deck =new Deck();
		BlackjackHand hand = new BlackjackHand();
	}
	
	
	
	
	public Card dealCard() {
		
		return deck.dealCard();
	}
	
	public void shuffle() {
		
		deck.shuffle();
	}

	@Override
	public String toString() {
		return "Dealer has: " + hand + " with a value of: " + hand.getHandValue();
	}
	public String initial() {
		return "Dealer is showing: " + hand.getCard(1) + " with a value of " + hand.getCard(1).getValue();
	}
}
