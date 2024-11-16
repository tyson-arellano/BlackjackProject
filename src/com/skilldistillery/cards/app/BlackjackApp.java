package com.skilldistillery.cards.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.blackjack.BlackjackHand;
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

	public void dealInitialCards() {
		dealer.shuffle();
		player.hit(dealer.dealCard());
		dealer.hit(dealer.dealCard());
		player.hit(dealer.dealCard());
		dealer.hit(dealer.dealCard());
	}

	public void startGame() {
		boolean round = true;

		do {
			dealInitialCards();
			System.out.println(dealer.initial() + "\n");
			System.out.println(player + "\n");
			boolean keepGoing = true;

			do {
				if (player.hand.isBlackjack()) {
					System.out.println("Blackjack!!! It's now the Dealer's turn. \n");
				}
				System.out.println("Would you like to hit or stand? Type (h) for hit or (s) for stand. \n");
				String hitOrStand = sc.next();
				try {
					if (hitOrStand.equalsIgnoreCase("h")) {
						player.hit(dealer.dealCard());
						System.out.println(player + "\n");

						if (player.hand.isBust()) {
							System.out.println("Oops! You busted! Dealer wins!");
							keepGoing = false;
						}

						if (player.handValue() == 21) {
							System.out.println("You have 21! It's the Dealer's turn");
							keepGoing = false;
						}
					} else if (hitOrStand.equalsIgnoreCase("s")) {
						keepGoing = false;
					}

					else {

						throw new InputMismatchException("Invalid input. \n");
					}

				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					System.out.println(dealer.initial() + "\n");
					System.out.println(player + "\n");
				}

			} while (keepGoing);

			System.out.println(dealer + "\n");
			
		

			if (dealer.handValue() == player.handValue()) {
				System.out.println("Hands are equal. This round is a push.");
				round = false;
			}

		} while (round);
	}

}
