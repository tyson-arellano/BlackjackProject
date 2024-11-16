package com.skilldistillery.cards.app;

import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	
	private Dealer dealer;
	private Player player;
	
	private Scanner sc;
	
	private BlackjackApp() {
		dealer = new Dealer();
		player = new Player();
		sc = new Scanner(System.in);
	
	}
	
	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.startGame();
		
	}

//	public Card dealInitialCards() {
//		
//	}
	public void startGame() {
		
		
	}

}
