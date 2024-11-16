package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;

public class BlackjackHand extends AbstractHand {

	@Override
	public int getHandValue() {
		int sum= 0;
		for (Card eachCard : cardsInHand) {
			sum += eachCard.getValue();
		}
		return sum;
	}
	public boolean isBlackjack() {
		if (getHandValue() == 21) { //TODO add && to take only initial hand
			return true;
		}return false;
	}
	public boolean isBust() {
		
		if(getHandValue() > 21) {
			return true;
		}return false;
	}
	
}
