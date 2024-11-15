package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHand {
	
	protected List<Card> cardsInHand;
	
	public AbstractHand( ) {
		cardsInHand = new ArrayList<>();
	}
	
	public abstract int getHandValue();
}
