package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>(52);
		for (Rank cardRank : Rank.values()) {
			for (Suit cardSuit : Suit.values()) {
				cards.add(new Card(cardRank, cardSuit));
			}
		}

	}

	public int cardDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
}
